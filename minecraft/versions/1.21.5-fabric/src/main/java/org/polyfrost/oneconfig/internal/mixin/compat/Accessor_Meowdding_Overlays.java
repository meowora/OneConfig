package org.polyfrost.oneconfig.internal.mixin.compat;

import me.owdding.lib.overlays.Overlay;
import me.owdding.lib.overlays.Overlays;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(Overlays.class)
public interface Accessor_Meowdding_Overlays {

    @Accessor(value = "overlays", remap = false)
    List<Overlay> getOverlays();

}
