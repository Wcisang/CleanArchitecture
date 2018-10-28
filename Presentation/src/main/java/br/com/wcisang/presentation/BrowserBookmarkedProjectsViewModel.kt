package br.com.wcisang.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wcisang.domain.interactor.bookmark.GetBookmarkedProjects
import br.com.wcisang.domain.model.Project
import br.com.wcisang.presentation.mapper.ProjectViewMapper
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.Resource
import br.com.wcisang.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowserBookmarkedProjectsViewModel @Inject constructor(
        private val getBookmarkedProjects: GetBookmarkedProjects,
        private val mapper: ProjectViewMapper
) : ViewModel() {

    private val liveData : MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects() : LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING))
        return getBookmarkedProjects.execute(ProjectSubscriber())
    }

    inner class ProjectSubscriber() : DisposableObserver<List<Project>>() {

        override fun onComplete() {}

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.SUCCESS, message = e.localizedMessage))
        }

    }
}