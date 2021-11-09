package com.jingtian.study

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

open class ViewModelTest {
    @get:Rule
    val dispatchersRule = DispatchersRule()

    @get:Rule
    val executorRule = InstantTaskExecutorRule()
}
