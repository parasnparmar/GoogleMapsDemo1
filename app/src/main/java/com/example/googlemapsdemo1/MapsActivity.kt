package com.example.googlemapsdemo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsdemo1.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var markerPune : Marker
    private lateinit var markerMumbai : Marker
    private lateinit var markerOptionsPune: MarkerOptions
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
    //    mapFragment.getMapAsync(this)
         mapFragment.getMapAsync{
             mMap -> this@MapsActivity.mMap = mMap
             initializeMapsSettings()
             addMarkers()

         }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
    private fun addMarkers(){
        markerOptionsPune = MarkerOptions()
        markerOptionsPune.position(LatLng(18.5204,73.8567))
        markerOptionsPune.title("Pune")
        markerOptionsPune.alpha(6.0F)
        markerOptionsPune.rotation(30.0F)
        markerOptionsPune.draggable(true)
        markerOptionsPune.visible(true)

        var iconForPune = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
        markerOptionsPune.icon(iconForPune)

        markerPune = mMap.addMarker(markerOptionsPune)!!

        var iconForMumbai = BitmapDescriptorFactory.defaultMarker()
        mMap.addMarker(MarkerOptions().position(LatLng(19.0760,72.8777))
            .draggable(true)
            .icon(iconForMumbai)
            .alpha(3.0F)
            .rotation(45F)
            .visible(true)
            .title("Mumbai")
        )
    }

    @SuppressLint("MissingPermission")
    private fun initializeMapsSettings(){

        mMap.isBuildingsEnabled = true
        mMap.isIndoorEnabled=true
        mMap.isMyLocationEnabled = true
        mMap.isTrafficEnabled = true

        var uiSettings = mMap.uiSettings
        uiSettings.isMapToolbarEnabled = true
        uiSettings.isCompassEnabled = true
        uiSettings.isIndoorLevelPickerEnabled = true
        uiSettings.isMyLocationButtonEnabled = true
        uiSettings.isRotateGesturesEnabled = true
        uiSettings.isScrollGesturesEnabled = true
        uiSettings.isScrollGesturesEnabledDuringRotateOrZoom = true
        uiSettings.isTiltGesturesEnabled = true
        uiSettings.isZoomControlsEnabled = true
        uiSettings.isZoomGesturesEnabled = true

    }


}