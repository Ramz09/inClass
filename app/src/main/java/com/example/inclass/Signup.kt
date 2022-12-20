package com.example.inclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import java.util.*

class Signup : AppCompatActivity() {

        private lateinit var kelas: Spinner
        private lateinit var textUsername: EditText
        private lateinit var textPassword: EditText
        private lateinit var textPassword2: EditText
        private lateinit var textEmail: EditText
        private lateinit var textNoHp: EditText
        private lateinit var bDaftar: Button
        private val db = RealtimeDatabase.instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        findViewById()

                ArrayAdapter.createFromResource(
            this,
            R.array.kelas,
            android.R.layout.simple_spinner_item
        ).also { listPilihan ->
                    listPilihan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    kelas.adapter = listPilihan
                }
        bDaftar.setOnClickListener{
            setDataToDatabase(
                User(
                    id = UUID.randomUUID().toString(),
                    username = textUsername.getText().toString().trim(),
                    password = textPassword.getText().toString().trim(),
                    email = textEmail.getText().toString().trim(),
                    noHp = textNoHp.getText().toString().trim(),
                    kelas = kelas.selectedItem.toString().trim()
                )
            )
        }

    }
    fun landing(view: View){
        val intKeLanding = Intent(this, Landing::class.java)
        startActivity(intKeLanding)
    }
        private fun findViewById() {
        kelas = findViewById(R.id.spKelas)
        textUsername = findViewById(R.id.etUsername)
        textPassword = findViewById(R.id.etPassword)
        textPassword2 = findViewById(R.id.etPassword2)
        textEmail = findViewById(R.id.etEmail)
        textNoHp = findViewById(R.id.etNoHp)
        bDaftar = findViewById(R.id.btDaftar)
    }
        private fun setDataToDatabase(user:User) {
        if (user.username.isNotEmpty() && user.email.isNotEmpty() && user.password.isNotEmpty()
            && user.noHp.isNotEmpty()){
            if (textPassword.text.toString().equals(textPassword2.text.toString())){
                bDaftar.isEnabled = false

                db.getReference("user").child(user.id).setValue(user).addOnSuccessListener {
                    textUsername.setText("")
                    textEmail.setText("")
                    textPassword.setText("")
                    textPassword2.setText("")
                    textNoHp.setText("")
                    bDaftar.isEnabled = true
                    Toast.makeText(
                        this, "Data berhasil disimpan",
                        Toast.LENGTH_SHORT
                    ).show()
                }.addOnFailureListener{
                    bDaftar.isEnabled = true
                    Toast.makeText(this, "Data gagal disimpan",
                        Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, "Isi data dengan benar", Toast.LENGTH_SHORT).show()
        }

        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        imm.hideSoftInputFromWindow(textUsername.windowToken, 0)
        imm.hideSoftInputFromWindow(textEmail.windowToken, 0)
        imm.hideSoftInputFromWindow(textPassword.windowToken, 0)
        imm.hideSoftInputFromWindow(textNoHp.windowToken, 0)
    }
}