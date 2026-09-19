package com.chethan616.clearpdf.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastCoerceAtMost
import androidx.compose.ui.util.lerp
import com.chethan616.clearpdf.ui.utils.InteractiveHighlight
import com.kyant.backdrop.Backdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy
import androidx.compose.foundation.shape.CircleShape
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tanh

/**
 * Circular variant of LiquidButton, optimized for icons.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiquidIconButton(
    onClick: () -> Unit,
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    isInteractive: Boolean = true,
    tint: Color = Color.Unspecified,
    surfaceColor: Color = Color.Unspecified,
    onLongClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val baseColor = if (tint.isSpecified) tint.copy(alpha = 0.22f) else Color.White.copy(alpha = 0.08f)
    val fillColor = if (surfaceColor.isSpecified) surfaceColor.copy(alpha = 0.92f) else baseColor

    Box(
        modifier
            .size(40.dp)
            .background(fillColor, CircleShape)
            .border(1.dp, Color.White.copy(alpha = 0.12f), CircleShape)
            .then(
                if (onLongClick != null)
                    Modifier.combinedClickable(
                        interactionSource = null,
                        indication = null,
                        role = Role.Button,
                        onClick = onClick,
                        onLongClick = onLongClick
                    )
                else
                    Modifier.clickable(
                        interactionSource = null,
                        indication = null,
                        role = Role.Button,
                        onClick = onClick
                    )
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
