package br.com.wcisang.remote

import br.com.wcisang.data.model.ProjectEntity
import br.com.wcisang.data.repository.ProjectsRemote
import br.com.wcisang.remote.mapper.ProjectsReponseModelMapper
import br.com.wcisang.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsReponseModelMapper
) :  ProjectsRemote{

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map {
                        mapper.mapFromModel(it)
                    }
                }
    }
}