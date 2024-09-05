package com.firman.project1firman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DuaActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    //: =>extends -> inherits
    //, =>implements -> interface
    val kotaBerangkat = arrayOf<String>("Jakarta","Padang","Bandung","Pekanbaru","Semarang","Surabaya")
    lateinit var rbBayar:RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)

        val kota = findViewById<EditText>(R.id.editKota)
        val harga = findViewById<EditText>(R.id.editHarga)
        val jumlah = findViewById<EditText>(R.id.editJumlah)
        val bagasi = findViewById<CheckBox>(R.id.chkBagasi)
        val executive = findViewById<CheckBox>(R.id.chkExecutive)
        val makanan = findViewById<CheckBox>(R.id.chkMakanan)
        val rgBayar = findViewById<RadioGroup>(R.id.rgBayar)
        val berangkat = findViewById<Spinner>(R.id.spinBerangkat)
        berangkat.onItemSelectedListener = this
        //val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(this@DuaActivity, R.layout.spinner_style, kotaBerangkat)
        val trans = findViewById<TextView>(R.id.txtDetail)
        val proses = findViewById<Button>(R.id.btnProses)
        val aa = ArrayAdapter(this@DuaActivity, R.layout.spinner_style, kotaBerangkat)
        aa.setDropDownViewResource(R.layout.spinner_style)
        berangkat.adapter = aa


        proses.setOnClickListener {
            val kotaTujuan = kota.text.toString()
            val hargaTiket = harga.text.toString().toDouble()
            val jumlahTiket = jumlah.text.toString().toInt()
            val biayaTambahan = StringBuffer()
            var totalTambahan:Int=0
            if(bagasi.isChecked){
                biayaTambahan.append("\n\t\tBagasi Rp.200000")
                totalTambahan +=200000
            }
            if(executive.isChecked){
                biayaTambahan.append("\n\t\tExecutive Lounge Rp.800000")
                totalTambahan +=800000
            }
            if(makanan.isChecked){
                biayaTambahan.append("\n\t\tMakanan Rp.100000")
                totalTambahan +=100000
            }
            biayaTambahan.append("\nTotal tambahan " + totalTambahan)
            val selectedRadio:Int = rgBayar.checkedRadioButtonId
            rbBayar = findViewById (selectedRadio)
            val totalBayarTiket = hargaTiket*jumlahTiket
            val totalKeseluruhan = totalTambahan + totalBayarTiket
            trans.text =
                "Detail Transaksi : \n" +
                        "\n Kota Tujuan: $kotaTujuan" +
                        "\n Harga Tiket : $hargaTiket " +
                        "\n Jumlah Tiket : $jumlahTiket " +
                        "\n Biaya Tambahan : ${biayaTambahan.toString()}" +
                        "\n Total Bayar :  $totalBayarTiket " +
                        "\n Metode Pembayaran : "+ rbBayar.text.toString() +
                        "\n Biaya Keseluruhan : $totalKeseluruhan"
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val pilihKotaBerangkat:String = parent?.getItemAtPosition(position).toString()
        Toast.makeText( this@DuaActivity,"Kota Keberangkatan : $pilihKotaBerangkat ", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}