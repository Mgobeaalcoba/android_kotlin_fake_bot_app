package com.example.fakebot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakebot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establezco la relación con mi dataBinding de activity_main:
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instanciamos en "onCreate" nuestro viewModel:
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Asigno nuestra instanciación del MainViewModel, que es viewModel como atributo mainViewModel del binding:
        // mainViewModel es la variable que creamos en el layout!!!
        binding.mainViewModel = viewModel

        // Establezco el tipo de Layout con el que voy a repetir mis elementos en la lista:
        binding.messagesRecycler.layoutManager = LinearLayoutManager(this)


        // Con el objeto adapter creado debo instanciar un adapter:
        adapter = ChatAdapter()
        // Asigno el adapter a mi data binding:
        binding.messagesRecycler.adapter = adapter
        // Le paso al adapter la lista de valores que debe replicar y cargar:
        adapter.submitList(viewModel.returnList())

        setupButtons()
    }
    private fun setupButtons() {

        binding.sendButton.setOnClickListener {

            if (binding.messageEdit.text.toString() == "") {
                Log.w("MainActivity","The message is empty")
                Toast.makeText(this, getString(R.string.empty_message),Toast.LENGTH_SHORT).show()
            } else {
                val text = binding.messageEdit.text.toString()
                viewModel.addMessage(Message("User", text, System.currentTimeMillis()))
                binding.chatEmptyView.visibility = View.GONE
                adapter.notifyItemInserted(viewModel.returnList()!!.size - 1)
                binding.messagesRecycler.scrollToPosition(viewModel.returnList()!!.size - 2)
                binding.messageEdit.text.clear()
                binding.sendButton.postDelayed(
                    {
                        val randomResponse = viewModel.returnMessage()
                        viewModel.addMessage(randomResponse)
                        adapter.notifyItemInserted(viewModel.returnList()!!.size - 1)
                        binding.messagesRecycler.scrollToPosition(viewModel.returnList()!!.size - 2)
                    },
                    1000)
            }
        }

    }
}
