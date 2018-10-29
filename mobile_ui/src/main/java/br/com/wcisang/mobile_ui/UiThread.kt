package br.com.wcisang.mobile_ui

import br.com.wcisang.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by WCisang on 28/10/2018.
 */
class UiThread @Inject constructor() : PostExecutionThread{

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}