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
        val cara = findViewById<Spinner>(R.id.spinnCara)
        val trans = findViewById<TextView>(R.id.txtDetail)
        val proses = findViewById<Button>(R.id.btnProses)

        proses.setOnClickListener {
            val kotaTujuan = kota.text.toString()
            val hargaTiket = harga.text.toString().toDouble()
            val jumlahTiket = jumlah.text.toString().toInt()
            val totalBayar = hargaTiket*jumlahTiket
            trans.text =
                "Detail Transaksi : \n" +
                        "\n Kota Tujuan: $kotaTujuan " +
                        "\n Harga : $hargaTiket " +
                        "\n Jumlah Tiket : $jumlahTiket " +
                        "\n Total Bayar :  $totalBayar "
        }
    }
}