package br.com.wcisang.mobile_ui.model

/**
 * Created by WCisang on 28/10/2018.
 */
data class Project(val id: String, val name: String, val fullName: String,
              val starCount: String, val dateCreated: String,
              val ownerName: String, val ownerAvatar: String,
              val isBookmarked: Boolean)