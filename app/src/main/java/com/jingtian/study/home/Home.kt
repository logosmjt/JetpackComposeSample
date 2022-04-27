package com.jingtian.study.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jingtian.study.home.domain.HomeItem
import com.jingtian.study.home.presentation.Activity
import com.jingtian.study.home.presentation.ArticlesView
import com.jingtian.study.home.presentation.BannersView
import com.jingtian.study.home.presentation.Selectors
import com.jingtian.study.ui.theme.Medial

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
internal fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state.observeAsState().value
    Column {
        when (state) {
            is HomeViewState.Result -> {
                HomeContent(state, viewModel)
            }
            HomeViewState.Error -> {
                ErrorContent()
            }
            HomeViewState.Loading -> {
                LoadingContent()
            }
        }
    }
}


@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
internal fun HomeContent(
    state: HomeViewState.Result,
    viewModel: HomeViewModel,
) {
    val categories = state.categoryList
    val category = state.recommendMap[state.category]

    LazyColumn(
        contentPadding = PaddingValues(top = Medial, bottom = Medial),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            Selectors(
                selectors = categories,
                current = state.category,
                onSelected = { viewModel.submitAction(HomeAction.CategorySelected(it)) }
            )
        }

        category?.list?.let {
            items(it) { item ->
                when (item) {
                    is HomeItem.Banners -> {
                        BannersView(
                            item
                        ) { viewModel.submitAction(HomeAction.NavigateToBanner(it)) }
                    }
                    is HomeItem.Activity -> {
                        Activity(
                            item
                        ) { viewModel.submitAction(HomeAction.NavigateToActivity(it)) }
                    }
                    is HomeItem.Articles -> {
                        ArticlesView(
                            item
                        ) { viewModel.submitAction(HomeAction.NavigateToArticle(it)) }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
internal fun ErrorContent() {
}

@ExperimentalMaterialApi
@Composable
internal fun LoadingContent() {
}
