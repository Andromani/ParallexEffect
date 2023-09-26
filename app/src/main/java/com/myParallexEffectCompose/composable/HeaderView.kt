package com.myParallexEffectCompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.myParallexEffectCompose.R
import com.myParallexEffectCompose.ui.theme.Black900

@Composable
fun HeaderView(headerHeight: Dp, headerHeightPx: Float, scrollState: ScrollState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(headerHeight)
            .graphicsLayer {
                translationY = -scrollState.value.toFloat() / 2f
                alpha = (-1f / headerHeightPx) * scrollState.value + 1
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.food_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Black900),
                        startY = 3 * headerHeightPx / 4
                    )
                )
        )
    }
}