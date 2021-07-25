package com.jack.googlehuawei.service.huawei

import android.content.Context
import android.content.pm.PackageManager
import com.huawei.hms.api.ConnectionResult

import com.huawei.hms.api.HuaweiApiAvailability
import com.jack.googlehuawei.R
import com.jack.googlehuawei.service.implementor.ServiceAvailableImplementor

/**
 * Created by jackhau on 25/07/2021.
 */

class HuaweiServiceAvailable :
    ServiceAvailableImplementor {

    override fun isAvailable(context: Context): Boolean {
        val huaweiApiAvailability = HuaweiApiAvailability.getInstance()
        val resultCode = huaweiApiAvailability.isHuaweiMobileServicesAvailable(context)
        val resultInstall = try {
            context.packageManager?.getPackageInfo(context.getString(R.string.app_gallery_packagename_id), 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return resultInstall && resultCode == ConnectionResult.SUCCESS
    }

}
