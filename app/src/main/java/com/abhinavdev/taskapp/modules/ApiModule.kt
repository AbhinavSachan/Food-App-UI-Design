package com.abhinavdev.taskapp.modules

import com.abhinavdev.taskapp.models.Data
import com.abhinavdev.taskapp.models.Result

object ApiModule {

    private var result: Data? = null

    fun setData(data: Data?) {
        result = data
    }

    fun getData():Data? {
        return result
    }

}