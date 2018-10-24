package br.com.wcisang.domain.executor

import io.reactivex.Scheduler

/**
 * Created by WCisang on 23/10/2018.
 */
interface PostExecutionThread {
    val scheduler : Scheduler
}