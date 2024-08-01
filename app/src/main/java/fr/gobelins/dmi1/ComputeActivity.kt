package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
    lateinit var edOperande1: EditText
    lateinit var edOperande2: EditText
    lateinit var txtAffichage: TextView
    lateinit var btnCalculer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        //val operation = intent.getStringExtra("operation") ?: "ADD"
        edOperande1 = findViewById(R.id.first_operand)
        edOperande2 = findViewById(R.id.second_operand)
        txtAffichage = findViewById(R.id.affichage)
        btnCalculer = findViewById(R.id.btn_calculer)

        btnCalculer.setOnClickListener {
            val operande1 =
                edOperande1.text.toString().toDoubleOrNull() ?: return@setOnClickListener run {
                    // edOperande1.error
                    Toast.makeText(this, "Veuillez rentrer une donnee valide", Toast.LENGTH_SHORT)
                        .show()
                }
            val operande2 =
                edOperande2.text.toString().toDoubleOrNull() ?: return@setOnClickListener run {
                    // edOperande1.error
                    Toast.makeText(this, "Veuillez rentrer une donnee valide", Toast.LENGTH_SHORT)
                        .show()
                }
                val somme = operande1 + operande2
            txtAffichage.text = somme.toString()
        }
    }
}