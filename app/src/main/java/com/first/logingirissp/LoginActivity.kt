package com.first.logingirissp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sp=getSharedPreferences("Giris bilgisi", Context.MODE_PRIVATE)
        val kullaniciAdı=sp.getString("KullaniciAdi","Kullanici Adı Yok")
        val sıfre=sp.getString("Sifre","Sifre yok")

        textView2.text="Kullanıcı adı=${kullaniciAdı} Şifre ${sıfre}"


        buttonSil.setOnClickListener {
            val editor=sp.edit()
            editor.remove("KullaniciAdi")
            editor.remove("Sifre")
            editor.apply()
            val okunan=sp.getString("KullaniciAdi","Kullanici Adı Yok")
            val okunansifre=sp.getString("Sifre","Sifre yok")
            textView2.text="Kullanıcı adı=${okunan} Şifre ${okunansifre}"

        }
        buttonCikis.setOnClickListener {

            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()

        }
    }
}