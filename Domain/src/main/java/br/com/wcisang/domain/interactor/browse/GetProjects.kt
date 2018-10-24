package br.com.wcisang.domain.interactor.browse

import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.domain.interactor.ObservableUseCase
import br.com.wcisang.domain.model.Project
import br.com.wcisang.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by WCisang on 23/10/2018.
 */
class GetProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<Project>, Nothing>(postExecutionThread){

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }
}