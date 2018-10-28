package br.com.wcisang.presentation.state

/**
 * Created by WCisang on 28/10/2018.
 */
class Resource<out T> constructor(val status: ResourceState, val data: T? = null, val message: String? = null){



}