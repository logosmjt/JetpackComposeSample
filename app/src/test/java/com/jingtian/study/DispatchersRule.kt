package com.jingtian.study

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.ExternalResource

class DispatchersRule : ExternalResource() {
    val testDispatcher = TestCoroutineDispatcher()

    override fun before() {
        Dispatchers.setMain(testDispatcher)
    }

    override fun after() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
