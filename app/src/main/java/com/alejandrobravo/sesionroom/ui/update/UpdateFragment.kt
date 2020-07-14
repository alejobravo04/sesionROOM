package com.alejandrobravo.sesionroom.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.alejandrobravo.sesionroom.R
import com.alejandrobravo.sesionroom.SesionROOM
import com.alejandrobravo.sesionroom.model.Deudor
import com.alejandrobravo.sesionroom.model.DeudorDAO
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.et_cantidad
import kotlinx.android.synthetic.main.fragment_update.et_nombre
import kotlinx.android.synthetic.main.fragment_update.et_telefono
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_update, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_telefono.visibility = View.GONE
        et_cantidad.visibility = View.GONE
        bt_actualizar.visibility = View.GONE
        var idDeudor = 0
        val deudorDAO: DeudorDAO = SesionROOM.database.DeudorDAO()

        bt_buscar.setOnClickListener{
            val nombre = et_nombre.text.toString()


            val Deudor = deudorDAO.buscarDeudor(nombre)

            if (Deudor !=null){
                idDeudor = Deudor.id
                et_telefono.visibility= View.VISIBLE
                et_cantidad.visibility = View.VISIBLE
                et_telefono.setText(Deudor.telefono)
                et_cantidad.setText(Deudor.cantidad.toString())
                bt_buscar.visibility = View.GONE
                bt_actualizar.visibility = View.VISIBLE
                

            }

        }

        bt_actualizar.setOnClickListener{
            val deudor = Deudor(
            idDeudor,
                et_nombre.text.toString(),
                et_telefono.text.toString(),
                et_cantidad.text.toString().toLong())
            deudorDAO.actualizarDeudor(deudor)
            et_telefono.visibility= View.GONE
            et_cantidad.visibility = View.GONE
            bt_buscar.visibility = View.VISIBLE
            bt_actualizar.visibility = View.GONE
        }
    }
}


