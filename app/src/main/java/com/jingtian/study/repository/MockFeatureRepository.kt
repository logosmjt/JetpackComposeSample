package com.jingtian.study.repository

import com.jingtian.study.home.domain.Article
import com.jingtian.study.home.domain.Banner
import com.jingtian.study.home.domain.Category
import com.jingtian.study.home.domain.HomeItem
import com.jingtian.study.home.domain.Recommend
import javax.inject.Inject
import kotlin.random.Random
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockFeatureRepository @Inject constructor() : FeatureRepository {
    override fun categories(): Flow<Recommend> {
        return flowOf(Recommend(mockCategories))
    }

    private val articleTitles = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
    )

    private val images = listOf(
        "","",
        )

    private val mockChineseCategory = Category(
        name = "Chinese",
        list = listOf(
            mockBanners(),
            mockArticles("literature"),
            mockArticles("history"),
            mockActivity("Christmas promotion"),
            mockActivity("Over 500, reduce by 100"),
            mockActivity("20% off promotion"),
            mockArticles("philosophy"),
            mockArticles("art"),
            mockArticles("tour"),
            mockArticles("cook"),
            mockArticles("tech"),
        )
    )

    private val mockEnglishCategory = Category(
        name = "English",
        list = listOf(
            mockBanners(),
            mockArticles("literature"),
            mockArticles("history"),
            mockActivity("Christmas promotion"),
            mockActivity("Over 500, reduce by 100"),
            mockActivity("20% off promotion"),
            mockArticles("philosophy"),
            mockArticles("tour"),
            mockArticles("art"),
            mockArticles("cook"),
            mockArticles("tech"),
        )
    )

    private val mockFrenchCategory = Category(
        name = "French",
        list = listOf(
            mockBanners(),
            mockArticles("literature"),
            mockActivity("20% off promotion"),
            mockArticles("history"),
            mockArticles("art"),
            mockActivity("Christmas promotion"),
            mockArticles("philosophy"),
            mockArticles("tour"),
            mockActivity("Over 500, reduce by 100"),
            mockArticles("cook"),
            mockArticles("tech"),
        )
    )

    private val mockJapaneseCategory = Category(
        name = "Japanese",
        list = listOf(
            mockBanners(),
            mockArticles("literature"),
            mockActivity("Over 500, reduce by 100"),
            mockArticles("history"),
            mockActivity("20% off promotion"),
            mockArticles("philosophy"),
            mockArticles("art"),
            mockActivity("Christmas promotion"),
            mockArticles("tour"),
            mockArticles("cook"),
            mockArticles("tech"),
        )
    )

    private val mockCategories = listOf(
        mockChineseCategory,
        mockEnglishCategory,
        mockFrenchCategory,
        mockJapaneseCategory,
    )

    private fun mockActivity(title: String) = HomeItem.Activity(
        title = title,
        thumbnailURL = getRandomImage(),
        activityURL = "this is a link for $title"
    )

    private fun mockBanners() = HomeItem.Banners(
        listOf(
            mockBanner(),
            mockBanner(),
            mockBanner()
        )
    )

    private fun mockBanner() = Banner(
        thumbnailURL = getRandomImage(),
        activityURL = "this is a link for banner"
    )

    private fun mockArticles(title: String) = HomeItem.Articles(
        title = title,
        listOf(
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
            mockArticle(
                title = "title ${getRandomArticleTile()}",
                thumbnailURL = getRandomImage()
            ),
        )
    )

    private fun mockArticle(title: String, thumbnailURL: String) = Article(
        title = title,
        subtitle = "Subtitle for $title",
        thumbnailURL = thumbnailURL,
        articleURL = "this is a link for $title"
    )

    private fun getRandomImage() =
        images[Random.nextInt(from = 0, until = images.size - 1)]

    private fun getRandomArticleTile() =
        articleTitles[Random.nextInt(from = 0, until = articleTitles.size - 1)]
}
