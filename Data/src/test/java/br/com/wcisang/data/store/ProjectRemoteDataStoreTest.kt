package br.com.wcisang.data.store

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.repository.ProjectsRemote
import br.com.wcisang.data.test.factory.ProjectFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by WCisang on 24/10/2018.
 */
class ProjectRemoteDataStoreTest {

    private val remote = mock<ProjectsRemote>()
    private val store = ProjectsRemoteDataStore(remote)

    @Test
    fun getProjectsComplete() {
        stubRemoteGetProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        val testObservable = store.getProjects().test()
        testObservable.assertComplete()
    }

    @Test
    fun getProjectsReturnsData() {
        val data = listOf(ProjectFactory.makeProjectEntity())
        stubRemoteGetProjects(Observable.just(data))
        val testObservable = store.getProjects().test()
        testObservable.assertValue(data)
    }

    @Test
    fun getProjectsRemoteCalls() {
        val data = listOf(ProjectFactory.makeProjectEntity())
        stubRemoteGetProjects(Observable.just(data))
        store.getProjects().test()
        verify(remote).getProjects()
    }

    private fun stubRemoteGetProjects(observable: Observable<List<ProjectEntity>>){
        whenever(remote.getProjects())
                .thenReturn(observable)
    }
}