package com.dimsun.android.roomz.di

import com.dimsun.android.roomz.ui.ContactCreationViewModel
import com.dimsun.android.roomz.ui.ContactUseCase
import com.dimsun.android.roomz.ui.MainViewModel
import com.dimsun.android.roomz.util.Navigation
import com.dimsun.android.roomz.util.NavigationImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {

    viewModel { MainViewModel(get(), get()) }
    viewModel { ContactCreationViewModel(get()) }

    single { ContactUseCase(androidContext()) }
    single <Navigation> { NavigationImpl(androidContext())}


    // Room Database

        /*
    single { get<ContactDatabase>().contactDao() }


    single {
        Room.databaseBuilder(
            androidContext(),
            ContactDatabase::class.java,
            "contact_db")
            .build()
    }
    */

    // contactDao

    //OR

    /*
    single {
        Room.databaseBuilder(
            androidContext(),
            ContactDatabase::class.java,
            "github_repo_database"
        ).build().contactDao()
    }
    */
}