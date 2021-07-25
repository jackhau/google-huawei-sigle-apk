package com.jack.googlehuawei.service

import android.content.Context
import com.jack.googlehuawei.service.google.GoogleServiceAvailable
import com.jack.googlehuawei.service.huawei.HuaweiServiceAvailable

/**
 * Created by jackhau on 25/07/2021.
 */

class ServiceChecker {

    companion object {

        private var mType: Type? = null

        @JvmStatic
        fun getAvailableService(context: Context) : Type? {
            if (mType == null) {
                mType = when {
                    GoogleServiceAvailable().isAvailable(context) -> {
                        Type.Google
                    }
                    HuaweiServiceAvailable().isAvailable(context) -> {
                        Type.Huawei
                    }
                    else -> {
                        Type.NONE
                    }
                }
            }
            return mType
        }
    }

    enum class Type{
        Google,
        Huawei,
        NONE
    }

}

