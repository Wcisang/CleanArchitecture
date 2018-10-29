package br.com.wcisang.mobile_ui.injection.module

import br.com.wcisang.data.ProjectsDataRepository
import br.com.wcisang.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module

/**
 * Created by WCisang on 28/10/2018.
 */
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository) : ProjectsRepository
}