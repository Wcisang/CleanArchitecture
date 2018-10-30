package br.com.wcisang.mobile_ui.mapper

import br.com.wcisang.mobile_ui.test.factory.ProjectFactory
import org.junit.Test
import kotlin.test.assertEquals

class ProjectMapperTest {

    private val projectMapper = ProjectViewMapper()


    @Test
    fun mapToViewMapsData() {
        val project = ProjectFactory.makeProjectView()
        val projectUI = projectMapper.mapToView(project)

        assertEquals(project.id, projectUI.id)
        assertEquals(project.name, projectUI.name)
        assertEquals(project.fullName, projectUI.fullName)
        assertEquals(project.starCount, projectUI.starCount)
        assertEquals(project.dateCreated, projectUI.dateCreated)
        assertEquals(project.ownerName, projectUI.ownerName)
        assertEquals(project.ownerAvatar, projectUI.ownerAvatar)
        assertEquals(project.isBookmarked, projectUI.isBookmarked)
    }
}