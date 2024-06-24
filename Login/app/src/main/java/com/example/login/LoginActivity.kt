package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.button.setOnClickListener {
            val loginUsername = binding.editTextText.text.toString()
            val loginPassword = binding.editTextTextPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }
    }

        private fun loginDatabase(username: String, password: String){
            val userExists = databaseHelper.readUser(username, password) // to find the data of the username and password on the database
            if (userExists){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show() // if the login is successful
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show() // if unsuccessful
            }
        }
}