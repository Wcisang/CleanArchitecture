package br.com.wcisang.domain.test

import br.com.wcisang.domain.model.Project
import java.util.*

/**
 * Created by WCisang on 23/10/2018.
 */
object ProjectDataFactory {

    fun randomuid() : String {
        return UUID.randomUUID().toString()
    }

    fun randommBoolean() : Boolean {
        return Math.random() < 0.5
    }

    fun makeProject() : Project {
        return Project(randomuid(), randomuid(), randomuid(),
                randomuid(), randomuid(), randomuid(),
                randomuid(), randommBoolean())
    }

    fun makeProjectList(count: Int) : List<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }
}