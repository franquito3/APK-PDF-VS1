package com.chethan616.clearpdf.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chethan616.clearpdf.ui.theme.LocalIsDarkMode
import com.chethan616.clearpdf.ui.utils.UISensor
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy
import com.kyant.backdrop.highlight.Highlight
import com.kyant.backdrop.highlight.HighlightStyle
import com.kyant.backdrop.shadow.InnerShadow
import com.kyant.backdrop.shadow.Shadow
import com.kyant.shapes.RoundedRectangle

/** Dark, mostly-opaque glass base for PDF-viewer chrome so white text stays readable
 *  over bright pages, while the lens/blur/highlight refraction is preserved. */
val ViewerChromeGlass: Color = Color(0xFF12151C).copy(alpha = 0.62f)

@Composable
fun Modifier.liquidGlassPanel(
    backdrop: Backdrop,
    uiSensor: UISensor,
    // Performance-first mode: the app now uses simple flat surfaces instead of expensive backdrop
    // rendering. This keeps the interface readable and stable on mid-range devices.
    containerColorOverride: Color? = null
): Modifier {
    val isDarkMode = LocalIsDarkMode.current
    val isLightTheme = !isDarkMode
    val containerColor = containerColorOverride
        ?: if (isLightTheme) Color(0xFFF7F7F8).copy(0.92f) else Color(0xFF171B22).copy(0.92f)
    val borderColor = if (isLightTheme) Color.White.copy(0.75f) else Color.White.copy(0.10f)
    return this
        .background(containerColor, RoundedCornerShape(28.dp))
        .border(1.dp, borderColor, RoundedCornerShape(28.dp))
}
