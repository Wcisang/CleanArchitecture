package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by WCisang on 23/10/2018.
 */
interface ProjectsRepository {

    fun getProjects() : Observable<List<Project>>

    fun bookmarkProject(projectId: String) : Completable

    fun unbookmarkProject(projectId: String) : Completable

    fun getBookmarkedProjects() : Observable<List<Project>>
}