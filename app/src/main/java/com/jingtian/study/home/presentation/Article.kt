package com.jingtian.study.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jingtian.study.R
import com.jingtian.study.home.domain.Article
import com.jingtian.study.home.domain.HomeItem
import com.jingtian.study.ui.theme.Elevation
import com.jingtian.study.ui.theme.Medial
import com.jingtian.study.ui.theme.Small

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun ArticlesView(
    articles: HomeItem.Articles,
    onArticleClick: (Article) -> Unit
) {
    Column {
        val layoutDir = LocalLayoutDirection.current
        val contentPadding =
            PaddingValues(horizontal = Medial)

        Text(
            text = articles.title,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(Medial),
        )

        LazyRow(
            contentPadding = PaddingValues(
                start = (contentPadding.calculateStartPadding(layoutDir)).coerceAtLeast(0.dp),
                top = contentPadding.calculateTopPadding(),
                end = (contentPadding.calculateEndPadding(layoutDir)).coerceAtLeast(0.dp),
                bottom = contentPadding.calculateBottomPadding(),
            ),
            horizontalArrangement = Arrangement.spacedBy(Medial)
        ) {
            items(articles.list) { ArticleView(it, onArticleClick) }
        }
    }
}

@ExperimentalMaterialApi
@Composable
internal fun ArticleView(
    article: Article,
    onArticleClick: (Article) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .clickable { onArticleClick(article) }
            .height(249.dp)
            .width(260.dp),
        elevation = Elevation,
    ) {
        Column {
            Image(
                painter = rememberImagePainter(article.thumbnailURL) { crossfade(true) },
                contentDescription = stringResource(R.string.article),
                modifier = Modifier
                    .height(145.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = article.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(Small),
            )

            Text(
                text = article.subtitle,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(Small),
            )
        }
    }
}
