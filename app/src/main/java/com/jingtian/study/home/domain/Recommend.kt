package com.jingtian.study.home.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recommend(val list: List<Category>): Parcelable

@Parcelize
data class Category(
    val name: String = "",
    val list: List<HomeItem> = emptyList()
): Parcelable

sealed class HomeItem: Parcelable {

    @Parcelize
    data class Banners(
        val list: List<Banner>,
    ) : HomeItem()

    @Parcelize
    data class Activity(
        val title: String,
        val thumbnailURL: String,
        val activityURL: String,
    ) : HomeItem()

    @Parcelize
    data class Articles(
        val title: String,
        val list: List<Article>
    ) : HomeItem()
}

@Parcelize
data class Banner(
    val thumbnailURL: String,
    val activityURL: String,
): Parcelable

@Parcelize
data class Article(
    var title: String,
    val subtitle: String,
    val thumbnailURL: String,
    val articleURL: String,
): Parcelable
