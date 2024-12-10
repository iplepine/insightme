package com.jyoon.core.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.DpSize
import com.jyoon.core.compose.compositionlocal.LoggerCompositionLocal

@Composable
fun calculateSize(content: @Composable () -> Unit): MutableState<DpSize?> {
    val measuredSize: MutableState<DpSize?> = remember(content) { mutableStateOf(null) }

    if (measuredSize.value == null) {
        MeasureSizeOnly(
            content = content,
            onSizeCalculated = { size ->
                measuredSize.value = size
            }
        )
    }

    return measuredSize
}

@Composable
fun MeasureSizeOnly(
    content: @Composable () -> Unit,
    onSizeCalculated: (DpSize) -> Unit
) {
    val logger = LoggerCompositionLocal.current
    SubcomposeLayout { constraints ->
        // 콘텐츠를 측정
        val placeables = subcompose("MeasureOnly", content).map {
            it.measure(constraints)
        }

        // 크기 계산
        val totalWidth = placeables.maxOf { it.width }
        val totalHeight = placeables.maxOf { it.height }

        logger.d("measureSize", "totalWidth: $totalWidth, totalHeight: $totalHeight")

        // 크기를 콜백으로 반환
        onSizeCalculated(DpSize(totalWidth.toDp(), totalHeight.toDp()))

        // 빈 레이아웃 반환 (아무것도 그리지 않음)
        layout(0, 0) {}
    }
}
