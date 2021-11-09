package com.jingtian.study.home.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jingtian.study.ui.theme.Border
import com.jingtian.study.ui.theme.BorderSelected
import com.jingtian.study.ui.theme.JetpackComposeSampleTheme
import com.jingtian.study.ui.theme.Medial
import com.jingtian.study.ui.theme.Small

@ExperimentalMaterialApi
@Composable
internal fun Selectors(
    selectors: List<String>,
    current: String,
    onSelected: (String) -> Unit
) {
    val layoutDir = LocalLayoutDirection.current
    val contentPadding =
        PaddingValues(horizontal = Medial)

    LazyRow(
        modifier = Modifier.padding(bottom = Medial),
        contentPadding = PaddingValues(
            start = (contentPadding.calculateStartPadding(layoutDir)).coerceAtLeast(0.dp),
            top = contentPadding.calculateTopPadding(),
            end = (contentPadding.calculateEndPadding(layoutDir)).coerceAtLeast(0.dp),
            bottom = contentPadding.calculateBottomPadding(),
        ),
        horizontalArrangement = Arrangement.spacedBy(Small)
    ) {
        items(selectors) { selector ->
            Selector(selector, selector == current) {
                if (selector != current) onSelected(selector)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
internal fun Selector(
    title: String,
    isSelected: Boolean,
    onSelected: (() -> Unit),
) {
    Surface(
        border = if (isSelected) BorderStroke(
            BorderSelected,
            MaterialTheme.colors.primaryVariant
        ) else BorderStroke(
            Border,
            MaterialTheme.colors.secondary
        ),
        color = if (isSelected) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.secondary,
        shape = CircleShape,
        onClick = onSelected,
    ) {
        Text(
            text = title,
            style = if (isSelected) MaterialTheme.typography.body1 else MaterialTheme.typography.body2,
            modifier = Modifier.padding(
                Medial, Small
            )
        )
    }
}

@ExperimentalMaterialApi
@Preview(name = "Selector")
@Composable
internal fun SelectorPreview() {
    JetpackComposeSampleTheme(darkTheme = false) {
        Selector(
            "Text", false, {}
        )
    }
}

@ExperimentalMaterialApi
@Preview(name = "Selector is selected")
@Composable
internal fun SelectorSelectedPreview() {
    JetpackComposeSampleTheme(darkTheme = false) {
        Selector(
            "Text", true, {}
        )
    }
}
