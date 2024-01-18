package com.example.appmovile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController

class inicio : Fragment(R.layout.fragment_inicio) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cl = requireView().findViewById<ConstraintLayout>(R.id.boton)
        val cl2 = requireView().findViewById<ConstraintLayout>(R.id.botonTriaje)
        val cl3 = requireView().findViewById<ConstraintLayout>(R.id.botonAtencion)
        val cl4 = requireView().findViewById<ConstraintLayout>(R.id.botonAcerca)

        cl.setOnClickListener{
            findNavController().navigate(R.id.action_inicio_to_historia)
        }

        cl2.setOnClickListener{
            findNavController().navigate(R.id.action_inicio_to_triaje)
        }

        cl3.setOnClickListener{
            findNavController().navigate(R.id.action_inicio_to_atencion)
        }

        cl4.setOnClickListener{
            findNavController().navigate(R.id.action_inicio_to_acerca)
        }
    }
}