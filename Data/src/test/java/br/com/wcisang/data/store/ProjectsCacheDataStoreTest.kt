package br.com.wcisang.data.store

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.repository.ProjectsCache
import br.com.wcisang.data.test.factory.DataFactory
import br.com.wcisang.data.test.factory.ProjectFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by WCisang on 24/10/2018.
 */
class ProjectsCacheDataStoreTest {

    private val cache = mock<ProjectsCache>()
    private val store = ProjectsCacheDataStore(cache)

    @Test
    fun getProjectsCompletes () {
        stubProjectsCacheGetProjects(Flowable.just(listOf(ProjectFactory.makeProjectEntity())))
        val testObservable = store.getProjects().test()
        testObservable.assertComplete()
    }

    @Test
    fun getProjectsReturnsData () {
        val data = listOf(ProjectFactory.makeProjectEntity())
        stubProjectsCacheGetProjects(Flowable.just(data))
        val testObservable = store.getProjects().test()
        testObservable.assertValue(data)
    }

    @Test
    fun getProjectsCallsCacheSource () {
        stubProjectsCacheGetProjects(Flowable.just(listOf(ProjectFactory.makeProjectEntity())))
        store.getProjects().test()
        verify(cache).getProjects()
    }

    @Test
    fun saveProjectsCompletes() {
        stubProjectsCacheSetLastCachedTime(Completable.complete())
        stubSaveProjects(Completable.complete())
        val testObservable = store.saveProjects(listOf(ProjectFactory.makeProjectEntity())).test()
        testObservable.assertComplete()
    }

    @Test
    fun saveProjectsCallsCache() {
        stubProjectsCacheSetLastCachedTime(Completable.complete())
        val data = listOf(ProjectFactory.makeProjectEntity())
        stubSaveProjects(Completable.complete())
        store.saveProjects(data).test()
        verify(cache).saveProjects(data)
    }

    @Test
    fun clearProjectsCompletes() {
        stubProjectsClearProjects(Completable.complete())
        val testObservable = store.clearProjects().test()
        testObservable.assertComplete()
    }

    @Test
    fun clearProjectsCallsCache() {
        stubProjectsClearProjects(Completable.complete())
        store.clearProjects().test()
        verify(cache).clearProjects()
    }

    @Test
    fun getBookmarkedProjectsCompletes() {
        stubProjectsCacheGetBookmarkedProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        val testObservable = store.getBookmarkedProjects().test()
        testObservable.assertComplete()
    }

    @Test
    fun getBookmarkedProjectsCallsCache() {
        stubProjectsCacheGetBookmarkedProjects(Observable.just(listOf(ProjectFactory.makeProjectEntity())))
        store.getBookmarkedProjects().test()
        verify(cache).getBookmarkedProjects()
    }

    @Test
    fun getBookmarkedReturnData() {
        val data = listOf(ProjectFactory.makeProjectEntity())
        stubProjectsCacheGetBookmarkedProjects(Observable.just(data))
        val testObservable = store.getBookmarkedProjects().test()
        testObservable.assertValue(data)
    }

    @Test
    fun setProjectAsBookmarkedCompletes() {
        stubProjectsCacheSetProjectAsBookmarked(Completable.complete())
        val testObservable = store.setProjectAsBookmarked(DataFactory.randomString()).test()
        testObservable.assertComplete()
    }

    @Test
    fun setProjectAsBookmarkedCallsCache() {
        val data = DataFactory.randomString()
        stubProjectsCacheSetProjectAsBookmarked(Completable.complete())
        store.setProjectAsBookmarked(data).test()
        verify(cache).setProjectAsBookmarked(data)
    }

    @Test
    fun setProjectAsUnbookmarkedCompletes() {
        stubProjectsCacheSetProjectAsUnbookmarked(Completable.complete())
        val testObservable = store.setProjectAsUnbookmarked(DataFactory.randomString()).test()
        testObservable.assertComplete()
    }

    @Test
    fun setProjectAsUnbookmarkedCallsCache() {
        val data = DataFactory.randomString()
        stubProjectsCacheSetProjectAsUnbookmarked(Completable.complete())
        store.setProjectAsUnbookmarked(data).test()
        verify(cache).setProjectAsUnbookmarked(data)
    }

    private fun stubSaveProjects(completable: Completable) {
        whenever(cache.saveProjects(any()))
                .thenReturn(completable)
    }

    private fun stubProjectsCacheGetProjects(observable: Flowable<List<ProjectEntity>>) {
        whenever(cache.getProjects())
                .thenReturn(observable)
    }

    private fun stubProjectsClearProjects(completable: Completable) {
        whenever(cache.clearProjects())
                .thenReturn(completable)
    }

    private fun stubProjectsCacheGetBookmarkedProjects(observable: Observable<List<ProjectEntity>>) {
        whenever(cache.getBookmarkedProjects())
                .thenReturn(observable)
    }

    private fun stubProjectsCacheSetProjectAsBookmarked(completable: Completable) {
        whenever(cache.setProjectAsBookmarked(any()))
                .thenReturn(completable)
    }

    private fun stubProjectsCacheSetProjectAsUnbookmarked(completable: Completable) {
        whenever(cache.setProjectAsUnbookmarked(any()))
                .thenReturn(completable)
    }

    private fun stubProjectsCacheSetLastCachedTime(completable: Completable) {
        whenever(cache.setLastCacheTime(any()))
                .thenReturn(completable)
    }

}