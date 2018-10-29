package br.com.wcisang.mobile_ui.mapper

import br.com.wcisang.mobile_ui.model.Project
import br.com.wcisang.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class ProjectViewMapper @Inject constructor(): ViewMapper<ProjectView, Project>{

    override fun mapToView(type: ProjectView): Project {
        return Project(type.id, type.name, type.fullName, type.starCount, type.dateCreated,
                type.ownerName, type.ownerAvatar, type.isBookmarked)
    }

}