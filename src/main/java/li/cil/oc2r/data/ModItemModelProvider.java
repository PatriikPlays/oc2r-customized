/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.data;

import li.cil.oc2r.api.API;
import li.cil.oc2r.common.entity.Entities;
import li.cil.oc2r.common.item.Items;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(final PackOutput output, final ExistingFileHelper existingFileHelper) {
        super(output, API.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simple(Items.WRENCH);
        simple(Items.MANUAL);

        simple(Items.NETWORK_CABLE);

        simple(Items.MEMORY_SMALL);
        simple(Items.MEMORY_MEDIUM);
        simple(Items.MEMORY_LARGE);
        simple(Items.MEMORY_EXTRA_LARGE);
        simple(Items.MEMORY_HC1);
        simple(Items.CPU_TIER_1);
        simple(Items.CPU_TIER_2);
        simple(Items.CPU_TIER_3);
        simple(Items.CPU_TIER_4);
        simple(Items.SILICON);
        simple(Items.SILICON_BLEND);
        simple(Items.SILICON_WAFER);
        simple(Items.RAW_SILICON_WAFER);
        simple(Items.HARD_DRIVE_SMALL, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_MEDIUM, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_LARGE, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_EXTRA_LARGE, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_HC1, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_HC2, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_HC3, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.HARD_DRIVE_CUSTOM, "item/hard_drive_base")
            .texture("layer1", "item/hard_drive_tint");
        simple(Items.FLASH_MEMORY);
        simple(Items.FLASH_MEMORY_CUSTOM, "item/flash_memory");
        simple(Items.FLOPPY, "item/floppy_base")
            .texture("layer1", "item/floppy_tint");
        simple(Items.FLOPPY_MODERN, "item/floppy_base")
            .texture("layer1", "item/floppy_tint");

        simple(Items.REDSTONE_INTERFACE_CARD);
        simple(Items.NETWORK_INTERFACE_CARD);
        simple(Items.FILE_IMPORT_EXPORT_CARD);
        simple(Items.SOUND_CARD);
        simple(Items.NETWORK_TUNNEL_CARD);

        simple(Items.INVENTORY_OPERATIONS_MODULE);
        simple(Items.BLOCK_OPERATIONS_MODULE);
        simple(Items.NETWORK_TUNNEL_MODULE);

        simple(Items.TRANSISTOR);
        simple(Items.CIRCUIT_BOARD);

        withExistingParent(Entities.ROBOT.getId().getPath(), "template_shulker_box");
    }

    private <T extends Item> void simple(final RegistryObject<T> item) {
        simple(item, "item/" + item.getId().getPath());
    }

    private <T extends Item> ItemModelBuilder simple(final RegistryObject<T> item, final String texturePath) {
        return singleTexture(item.getId().getPath(),
            new ResourceLocation("item/generated"),
            "layer0",
            new ResourceLocation(API.MOD_ID, texturePath));
    }
}
