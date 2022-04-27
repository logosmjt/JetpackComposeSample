package com.jingtian.study.home

import android.os.Parcelable
import com.jingtian.study.home.domain.Category
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


sealed class HomeViewState: Parcelable {
    @Parcelize
    data class Result(
        val category: String,
        val categoryList: List<String>,
        val recommendMap:@RawValue Map<String, Category>,
    ) : HomeViewState()

    @Parcelize
    object Error : HomeViewState()

    @Parcelize
    object Loading : HomeViewState()
}
