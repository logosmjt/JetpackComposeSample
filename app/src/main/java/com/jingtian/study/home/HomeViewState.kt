package com.jingtian.study.home

import com.jingtian.study.home.domain.Category

sealed class HomeViewState {
    data class Result(
        val category: Category,
    ) : HomeViewState()

    object Error : HomeViewState()

    object Loading : HomeViewState()
}
