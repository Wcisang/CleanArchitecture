package br.com.wcisang.mobile_ui.test

import android.app.Activity
import android.app.Application
import br.com.wcisang.mobile_ui.injection.DaggerTestApplicationComponent
import br.com.wcisang.mobile_ui.injection.TestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TestApplication : Application(), HasActivityInjector{

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>
    private lateinit var appComponent : TestApplicationComponent

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerTestApplicationComponent.builder()
                .application(this).build()
        appComponent.inject(this)

    }

}