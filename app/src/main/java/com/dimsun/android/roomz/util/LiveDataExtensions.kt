package com.dimsun.android.roomz.util

import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun <T> LiveData<T>.observeOnceAsync(onChangeHandler: (T) -> Unit) {
    val observer = OneTimeObserver(handler = onChangeHandler)
    GlobalScope.launch {
        observe(observer, observer)
    }
}

fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
    val observer = OneTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}

/**
 * Observer implementation that owns its lifecycle and achieves a one-time only observation
 * by marking it as destroyed once the onChange handler is executed.
 *
 * @param handler the handler to execute on change.
 */

class OneTimeObserver<T>(private val handler: (T) -> Unit) : Observer<T>, LifecycleOwner {

    private val lifecycle = LifecycleRegistry(this)

    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun getLifecycle(): Lifecycle = lifecycle

    override fun onChanged(t: T?) {
        if (t != null) {
            handler(t)
        }
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }
}
