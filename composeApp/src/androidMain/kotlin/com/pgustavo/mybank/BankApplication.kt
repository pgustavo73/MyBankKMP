package com.pgustavo.mybank

import android.app.Application
import com.pgustavo.mybank.di.initKoin
import org.koin.android.ext.koin.androidContext


class BankApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BankApplication)
        }
    }
}