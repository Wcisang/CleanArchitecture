package br.com.wcisang.mobile_ui.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.wcisang.mobile_ui.R
import br.com.wcisang.mobile_ui.model.Project
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject

class BrowseAdapter @Inject constructor() : RecyclerView.Adapter<BrowseAdapter.ViewHolder>(){

    var projects: List<Project> = arrayListOf()
    var projectListener : ProjectListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.item_project, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = projects.count()

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val project = projects[p1]
        holder.ownerNameText.text = project.ownerName
        holder.projectNameText.text = project.fullName

        Glide.with(holder.itemView.context)
                .load(project.ownerAvatar)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatarImage)

        val starRsource = if (project.isBookmarked) {
            R.drawable.ic_star_black_24dp
        }else {
            R.drawable.ic_star_border_black_24dp
        }

        holder.bookmarkedImage.setImageResource(starRsource)
        holder.bookmarkedImage.setOnClickListener {
            if (project.isBookmarked)
                projectListener?.onBookmarkedProjectClicked(project.id)
            else
                projectListener?.onProjectClicked(project.id)
        }
    }


    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var avatarImage: ImageView
        var ownerNameText : TextView
        var projectNameText : TextView
        var bookmarkedImage: ImageView

        init {
            avatarImage = view.findViewById(R.id.image_owner_avatar)
            ownerNameText = view.findViewById(R.id.text_owner_name)
            projectNameText = view.findViewById(R.id.text_project_name)
            bookmarkedImage = view.findViewById(R.id.image_bookmark)
        }
    }

}