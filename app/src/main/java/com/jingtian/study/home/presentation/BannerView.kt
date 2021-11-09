package com.jingtian.study.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.jingtian.study.R
import com.jingtian.study.home.domain.Banner
import com.jingtian.study.home.domain.HomeItem
import com.jingtian.study.ui.theme.Medial

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun BannersView(
    banners: HomeItem.Banners,
    onBannerClick: (Banner) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = Medial)
    ) {
        val pagerState = rememberPagerState()

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            count = banners.list.size,
        ) { page ->
            BannerView(banners.list[page], onBannerClick)
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BannerView(
    banner: Banner,
    onBannerClick: (Banner) -> Unit
) {
    Image(
        painter = rememberImagePainter(
            data = banner.thumbnailURL,
            builder = {
                size(OriginalSize)
            },
        ),
        contentDescription = stringResource(R.string.banner),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onBannerClick(banner) },
        contentScale = ContentScale.Crop,
    )
}
