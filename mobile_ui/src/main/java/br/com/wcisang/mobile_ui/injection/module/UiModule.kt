package br.com.wcisang.mobile_ui.injection.module

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.mobile_ui.UiThread
import br.com.wcisang.mobile_ui.browse.BrowseActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread) : PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity() : BrowseActivity
}