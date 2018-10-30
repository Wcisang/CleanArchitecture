package br.com.wcisang.mobile_ui.injection

import android.app.Application
import br.com.wcisang.mobile_ui.GithubTrendingApplication
import br.com.wcisang.mobile_ui.injection.module.*
import br.com.wcisang.mobile_ui.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by WCisang on 28/10/2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, TestApplicationModule::class,
        TestCacheModule::class, TestDataModule::class, PresentationModule::class, UiModule::class,
        TestRemoteModule::class))
interface TestApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : TestApplicationComponent.Builder

        fun build() : TestApplicationComponent
    }

    fun inject(application: TestApplication)
}