package org.polyfrost.oneconfig.internal.mixin.compat;

import me.owdding.lib.overlays.Overlay;
import me.owdding.lib.overlays.Overlays;
import org.polyfrost.oneconfig.internal.compat.MeowddingHudCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Overlays.class, remap = false)
public class Mixin_Meowdding_Overlays {

    @Inject(method = "register", at = @At("HEAD"))
    public void registerHook(Overlay overlay, CallbackInfo ci) {
        MeowddingHudCompat.register(overlay);
    }

}
