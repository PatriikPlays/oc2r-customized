/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.client.item;

import li.cil.oc2r.api.API;
import li.cil.oc2r.common.item.Items;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public final class CustomItemModelProperties {
    public static final ResourceLocation COLOR_PROPERTY = new ResourceLocation(API.MOD_ID, "color");

    ///////////////////////////////////////////////////////////////////

    public static void initialize() {
        ItemProperties.register(Items.HARD_DRIVE_SMALL.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_MEDIUM.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_LARGE.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_EXTRA_LARGE.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_HC1.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_HC2.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_HC3.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.HARD_DRIVE_CUSTOM.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.FLOPPY.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
        ItemProperties.register(Items.FLOPPY_MODERN.get(), CustomItemModelProperties.COLOR_PROPERTY,
            (stack, level, entity, seed) -> CustomItemColors.getColor(stack));
    }
}
