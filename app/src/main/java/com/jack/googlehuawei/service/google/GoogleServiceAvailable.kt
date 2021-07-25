package com.jack.googlehuawei.service.google

import android.content.Context
import android.content.pm.PackageManager
import com.google.android.gms.common.ConnectionResult
import com.jack.googlehuawei.service.implementor.ServiceAvailableImplementor
import com.google.android.gms.common.GoogleApiAvailability
import com.jack.googlehuawei.R

/**
 * Created by jackhau on 25/07/2021.
 */

class GoogleServiceAvailable :
    ServiceAvailableImplementor {
        override fun isAvailable(context: Context): Boolean {
            val googleApiAvailability = GoogleApiAvailability.getInstance()
            val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)
            val resultInstall = try {
                context.packageManager?.getPackageInfo(context.getString(R.string.google_play_packagename_id), 0)
                true
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
            return resultInstall && resultCode == ConnectionResult.SUCCESS
        }

    }