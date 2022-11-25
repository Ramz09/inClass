package com.example.inclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val list: List<User>) : RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder>() {
        inner class UserAdapterViewHolder(private val view: View) :
            RecyclerView.ViewHolder(view) {
            fun bind(data: User) {
                view.apply {
                    val tvUsername = findViewById<TextView>(R.id.tvUsername)
                    val tvPassword = findViewById<TextView>(R.id.tvPassword)
                    val tvEmail = findViewById<TextView>(R.id.tvEmail)
                    val tvNoHp = findViewById<TextView>(R.id.tvNoHp)
                    val tvKelas = findViewById<TextView>(R.id.tvKelas)
                    val btnEdit = findViewById<AppCompatImageButton>(R.id.btnEdit)
                    val btnDelete = findViewById<AppCompatImageButton>(R.id.btnDelete)
                    tvUsername.text = data.username
                    tvPassword.text = data.password
                    tvEmail.text = data.email
                    tvNoHp.text = data.noHp
                    tvKelas.text = data.kelas
                    /**
                     * handling button edit clicked
                     */
//                    btnEdit.setOnClickListener {
//                        itemClicked.editClicked(data)
//                    }
//                    /**
//                     * handling button delete clicked
//                     */
//                    btnDelete.setOnClickListener {
//                        itemClicked.deleteClicked(data)
//                    }
                }
            }
        }
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): UserAdapter.UserAdapterViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,
                parent, false)
            return UserAdapterViewHolder(view)
        }
        override fun onBindViewHolder(holder: UserAdapter.UserAdapterViewHolder, position:
        Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size
    }
    interface OnItemClicked {
        fun editClicked(data: User)
        fun deleteClicked(data: User)
    }
