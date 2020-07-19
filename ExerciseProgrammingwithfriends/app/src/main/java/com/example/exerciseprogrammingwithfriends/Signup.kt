package com.example.exerciseprogrammingwithfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener {
            if (edit_id.text.toString().length <= 0 || edit_password.text.toString().length <= 0) {
                Toast.makeText(this, "이이디과 패스워드를 기입해 주세요.", Toast.LENGTH_LONG).show()
            }
            else {
                auth.createUserWithEmailAndPassword(
                    edit_id.text.toString(), edit_password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.

                        }

                        // ...
                    }
            }
        }
    }
}