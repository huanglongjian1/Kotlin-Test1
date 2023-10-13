package com.android.kotlin_test1.test5.fragment02

import kotlinx.coroutines.delay

class TestRepositity : CacheRepositity<String>() {
    override suspend fun fetchDataFromLocal(): CResult<String> {
        delay(2000)
        return CResult.Success("data from fetchDataFromLocal")
    }

    override suspend fun fetchDataFromNetWork(): CResult<String> {
        delay(1000)
        return CResult.Success("data from fetchDataFromNetWork")
    }
}
