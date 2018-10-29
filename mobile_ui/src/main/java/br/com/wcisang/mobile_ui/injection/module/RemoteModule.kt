package br.com.wcisang.mobile_ui.injection.module

import br.com.wcisang.data.repository.ProjectsRemote
import br.com.wcisang.mobile_ui.BuildConfig
import br.com.wcisang.remote.ProjectsRemoteImpl
import br.com.wcisang.remote.service.GithubTrendingService
import br.com.wcisang.remote.service.GithubTrendingServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService() : GithubTrendingService {
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemoteImpl: ProjectsRemoteImpl) : ProjectsRemote
}