package br.com.wcisang.presentation.browse

import android.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.wcisang.domain.interactor.bookmark.BookmarkProject
import br.com.wcisang.domain.interactor.bookmark.UnbookmarkProject
import br.com.wcisang.domain.interactor.browse.GetProjects
import br.com.wcisang.domain.model.Project
import br.com.wcisang.presentation.BrowseProjectsViewModel
import br.com.wcisang.presentation.mapper.ProjectViewMapper
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.ResourceState
import br.com.wcisang.presentation.test.factory.DataFactory
import br.com.wcisang.presentation.test.factory.ProjectFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableObserver
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Captor

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowseProjectsViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getProjects = mock<GetProjects>()
    var bookmarkProject = mock<BookmarkProject>()
    var unbookmarkProject = mock<UnbookmarkProject>()
    var projectMapper =  mock<ProjectViewMapper>()
    var projectViewModel = BrowseProjectsViewModel(getProjects, bookmarkProject,
            unbookmarkProject, projectMapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<Project>>>()

    @Test
    fun fetchProjectsExecutesUseCase() {
        projectViewModel.fetchProjects()

        verify(getProjects, times(0)).execute(any(), eq(null))
    }

    @Test
    fun fetchProjectReturnsSuccess() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectViews = ProjectFactory.makeProjectViewList(2)
        stubProjectMapperMapToView(projectViews[0], projects[0])
        stubProjectMapperMapToView(projectViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(ResourceState.SUCCESS, projectViewModel.getProjects().value?.status)
    }

    @Test
    fun fetchProjectReturnsData() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectViews = ProjectFactory.makeProjectViewList(2)
        stubProjectMapperMapToView(projectViews[0], projects[0])
        stubProjectMapperMapToView(projectViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(projectViews, projectViewModel.getProjects().value?.data)
    }

    @Test
    fun fetchProjectReturnsError() {
        projectViewModel.fetchProjects()

        verify(getProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())

        assertEquals(ResourceState.ERROR, projectViewModel.getProjects().value?.status)
    }

    @Test
    fun fetchProjectReturnsMessageForError() {
        val message = DataFactory.randomString()
        projectViewModel.fetchProjects()

        verify(getProjects).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(message))

        assertEquals(message, projectViewModel.getProjects().value?.message)
    }

    private fun stubProjectMapperMapToView(projectView: ProjectView,
                                           project: Project) {

        whenever(projectMapper.mapToView(project))
                .thenReturn(projectView)

    }
}