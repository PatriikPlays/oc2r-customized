/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.common.util;

import li.cil.oc2r.api.API;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SoundEvents {
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, API.MOD_ID);

    ///////////////////////////////////////////////////////////////////

    public static final RegistryObject<SoundEvent> COMPUTER_RUNNING = register("computer_running");
    public static final RegistryObject<SoundEvent> FLOPPY_ACCESS = register("floppy_access");
    public static final RegistryObject<SoundEvent> FLOPPY_EJECT = register("floppy_eject");
    public static final RegistryObject<SoundEvent> FLOPPY_INSERT = register("floppy_insert");
    public static final RegistryObject<SoundEvent> HDD_ACCESS = register("hdd_access");

    ///////////////////////////////////////////////////////////////////

    public static void initialize() {
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    ///////////////////////////////////////////////////////////////////

    private static RegistryObject<SoundEvent> register(final String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(API.MOD_ID, name)));
    }
}
