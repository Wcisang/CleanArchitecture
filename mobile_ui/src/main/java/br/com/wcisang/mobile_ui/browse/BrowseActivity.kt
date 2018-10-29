package br.com.wcisang.mobile_ui.browse

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.wcisang.mobile_ui.R
import br.com.wcisang.mobile_ui.injection.ViewModelFactory
import br.com.wcisang.mobile_ui.mapper.ProjectViewMapper
import br.com.wcisang.presentation.BrowseProjectsViewModel
import br.com.wcisang.presentation.model.ProjectView
import br.com.wcisang.presentation.state.Resource
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_browse.*
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowseActivity :  AppCompatActivity(){

    @Inject lateinit var adapter: BrowseAdapter
    @Inject lateinit var mapper: ProjectViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var browseViewModel: BrowseProjectsViewModel


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

            }
        })
        browseViewModel.fetchProjects()
    }

    private fun setupBrowseRecycler() {
        recycler_projects.layoutManager = LinearLayoutManager(this)
    }
}