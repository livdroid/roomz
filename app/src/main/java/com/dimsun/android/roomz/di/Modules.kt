package com.dimsun.android.roomz.di

import android.arch.persistence.room.Room
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.data.local.ContactRepo
import com.dimsun.android.roomz.data.local.ContactRepoImpl
import com.dimsun.android.roomz.ui.ContactUseCase
import com.dimsun.android.roomz.ui.ContactsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { ContactsViewModel(get()) }
    single { ContactUseCase(get()) }

    // ContactRepo
    single { ContactRepoImpl(get()) as ContactRepo }
    // Room Database
    single {
        Room.databaseBuilder(androidContext(), ContactDatabase::class.java, "contact-db")
            .build()
    }

    // contactDao
    single { get<ContactDatabase>().contactDao() }

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