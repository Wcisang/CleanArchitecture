package br.com.wcisang.mobile_ui.mapper

/**
 * Created by WCisang on 28/10/2018.
 */
interface ViewMapper<in P, out V> {

    fun mapToView(type: P) : V
}