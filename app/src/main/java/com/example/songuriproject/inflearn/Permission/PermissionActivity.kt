package com.example.songuriproject.inflearn.Permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.songuriproject.R
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {

    var permission_list = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.SEND_SMS,
        Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        checkPermission()
    }

    /**
     *  마실멜로우 이하에서는 권한설정이 필요없지만
     *  그 이상부터는 권한설정을 따로 받아야함.
     */
    fun checkPermission() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M ) {
            return
        }

        for(permission: String in permission_list) {
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var idx = 0
        textView.text = ""
        for(ind in grantResults.indices) {
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                textView.append("${permission_list[idx]} : 허용함 \n")
            } else {
                textView.append("${permission_list[idx]} : 허용하지 않음 \n")
            }
        }
    }
}
