package br.com.wcisang.cache.test.factory

import br.com.wcisang.cache.model.CachedProject
import br.com.wcisang.data.model.ProjectEntity

object ProjectDataFactory {

    fun makeCachedProject() : CachedProject {
        return CachedProject(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), false)
    }

    fun makeProjectEntity() : ProjectEntity {
        return ProjectEntity(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }

    fun makeCachedBookmarkedProject() : CachedProject {
        return CachedProject(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), true)
    }

    fun makeCachedBookmarkedProjectEntity() : ProjectEntity {
        return ProjectEntity(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), true)
    }

}