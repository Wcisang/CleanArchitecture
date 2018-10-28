package br.com.wcisang.presentation.test.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by WCisang on 28/10/2018.
 */
object DataFactory {

    fun randomUuid() : String {
        return UUID.randomUUID().toString()
    }

    fun randomString() : String {
        return UUID.randomUUID().toString()
    }

    fun randomInt() : Int{
        return ThreadLocalRandom.current().nextInt(0,1000+1)
    }

    fun randomLong() : Long {
        return randomInt().toLong()
    }

    fun randomBoolean() : Boolean {
        return Math.random() < 0.5
    }
}