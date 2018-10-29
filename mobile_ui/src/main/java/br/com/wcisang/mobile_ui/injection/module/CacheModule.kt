package br.com.wcisang.mobile_ui.injection.module

import android.app.Application
import br.com.wcisang.cache.ProjectsCacheImpl
import br.com.wcisang.cache.db.ProjectsDatabase
import br.com.wcisang.data.repository.ProjectsCache
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application) : ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCacheImpl: ProjectsCacheImpl) : ProjectsCache
}