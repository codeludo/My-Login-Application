package com.codeludo.myloginapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.codeludo.myloginapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    // clase usuarios
    data class Usuario(val nombre: String, val clave: String)

    // usuario especial
    private val usuarios: MutableList<Usuario> = mutableListOf(
        Usuario("camilo", "1234miclave"),
        Usuario("user", "1234")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false)
        val nombre_edit = binding.nombreEdit
        val clave_edit = binding.claveEdit

        binding.ingresarBtn.setOnClickListener {
            view: View ->

            val nombre = nombre_edit.text.toString()
            val clave = clave_edit.text.toString()

            if(verificarIngreso(nombre, clave)){
                TODO()
            }

        }
        return binding.root
    }

    private fun verificarIngreso(nombre: String, clave: String): Boolean {
        if(nombreVacio(nombre)){
            Toast.makeText(context, getText(R.string.mensaje_nombre_vacio),
                Toast.LENGTH_SHORT).show()
            return false
        }else if(claveVacio(clave)){
            Toast.makeText(context, getText(R.string.mensaje_clave_vacio),
                Toast.LENGTH_SHORT).show()
            return false
        }else if (nombreVacio(nombre) && claveVacio(clave)){
            Toast.makeText(context, getText(R.string.mensaje_campos_vacios),
                Toast.LENGTH_SHORT).show()
            return false
        }else if(!esNombreValido(nombre)) return false
        return true
    }

    private fun esNombreValido(nombre: String): Boolean {
        for (item in nombre) {
            if (item !in 'A'..'Z' && item !in 'a'..'z'){
                return false
            }
        }
        return true
    }

    private fun nombreVacio(nombre: String) = nombre == ""
    private fun claveVacio(clave: String) = clave == ""
}