package br.com.wcisang.mobile_ui.injection

import android.app.Application
import br.com.wcisang.data.repository.ProjectsRemote
import br.com.wcisang.mobile_ui.BuildConfig
import br.com.wcisang.remote.ProjectsRemoteImpl
import br.com.wcisang.remote.service.GithubTrendingService
import br.com.wcisang.remote.service.GithubTrendingServiceFactory
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun provideGithubService() : GithubTrendingService {
        return mock()
    }

    @Provides
    @JvmStatic
    fun provideProjectsRemote() : ProjectsRemote{
        return mock()
    }
}