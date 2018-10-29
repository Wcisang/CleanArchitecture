package br.com.wcisang.mobile_ui.injection.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application) : Context
}