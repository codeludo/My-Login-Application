package com.codeludo.myloginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.codeludo.myloginapplication.databinding.ActivitySegundaBinding
import com.codeludo.myloginapplication.databinding.FragmentLoginBinding

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySegundaBinding>(
            this, R.layout.activity_segunda)
        
        val nombre: String = intent.getStringExtra("nombre").toString()
        val mensaje = getString(R.string.mensaje_es_usuario) + nombre
        binding.apply {
            nombreText.text = mensaje
            nombreText.visibility = View.VISIBLE
        }


    }
}