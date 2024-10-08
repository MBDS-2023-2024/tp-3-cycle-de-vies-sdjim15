package fr.gobelins.dmi1


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private lateinit var sosButton: Button
   private lateinit var btnHomeCompute : Button
    private val phoneNumber = "50937793738"
    private val REQUEST_CALL_PHONE = 1
    private lateinit var searchButton: Button
    private lateinit var shareButton: Button
    private lateinit var itineraryButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHomeCompute = findViewById(R.id.btn_home_compute)
        sosButton = findViewById(R.id.sos_button)
        searchButton = findViewById(R.id.search_button)
        shareButton = findViewById(R.id.share_button)
        itineraryButton = findViewById(R.id.directions_button)
        btnHomeCompute.setOnClickListener{
           val intent = Intent(this,ComputeActivity::class.java)
           startActivity(intent)
        }
        sosButton.setOnClickListener{
            makePhoneCall()
        }
        searchButton.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.fr"))
            startActivity(browserIntent)
        }

        shareButton.setOnClickListener{
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Message a partager")
                type = "text/plain"
            }
            val chooser = Intent.createChooser(shareIntent, "Partager via")
            if (shareIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }

        itineraryButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:48.826373,2.362527")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
            }

    }
    private fun makePhoneCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL_PHONE)
        } else {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        }
    }

}