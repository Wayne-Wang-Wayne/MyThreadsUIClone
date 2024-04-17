package com.example.mythreadsuiclone.ui.commonComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun HalfCoverRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        val totalWidth = placeables.sumOf { it.width / 2 } + placeables[0].width / 2
        layout(totalWidth, constraints.maxHeight) {
            var xPosition = 0

            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = 0)

                xPosition += placeable.width / 2
            }
        }
    }
}