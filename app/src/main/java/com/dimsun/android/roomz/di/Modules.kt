package com.dimsun.android.roomz.di

import com.dimsun.android.roomz.ui.ContactsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { ContactsViewModel(get())}
}