package br.com.wcisang.data.test.factory

import br.com.wcisang.domain.model.Project
import br.com.wcisang.data.model.ProjectEntity

object ProjectFactory {

    fun makeProjectEntity() : ProjectEntity {
        return ProjectEntity(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomBoolean())
    }

    fun makeProject() : Project {
        return Project(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomBoolean())
    }
}