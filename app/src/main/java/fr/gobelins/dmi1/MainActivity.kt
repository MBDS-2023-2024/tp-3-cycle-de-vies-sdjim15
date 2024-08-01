package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.gobelins.dmi1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var buttonHomeSp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //buttonHomeSp = findViewById(R.id.btn_home_compute)
        binding.btnHomeCompute.setOnClickListener{
            val intent = Intent(this,ComputeActivity::class.java)
            startActivity(intent)
        }
    }

}