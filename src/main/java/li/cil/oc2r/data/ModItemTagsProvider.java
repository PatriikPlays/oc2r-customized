/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.data;

import li.cil.oc2r.common.item.Items;
import li.cil.oc2r.common.tags.BlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import java.util.concurrent.CompletableFuture;

import static li.cil.oc2r.common.tags.ItemTags.*;

public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(
        final PackOutput output,
        final CompletableFuture<HolderLookup.Provider> lookupProvider,
        final CompletableFuture<TagLookup<Block>> tagLookup,
        final String modId,
        @Nullable final ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookup, modId, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        copy(BlockTags.CABLES, CABLES);

        copy(BlockTags.DEVICES, DEVICES);
        tag(DEVICES).addTags(
            DEVICES_MEMORY,
            DEVICES_HARD_DRIVE,
            DEVICES_FLASH_MEMORY,
            DEVICES_CARD,
            DEVICES_ROBOT_MODULE,
            DEVICES_FLOPPY
        );
        tag(DEVICES_MEMORY).add(
            Items.MEMORY_SMALL.get(),
            Items.MEMORY_MEDIUM.get(),
            Items.MEMORY_LARGE.get(),
            Items.MEMORY_EXTRA_LARGE.get(),
            Items.MEMORY_HC1.get()
        );
        tag(DEVICES_HARD_DRIVE).add(
            Items.HARD_DRIVE_SMALL.get(),
            Items.HARD_DRIVE_MEDIUM.get(),
            Items.HARD_DRIVE_LARGE.get(),
            Items.HARD_DRIVE_EXTRA_LARGE.get(),
            Items.HARD_DRIVE_HC1.get(),
            Items.HARD_DRIVE_HC2.get(),
            Items.HARD_DRIVE_HC3.get(),
            Items.HARD_DRIVE_CUSTOM.get()
        );
        tag(DEVICES_FLASH_MEMORY).add(
            Items.FLASH_MEMORY.get(),
            Items.FLASH_MEMORY_CUSTOM.get()
        );
        tag(DEVICES_FLOPPY).add(
            Items.FLOPPY.get(),
            Items.FLOPPY_MODERN.get()
        );
        tag(DEVICES_CARD).add(
            Items.REDSTONE_INTERFACE_CARD.get(),
            Items.NETWORK_INTERFACE_CARD.get(),
            Items.FILE_IMPORT_EXPORT_CARD.get(),
            Items.SOUND_CARD.get(),
            Items.NETWORK_TUNNEL_CARD.get()
        );
        tag(DEVICES_ROBOT_MODULE).add(
            Items.INVENTORY_OPERATIONS_MODULE.get(),
            Items.BLOCK_OPERATIONS_MODULE.get(),
            Items.NETWORK_TUNNEL_MODULE.get()
        );
        tag(DEVICES_NETWORK_TUNNEL).add(
            Items.NETWORK_TUNNEL_CARD.get(),
            Items.NETWORK_TUNNEL_MODULE.get()
        );

        tag(WRENCHES).add(Items.WRENCH.get());

        tag(DEVICE_NEEDS_REBOOT).add(
            Items.DISK_DRIVE.get(),
            Items.FLASH_MEMORY.get(),
            Items.FLASH_MEMORY_CUSTOM.get(),
            Items.HARD_DRIVE_SMALL.get(),
            Items.HARD_DRIVE_MEDIUM.get(),
            Items.HARD_DRIVE_LARGE.get(),
            Items.HARD_DRIVE_EXTRA_LARGE.get(),
            Items.HARD_DRIVE_HC1.get(),
            Items.HARD_DRIVE_HC2.get(),
            Items.HARD_DRIVE_HC3.get(),
            Items.HARD_DRIVE_CUSTOM.get(),
            Items.CPU_TIER_1.get(),
            Items.CPU_TIER_2.get(),
            Items.CPU_TIER_3.get(),
            Items.CPU_TIER_4.get(),
            Items.KEYBOARD.get(),
            Items.MEMORY_SMALL.get(),
            Items.MEMORY_MEDIUM.get(),
            Items.MEMORY_LARGE.get(),
            Items.MEMORY_EXTRA_LARGE.get(),
            Items.MEMORY_HC1.get(),
            Items.NETWORK_INTERFACE_CARD.get(),
            Items.NETWORK_TUNNEL_CARD.get(),
            Items.NETWORK_TUNNEL_MODULE.get(),
            Items.PROJECTOR.get()
        );

        tag(DEVICES_CPU).add(
            Items.CPU_TIER_1.get(),
            Items.CPU_TIER_2.get(),
            Items.CPU_TIER_3.get(),
            Items.CPU_TIER_4.get()
        );
    }
}
