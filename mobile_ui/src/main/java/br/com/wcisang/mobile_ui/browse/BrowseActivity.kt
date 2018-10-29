package br.com.wcisang.mobile_ui.browse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.wcisang.mobile_ui.R
import kotlinx.android.synthetic.main.activity_browse.*

/**
 * Created by WCisang on 28/10/2018.
 */
class BrowseActivity :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        setupBrowseRecycler()
    }

    private fun setupBrowseRecycler() {
        recycler_projects.layoutManager = LinearLayoutManager(this)
    }
}