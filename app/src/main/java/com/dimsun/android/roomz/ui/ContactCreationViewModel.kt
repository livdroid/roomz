package com.dimsun.android.roomz.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class ContactCreationViewModel(private val contactUseCase: ContactUseCase): ViewModel(),
    CoroutineScope {

    private var parentJob = Job()
    override val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

}