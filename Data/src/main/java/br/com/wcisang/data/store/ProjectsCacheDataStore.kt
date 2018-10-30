package br.com.wcisang.data.store

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.repository.ProjectsCache
import br.com.wcisang.data.repository.ProjectsDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

open class ProjectsCacheDataStore @Inject constructor(
        private val projectsCache: ProjectsCache
) : ProjectsDataStore {

    override fun clearProjects(): Completable {
        return projectsCache.clearProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return projectsCache.saveProjects(projects)
                .andThen(projectsCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return projectsCache.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getBookmarkedProjects()
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsBookmarked(projectId)
    }

    override fun setProjectAsUnbookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsUnbookmarked(projectId)
    }
}