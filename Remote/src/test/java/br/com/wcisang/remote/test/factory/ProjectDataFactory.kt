package br.com.wcisang.remote.test.factory

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.remote.model.OwnerModel
import br.com.wcisang.remote.model.ProjectModel
import br.com.wcisang.remote.model.ProjectsResponseModel

object ProjectDataFactory {

    fun makeOwner() : OwnerModel {
        return OwnerModel(DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeProject() : ProjectModel{
        return ProjectModel(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomInt(), DataFactory.randomUuid(),
                makeOwner())
    }

    fun makeProjectEntity() : ProjectEntity{
        return ProjectEntity(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }

    fun makeProjectsResponse() : ProjectsResponseModel {
        return ProjectsResponseModel(listOf(makeProject(), makeProject()))
    }
}