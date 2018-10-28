package br.com.wcisang.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.bookmark.BookmarkProject
import br.com.wcisang.domain.interactor.bookmark.UnbookmarkProject
import br.com.wcisang.domain.interactor.browse.GetProjects
import br.com.wcisang.domain.model.Project
import br.com.wcisang.presentation.mapper.ProjectViewMapper
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.Resource
import br.com.wcisang.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowseProjectsViewModel @Inject constructor(
        private val getProjects: GetProjects,
        private val bookmarkProject: BookmarkProject,
        private val unbookmarkProject: UnbookmarkProject,
        private val mapper: ProjectViewMapper
) : ViewModel(){

    private val liveData : MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getProjects.dispose()
        super.onCleared()
    }

    fun getProjects() : LiveData<Resource<List<ProjectView>>>{
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING))
        return getProjects.execute(ProjectsSubscriver())
    }

    fun bookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING))
        return bookmarkProject.execute(BookmarkProjectSubscriber(),
                BookmarkProject.Params.forProject(projectId))
    }

    fun unbookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING))
        return unbookmarkProject.execute(UnbookmarkProjectSubscriber(),
                UnbookmarkProject.Params.forProject(projectId))
    }

    inner class ProjectsSubscriver : DisposableObserver<List<Project>>() {

        override fun onComplete() {}

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, message = e.localizedMessage))
        }

    }

    inner class BookmarkProjectSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, message = e.localizedMessage))
        }

    }

    inner class UnbookmarkProjectSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, message = e.localizedMessage))
        }

    }


}