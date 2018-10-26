package br.com.wcisang.cache.test.factory

import br.com.wcisang.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig() : Config {
        return Config(lastCacheTime = DataFactory.randomLong())
    }
}