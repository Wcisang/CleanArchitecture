package br.com.wcisang.data.repository

import br.com.wcisang.data.model.ProjectEntity
import io.reactivex.Observable


interface ProjectsRemote {

    fun getProjects() : Observable<List<ProjectEntity>>
}