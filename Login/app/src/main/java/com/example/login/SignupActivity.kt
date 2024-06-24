package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)

        binding.button2.setOnClickListener {
            val signupUsername = binding.editTextText2.text.toString()
            val signupPassword = binding.editTextTextPassword2.text.toString()
            signupDatabase(signupUsername, signupPassword)
        }

    }

    private fun signupDatabase(username: String, password: String){
        val insertRowId = databaseHelper.insertUser(username, password)
        if (insertRowId != -1L){
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show() // will show if the signup is successful or correct
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show() // it will show if the signup is failed or unsuccessful
        }
    }
}
