package com.jingtian.study.home.domain

data class Recommend(val list: List<Category>)

data class Category(
    val name: String = "",
    val list: List<HomeItem> = emptyList()
)

sealed class HomeItem {

    data class Banners(
        val list: List<Banner>,
    ) : HomeItem()

    data class Activity(
        val title: String,
        val thumbnailURL: String,
        val activityURL: String,
    ) : HomeItem()

    data class Articles(
        val title: String,
        val list: List<Article>
    ) : HomeItem()
}

data class Banner(
    val thumbnailURL: String,
    val activityURL: String,
)

data class Article(
    var title: String,
    val subtitle: String,
    val thumbnailURL: String,
    val articleURL: String,
)
