package br.com.wcisang.remote.mapper

import br.com.wcisang.remote.test.factory.ProjectDataFactory
import org.junit.Test
import kotlin.test.assertEquals

class ProjectsResponseModelMapperTest {

    private val mapper = ProjectsReponseModelMapper()

    @Test
    fun mapFromModelMapsData() {
        val model = ProjectDataFactory.makeProject()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.fullName, entity.fullName)
        assertEquals(model.startCount.toString(), entity.starCount)
        assertEquals(model.owner.ownerName, entity.ownerName)
        assertEquals(model.owner.ownerAvatar, entity.ownerAvatar)
    }

}