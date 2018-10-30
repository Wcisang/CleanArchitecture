package br.com.wcisang.data.repository

import br.com.wcisang.data.model.ProjectEntity
import io.reactivex.Flowable
import io.reactivex.Observable


interface ProjectsRemote {

    fun getProjects() : Flowable<List<ProjectEntity>>
}