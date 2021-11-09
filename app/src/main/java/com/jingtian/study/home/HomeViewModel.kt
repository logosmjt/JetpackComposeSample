package com.jingtian.study.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jingtian.study.home.domain.Category
import com.jingtian.study.home.domain.Recommend
import com.jingtian.study.repository.FeatureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FeatureRepository
) : ViewModel() {

    private val _state = MutableLiveData<HomeViewState>()
    val state = _state
    private val _categories = MutableLiveData<List<String>>()
    val categories: LiveData<List<String>> = _categories
    private val recommendMap = MutableLiveData<Map<String, Category>>()
    private val pendingActions = MutableSharedFlow<HomeAction>()

    init {
        viewModelScope.launch {
            fetchRecommends()
            pendingActions.collect {
                when (it) {
                    is HomeAction.CategorySelected -> onCategorySelected(it.category)
                }
            }
        }
    }

    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private suspend fun fetchRecommends() {
        repository.categories()
            .flowOn(Dispatchers.IO)
            .map { it.toHomeViewState() }
            .catch { HomeViewState.Error }
            .collect { _state.value = it }
    }

    private fun onCategorySelected(category: String) {
        _state.value = if (recommendMap.value?.get(category) != null) {
            HomeViewState.Result(
                recommendMap.value?.get(category)!!
            )
        } else {
            HomeViewState.Error
        }
    }

    private fun Recommend.toHomeViewState(): HomeViewState {
        if (this.list.isEmpty())
            return HomeViewState.Error
        val remoteCategories: MutableList<String> = mutableListOf()
        val remoteRecommendMap: MutableMap<String, Category> = mutableMapOf()
        this.list.forEach { category ->
            remoteCategories.add(category.name)
            remoteRecommendMap[category.name] = category
        }
        _categories.value = remoteCategories
        recommendMap.value = remoteRecommendMap
        return HomeViewState.Result(this.list[0])
    }
}
