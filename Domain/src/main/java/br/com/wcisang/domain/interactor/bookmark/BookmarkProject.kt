package br.com.wcisang.domain.interactor.bookmark

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.CompletableUseCase
import br.com.wcisang.domain.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by WCisang on 23/10/2018.
 */
open class BookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread
): CompletableUseCase<BookmarkProject.Params>(postExecutionThread){

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can`t be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String) : Params {
                return Params(projectId)
            }
        }
    }
}