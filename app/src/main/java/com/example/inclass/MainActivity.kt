package com.example.inclass

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.UUID

class MainActivity : AppCompatActivity(){

//    private lateinit var kelas: Spinner
//    private lateinit var textUsername: EditText
//    private lateinit var textPassword: EditText
//    private lateinit var textEmail: EditText
//    private lateinit var textNoHp: EditText
//    private lateinit var bDaftar: Button
//    private val db = RealtimeDatabase.instance()
//    private lateinit var adapterUser: UserAdapter
//    private val listUser = mutableListOf<User>()
//    private val listKey = mutableListOf<String>()
//    private lateinit var rvUser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById()
//
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.kelas,
//            android.R.layout.simple_spinner_item
//        ).also { listPilihan ->
//            listPilihan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            kelas.adapter = listPilihan
//        }
//        bDaftar.setOnClickListener{
//            setDataToDatabase(
//                User(
//                    id = UUID.randomUUID().toString(),
//                    username = textUsername.getText().toString().trim(),
//                    password = textPassword.getText().toString().trim(),
//                    email = textEmail.getText().toString().trim(),
//                    noHp = textNoHp.getText().toString().trim(),
//                    kelas = kelas.selectedItem.toString().trim()
//                )
//            )
//        }
//        getDataFromDatabase()
//
//    }
//
//    private fun findViewById() {
//        kelas = findViewById(R.id.spinnerKelas)
//        textUsername = findViewById(R.id.textUsername)
//        textPassword = findViewById(R.id.textPassword)
//        textEmail = findViewById(R.id.textEmail)
//        textNoHp = findViewById(R.id.textNoHp)
//        bDaftar = findViewById(R.id.bDaftar)
//        rvUser = findViewById(R.id.rvUser)
//    }
//
//    private fun setDataToDatabase(user:User) {
//        if (user.username.isNotEmpty() && user.email.isNotEmpty() && user.password.isNotEmpty()
//            && user.noHp.isNotEmpty()){
//            bDaftar.isEnabled = false
//
//            db.getReference("user").child(user.id).setValue(user).addOnSuccessListener {
//                textUsername.setText("")
//                textEmail.setText("")
//                textPassword.setText("")
//                textNoHp.setText("")
//                bDaftar.isEnabled = true
//                Toast.makeText(
//                    this, "Data berhasil disimpan",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }.addOnFailureListener{
//                bDaftar.isEnabled = true
//                Toast.makeText(this, "Data gagal disimpan",
//                    Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        else {
//            Toast.makeText(this, "Isi data dengan benar", Toast.LENGTH_SHORT).show()
//        }
//
//        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as
//                InputMethodManager
//        imm.hideSoftInputFromWindow(textUsername.windowToken, 0)
//        imm.hideSoftInputFromWindow(textEmail.windowToken, 0)
//        imm.hideSoftInputFromWindow(textPassword.windowToken, 0)
//        imm.hideSoftInputFromWindow(textNoHp.windowToken, 0)
//    }
//    private fun getDataFromDatabase() {
//        val progressBar = findViewById<ProgressBar>(R.id.pbCircular)
//        progressBar.visibility = View.VISIBLE
//        db.getReference("user").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                progressBar.visibility = View.GONE
//                listKey.clear()
//                listUser.clear()
//                snapshot.children.map {
//                    it.key?.let { userId ->
//                        listKey.add(userId)
//                    }
//                }
//
//                listKey.map {
//                    listUser.add(
//                        User(
//                            id = snapshot.child(it).child("id").value.toString(),
//                            username = snapshot.child(it).child("username").value.toString(),
//                            password = snapshot.child(it).child("password").value.toString(),
//                            email = snapshot.child(it).child("email").value.toString(),
//                            noHp = snapshot.child(it).child("noHp").value.toString(),
//                            kelas = snapshot.child(it).child("kelas").value.toString()
//                        )
//                    )
//                }
//
//                adapterUser = UserAdapter(listUser.sortedBy { it.username })
//
//                initRecyclerView()
//            }
//            override fun onCancelled(error: DatabaseError) {
//                progressBar.visibility = View.GONE
//                Log.e("DB ERROR", error.message)
//            }
//        })
//    }
//    /**
//     * setup recycler view
//     */
//    private fun initRecyclerView() {
//        rvUser = findViewById(R.id.rvUser)
//        rvUser.apply {
//            layoutManager =
//                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,
//
//                    false)
//            adapter = adapterUser
//        }
//fun daftar(view: View){
//    val intKeDaftar = Intent(this, Signup::class.java)
//    startActivity(intKeDaftar)
//}
//
//    fun login(view: View){
//        val intKeLogin = Intent(this, Login::class.java)
//        startActivity(intKeLogin)
//    }
    }



}