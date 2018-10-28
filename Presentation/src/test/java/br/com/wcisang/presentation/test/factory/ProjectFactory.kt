package br.com.wcisang.presentation.test.factory

import br.com.wcisang.domain.model.Project
import br.com.wcisang.presentation.model.ProjectView

/**
 * Created by WCisang on 28/10/2018.
 */
object ProjectFactory {

    fun makeProjectView() : ProjectView{
        return ProjectView(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomBoolean())
    }

    fun makeProject() : Project {
        return Project(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(), DataFactory.randomBoolean())
    }

    fun makeProjectViewList(count: Int) : List<ProjectView> {
        val projects = mutableListOf<ProjectView>()
        repeat(count) {
            projects.add(makeProjectView())
        }
        return projects
    }

    fun makeProjectList(count: Int) : List<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }
}