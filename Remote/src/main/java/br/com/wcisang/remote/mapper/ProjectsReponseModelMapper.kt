package br.com.wcisang.remote.mapper

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.remote.model.ProjectModel

class ProjectsReponseModelMapper : ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity()
    }
}