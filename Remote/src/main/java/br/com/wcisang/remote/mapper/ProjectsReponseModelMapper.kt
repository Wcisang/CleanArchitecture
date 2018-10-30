package br.com.wcisang.remote.mapper

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.remote.model.ProjectModel
import javax.inject.Inject

open class ProjectsReponseModelMapper @Inject constructor(): ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.startCount.toString(),
                model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar, false)
    }
}