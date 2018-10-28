package br.com.wcisang.presentation.mapper

/**
 * Created by WCisang on 28/10/2018.
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V
}