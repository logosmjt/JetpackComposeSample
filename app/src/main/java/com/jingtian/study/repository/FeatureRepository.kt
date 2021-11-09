package com.jingtian.study.repository

import com.jingtian.study.home.domain.Recommend
import kotlinx.coroutines.flow.Flow

interface FeatureRepository {

    fun categories(): Flow<Recommend>
}
