package com.first.logingirissp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sp=getSharedPreferences("Giris bilgisi",Context.MODE_PRIVATE)
        val kullanciadi=sp.getString("KullaniciAdi","Kullanici Adı Yok")
        val sıfre=sp.getString("Sifre","Sifre yok")
        val editor=sp.edit()



        if (kullanciadi!="Kullanici Adı Yok" && sıfre!="Sifre yok") {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()}
        else{

        buttonGiris.setOnClickListener {




                val gelenId = editTextTextPersonName.text.toString()
                val gelenSifre = editTextTextPassword.text.toString()

                if (gelenId == "admin" && gelenSifre == "123") {
                    editor.putString("KullaniciAdi", gelenId)
                    editor.putString("Sifre", gelenSifre)
                    editor.commit()

                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    finish()}

                else {
                    Toast.makeText(this@MainActivity, "Hatalı Giriş Yaptınız", Toast.LENGTH_SHORT)
                        .show()


                }
            }





        }

    }
}