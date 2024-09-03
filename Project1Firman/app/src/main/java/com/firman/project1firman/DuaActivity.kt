package com.firman.project1firman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DuaActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    //: =>extends -> inherits
    //, =>implements -> interface
    val arrayKota = arrayOf<String>("Jakarta","Padang","Bandung","Pekanbaru","Semarang","Surabaya")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)

        val kota = findViewById<EditText>(R.id.editKota)
        val harga = findViewById<EditText>(R.id.editHarga)
        val jumlah = findViewById<EditText>(R.id.editJumlah)
        val berangkat = findViewById<Spinner>(R.id.spinBerangkat)
        berangkat.onItemSelectedListener=this
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(this@DuaActivity, R.layout.spinner_style, arrayKota)
        aa.setDropDownViewResource(R.layout.spinner_style)
        berangkat.adapter = aa
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}