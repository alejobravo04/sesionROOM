package com.alejandrobravo.sesionroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*


class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val mAuth : FirebaseAuth = FirebaseAuth.getInstance()

        bt_registrar.setOnClickListener{

        val email = et_email.text.toString()
        val password = et_password.text.toString()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    this
                ){ task ->
                    if (task.isSuccessful) {
                        //crearUsuarioEnDatabase()
                        Toast.makeText(
                            this, "Registro exitoso",
                            Toast.LENGTH_SHORT
                        ).show()
                        onBackPressed()


                    } else {
                        Toast.makeText(
                            this, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.w("TAG", "signInWithEmail:failure", task.getException());

                    }

                }


        }
    }

    private fun crearUsuarioEnDatabase() {
        TODO("Not yet implemented")
    }
}

