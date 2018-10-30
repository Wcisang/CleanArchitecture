package br.com.wcisang.mobile_ui.browse

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.wcisang.mobile_ui.R
import br.com.wcisang.mobile_ui.bookmarked.BookmarkedActivity
import br.com.wcisang.mobile_ui.injection.ViewModelFactory
import br.com.wcisang.mobile_ui.mapper.ProjectViewMapper
import br.com.wcisang.mobile_ui.model.Project
import br.com.wcisang.presentation.BrowseProjectsViewModel
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.Resource
import br.com.wcisang.presentation.state.ResourceState
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_bookmarked.*
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowseActivity :  AppCompatActivity(){

    @Inject lateinit var adapter: BrowseAdapter
    @Inject lateinit var mapper: ProjectViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var browseViewModel: BrowseProjectsViewModel

    private val projectListener = object : ProjectListener {
        override fun onBookmarkedProjectClicked(projectId: String) {
            browseViewModel.unbookmarkProject(projectId)
        }

        override fun onProjectClicked(projectId: String) {
            browseViewModel.bookmarkProject(projectId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)

        browseViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BrowseProjectsViewModel::class.java)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        browseViewModel.getProjects().observe(this, Observer<Resource<List<ProjectView>>> {
            it?.let {
                handleDataState(it)
            }
        })
        browseViewModel.fetchProjects()
    }

    private fun setupBrowseRecycler() {
        adapter.projectListener = projectListener
        recycler_projects.layoutManager = LinearLayoutManager(this)
        recycler_projects.adapter = adapter
    }

    private fun handleDataState(resource: Resource<List<ProjectView>>?) {
        when (resource?.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                progress.visibility = View.VISIBLE
                recycler_projects.visibility = View.GONE
            }
        }
    }

    private fun setupScreenForSuccess(projects: List<Project>?) {
        progress.visibility = View.GONE
        projects?.let {
            adapter.projects = it
            adapter.notifyDataSetChanged()
            recycler_projects.visibility = View.VISIBLE
        } ?: run {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.action_bookmarked -> {
                startActivity(BookmarkedActivity.getStartIntent(this))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}