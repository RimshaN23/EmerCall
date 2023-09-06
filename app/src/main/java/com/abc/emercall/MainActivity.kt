package com.abc.emercall

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CALL_PERMISSIONS = arrayOf<String>(Manifest.permission.CALL_PHONE)

        val permissionCallPhone =
            ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE)
        if (permissionCallPhone != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                CALL_PERMISSIONS,
                1
            );
        }

        val emer_list= generate_list()

        val recyclerview = findViewById<RecyclerView>(R.id.r_view)

        val adapter = EmergengyAdapter(emer_list,this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager= LinearLayoutManager(this)


    }

    private fun generate_list(): List<model>{
        val list = ArrayList<model>()
        list.add(model(R.drawable.police, "Police", 15))
        list.add(model(R.drawable.ambulance, "Edhi ", 115))
        list.add(model(R.drawable.ranger, "Ranger", 1101))
        list.add(model(R.drawable.vest, "Rescue", 1122))
        list.add(model(R.drawable.fire, "Fire Brigade", 16))
        list.add(model(R.drawable.telephone, "Telephone Enquiry", 17))
        list.add(model(R.drawable.ambulance, "Aman Ambulance ", 1021))
        list.add(model(R.drawable.healthcare, "Medical Assistance Helpline", 16))
        list.add(model(R.drawable.ambulance, "Chhhipa", 1020))
        list.add(model(R.drawable.train, "Railway Enquiry", 117))
        list.add(model(R.drawable.airplane_plane_flight_travel_icon, "PIA Flight Inquiry", 114))
        list.add(model(R.drawable.telephone, "Telephone Complaints", 18))

        return list

    }
}