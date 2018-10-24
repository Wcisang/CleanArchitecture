package br.com.wcisang.data.mapper

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.test.factory.ProjectFactory
import br.com.wcisang.domain.model.Project
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ProjectMapperTest {

    private val mapper = ProjectMapper()

    @Test
    fun mapFromEntityMapsData() {
        val entity = ProjectFactory.makeProjectEntity()
        val model = mapper.mapFromEntity(entity)
        assertEqualsData(entity, model)
    }

    @Test
    fun mapToEntityMapsData() {
        val entity = ProjectFactory.makeProject()
        val model = mapper.mapToEntity(entity)
        assertEqualsData(model, entity)
    }


    private fun assertEqualsData(entity: ProjectEntity,
                                 model: Project) {
        assertEquals(entity.id, model.id)
        assertEquals(entity.name, model.name)
        assertEquals(entity.fullName, model.fullName)
        assertEquals(entity.starCount, model.starCount)
        assertEquals(entity.ownerName, model.ownerName)
        assertEquals(entity.dateCreated, model.dateCreated)
        assertEquals(entity.ownerAvatar, model.ownerAvatar)
        assertEquals(entity.isBookmarked, model.isBookmarked)
    }
}