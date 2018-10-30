package br.com.wcisang.mobile_ui.injection

import br.com.wcisang.domain.repository.ProjectsRepository
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides

@Module
object TestDataModule {


    @Provides
    @JvmStatic
    fun provideDataRepository() : ProjectsRepository{
        return mock()
    }

}