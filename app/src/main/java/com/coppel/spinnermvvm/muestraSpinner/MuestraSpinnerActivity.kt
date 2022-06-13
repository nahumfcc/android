package com.coppel.spinnermvvm.muestraSpinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.coppel.spinnermvvm.databinding.ActivityMuestraSpinnerBinding
import com.coppel.spinnermvvm.entities.EntityUser
import kotlinx.android.synthetic.main.activity_muestra_spinner.*

class MuestraSpinnerActivity : AppCompatActivity() {

    lateinit var binding: ActivityMuestraSpinnerBinding
    var listaUsuarios = mutableListOf<EntityUser>()
    private val userViewModel: MuestraSpinnerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuestraSpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.usersModel.observe(this) { users ->
            loadUsers(users.data)
        }

        initUsers()
    }

    private fun loadUsers(users:List<EntityUser>)
    {
        listaUsuarios = users.toMutableList()
        //listaUsuarios.add(EntityUser(true, "Nahum", "Cortés", "Cervantes", 1, "nahumfcc"))
        //listaUsuarios.add(EntityUser(true, "Paco", "Cortés", "Cervantes", 1, "pacorro"))
        //listaUsuarios.add(EntityUser(true, "Lorena", "Martinez", "Tejeda", 1, "lore"))

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listaUsuarios)
        spnrUsers.adapter = adapter

        spnrUsers.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewItemSelected.text = "Ha seleccionado a ${listaUsuarios[p2].nombre} ${listaUsuarios[p2].apellidoPaterno} ${listaUsuarios[p2].apellidoMaterno}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                viewItemSelected.text = ""
            }
        }

    }

    private fun initUsers()
    {
        userViewModel.getUsers()
    }
}