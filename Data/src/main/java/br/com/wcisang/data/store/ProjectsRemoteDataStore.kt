package br.com.wcisang.data.store

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.repository.ProjectsDataStore
import br.com.wcisang.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

open class ProjectsRemoteDataStore @Inject constructor(
        private val projectsRemote: ProjectsRemote
) : ProjectsDataStore {

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Clearing projects ins't supported here...")
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects ins't supported here...")
    }

    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Getting bookmarks projects ins't supported here...")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting bookmarks projects ins't supported here...")
    }

    override fun setProjectAsUnbookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting bookmarks projects ins't supported here...")
    }
}