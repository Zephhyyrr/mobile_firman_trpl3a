package com.firman.project1firman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class DuaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)

        val kota = findViewById<EditText>(R.id.editKota)
        val harga = findViewById<EditText>(R.id.editHarga)
        val jumlah = findViewById<EditText>(R.id.editJumlah)
        val cara = findViewById<Spinner>(R.id.editCara)
        val out = findViewById<TextView>(R.id.txtOutDetail)
        val proses = findViewById<Button>(R.id.btnProses)

        proses.setOnClickListener()
    }
}