package com.example.inclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class Login : AppCompatActivity() {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference
    private lateinit var context: Context
    private lateinit var btLogin : Button
    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        context = this
        btLogin = findViewById(R.id.btLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        btLogin.setOnClickListener(View.OnClickListener {
            val username: String = etUsername.text.toString()
            val password: String = etPassword.text.toString()
            if (username.isEmpty()) {
                etUsername.error = "Data tidak boleh kosong"
                etUsername.requestFocus()
            }
            else if (password.isEmpty()){
                etPassword.error = "Data tidak boleh kosong"
                etPassword.requestFocus()
            }else{
                val query: Query = database.child("user").orderByChild("username").equalTo(username)
                query.addListenerForSingleValueEvent(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()){
                            for (item in snapshot.children){
                                val user = item.getValue<User>()
                                if (user != null){
                                    if (user.password.equals(password)){
                                        startActivity(Intent(context, Landing::class.java))
                                    }else{
                                        Toast.makeText(context, "Password tidak terdaftar", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                        else{
                            Toast.makeText(context, "Username tidak terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, error.message, Toast.LENGTH_SHORT)
                    }

                })
            }

        })


    }

}
