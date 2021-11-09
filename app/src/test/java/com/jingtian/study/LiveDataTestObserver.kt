package com.jingtian.study

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class LiveDataTestObserver<T> : Observer<T> {

    val observedValues: MutableList<T> = mutableListOf<T>()

    override fun onChanged(value: T) {
        observedValues.add(value)
    }
}

fun <T> LiveData<T>.testObserver(): LiveDataTestObserver<T> = LiveDataTestObserver<T>()
    .also { observeForever(it) }
