package br.com.wcisang.data.repository

import br.com.wcisang.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsDataStore {

    fun clearProjects() : Completable

    fun saveProjects(projects: List<ProjectEntity>) : Completable

    fun getProjects() : Observable<List<ProjectEntity>>

    fun getBookmarkedProjects() : Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String) : Completable

    fun setProjectAsUnbookmarked(projectId: String) : Completable
}