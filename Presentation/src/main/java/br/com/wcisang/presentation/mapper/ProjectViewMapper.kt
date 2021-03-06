package br.com.wcisang.presentation.mapper

import br.com.wcisang.domain.model.Project
import br.com.wcisang.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
open class ProjectViewMapper @Inject constructor(): Mapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.name, type.fullName, type.starCount,
                type.dateCreated, type.ownerName, type.ownerAvatar, type.isBookmarked)
    }


}