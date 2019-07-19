package com.dimsun.android.roomz.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dimsun.android.roomz.RoomzApplication
import com.dimsun.android.roomz.data.local.ContactDatabase
import com.dimsun.android.roomz.data.local.ContactRepo
import com.dimsun.android.roomz.data.local.ContactRepoImpl
import com.dimsun.android.roomz.ui.ContactUseCase
import com.dimsun.android.roomz.ui.ContactsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val applicationModule = module {

    viewModel { ContactsViewModel(get()) }
    single { ContactUseCase(androidContext()) }

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