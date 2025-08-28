package org.polyfrost.oneconfig.internal.compat

import dev.deftu.omnicore.client.render.OmniMatrixStack
import me.owdding.lib.overlays.Overlay
import me.owdding.lib.overlays.Overlays
import org.apache.commons.lang3.StringUtils.overlay
import org.polyfrost.oneconfig.api.hud.v1.Hud
import org.polyfrost.oneconfig.api.hud.v1.HudManager
import org.polyfrost.oneconfig.api.hud.v1.LegacyHud
import org.polyfrost.oneconfig.internal.mixin.compat.Accessor_Meowdding_Overlays

object MeowddingHudCompat {

    init {
        loadOverlays()
    }

    fun loadOverlays() {
        (Overlays as? Accessor_Meowdding_Overlays)?.overlays?.forEach { overlay ->
            register(overlay)
        }
    }

    @JvmStatic
    fun register(overlay: Overlay) {
        HudManager.register(MeowddingHudCompat(overlay))
    }

    data class MeowddingHudCompat(val overlay: Overlay) :
        LegacyHud("meowdding:${overlay.modId}:${overlay.hashCode()}", overlay.name.string, Hud.Category.COMPAT) {
        override var width: Float
            get() = overlay.bounds.first.toFloat()
            set(value) {}
        override var height: Float
            get() =  overlay.bounds.second.toFloat()
            set(value) {}

        override fun render(
            stack: OmniMatrixStack,
            x: Float,
            y: Float,
            scaleX: Float,
            scaleY: Float,
            example: Boolean,
        ) {

        }

        override fun update(): Boolean {
            return true
        }

    }
}