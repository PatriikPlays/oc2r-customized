/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.common.bus.device.rpc;

import li.cil.oc2r.common.util.NBTTagIds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

public final class RPCItemStackTagFilter {
    public ResourceLocation item;
    public String[] tags;

    private String[][] paths; // Cache of resolved paths specified in tags.

    ///////////////////////////////////////////////////////////////////

    @Nullable
    public CompoundTag apply(final ItemStack stack, final CompoundTag tag) {
        if (stack.isEmpty() || tags == null) {
            return null;
        }

        if (item != null && !Objects.equals(ForgeRegistries.ITEMS.getKey(stack.getItem()), item)) {
            return null;
        }

        validatePaths();

        final CompoundTag filtered = new CompoundTag();
        for (final String[] path : paths) {
            final CompoundTag filteredByPath = filterPath(path, tag);
            if (filteredByPath != null) {
                filtered.merge(filteredByPath);
            }
        }

        return filtered;
    }

    ///////////////////////////////////////////////////////////////////

    @Nullable
    private CompoundTag filterPath(final String[] path, final CompoundTag source) {
        if (path.length == 0) {
            return null;
        }

        final CompoundTag result = new CompoundTag();

        CompoundTag currentSource = source;
        CompoundTag currentTarget = result;
        for (int j = 0; j < path.length - 1; j++) {
            final String segment = path[j];
            if (currentSource.contains(segment, NBTTagIds.TAG_COMPOUND)) {
                currentSource = currentSource.getCompound(segment);
                currentTarget.put(segment, new CompoundTag());
                currentTarget = currentTarget.getCompound(segment);
            } else {
                return null; // Path mismatch, inner element is not a compound tag.
            }
        }

        final Tag tag = currentSource.get(path[path.length - 1]);
        if (tag == null) {
            return null; // Cannot find tag at path.
        }

        currentTarget.put(path[path.length - 1], tag);

        return result;
    }

    private void validatePaths() {
        paths = new String[tags.length][];
        for (int i = 0; i < tags.length; i++) {
            if (!StringUtil.isNullOrEmpty(tags[i])) {
                paths[i] = tags[i].split("\\.");
            }
        }
    }
}
