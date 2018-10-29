package br.com.wcisang.mobile_ui.bookmarked

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.wcisang.mobile_ui.injection.ViewModelFactory
import br.com.wcisang.mobile_ui.mapper.ProjectViewMapper
import br.com.wcisang.presentation.BrowserBookmarkedProjectsViewModel
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.Resource
import br.com.wcisang.presentation.state.ResourceState
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_bookmarked.*
import javax.inject.Inject

class BookmarkedActivity : AppCompatActivity() {

    @Inject lateinit var adapter: BookmarkedAdapter
    @Inject lateinit var mapper: ProjectViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var browseViewModel: BrowserBookmarkedProjectsViewModel

    companion object {
        fun getStartIntent(context: Context) : Intent {
            return Intent(context, BookmarkedActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        browseViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BrowserBookmarkedProjectsViewModel::class.java)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        browseViewModel.getProjects().observe(this, Observer<Resource<List<ProjectView>>> {
            handleDataState(it)
        })
        browseViewModel.fetchProjects()
    }

    private fun setupBrowseRecycler() {
        recycler_projects.layoutManager = LinearLayoutManager(this)
    }

    private fun handleDataState(resource: Resource<List<ProjectView>>?) {
        when (resource?.status) {
            ResourceState.SUCCESS -> {
                progress.visibility = View.VISIBLE
                progress.visibility = View.GONE
            }
            ResourceState.LOADING -> {
                progress.visibility = View.VISIBLE
                progress.visibility = View.GONE
            }
        }
    }
}