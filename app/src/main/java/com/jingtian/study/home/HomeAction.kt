package com.jingtian.study.home

import com.jingtian.study.home.domain.Article
import com.jingtian.study.home.domain.Banner
import com.jingtian.study.home.domain.HomeItem

sealed class HomeAction {
    data class CategorySelected(val category: String) : HomeAction()
    data class NavigateToBanner(val banner: Banner) : HomeAction()
    data class NavigateToActivity(val activity: HomeItem.Activity) : HomeAction()
    data class NavigateToArticle(val article: Article) : HomeAction()
    object Retry : HomeAction()
}
