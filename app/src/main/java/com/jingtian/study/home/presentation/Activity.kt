package com.jingtian.study.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.jingtian.study.R
import com.jingtian.study.home.domain.HomeItem
import com.jingtian.study.ui.theme.Elevation
import com.jingtian.study.ui.theme.Medial

@ExperimentalMaterialApi
@Composable
fun Activity(
    activity: HomeItem.Activity,
    onActivityClick: (HomeItem.Activity) -> Unit
) {
    Card(
        modifier = Modifier.padding(top = Medial, start = Medial, end = Medial),
        elevation = Elevation
    ) {
        Image(
            painter = rememberImagePainter(
                data = activity.thumbnailURL,
                builder = {
                    size(OriginalSize)
                },
            ),
            contentDescription = stringResource(R.string.banner),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = activity.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(Medial)
        )
    }
}
