package br.com.wcisang.remote.mapper

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.remote.model.ProjectModel

class ProjectsReponseModelMapper : ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.startCount.toString(),
                model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar, false)
    }
}