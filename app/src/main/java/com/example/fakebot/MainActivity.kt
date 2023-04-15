package com.example.fakebot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakebot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establezco la relación con mi dataBinding de activity_main:
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Establezco el tipo de Layout con el que voy a repetir mis elementos en la lista:
        binding.messagesRecycler.layoutManager = LinearLayoutManager(this)

        // Creo una lista vacia donde voy a ir cargando los mensajes que voy a mostrar
        val messagesList = mutableListOf<Message>()
        val possibleAnswers = mutableListOf<Message>(
            Message("Bot","No", System.currentTimeMillis()),
            Message("Bot","Si", System.currentTimeMillis()),
            Message("Bot","Pregunta de nuevo", System.currentTimeMillis()),
            Message("Bot","Es muy probable", System.currentTimeMillis()),
            Message("Bot","No lo creo", System.currentTimeMillis()),
            Message("Bot","No sé \uD83D\uDE41", System.currentTimeMillis()),
            Message("Bot","Tal vez", System.currentTimeMillis()),
            Message("Bot","Solo Díos sabe", System.currentTimeMillis())
        )

//        // Harcodeo por el momento mi lista de mensajes:
//        messagesList.add(Message("User","¿Comeré tacos hoy?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","No", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Ganará Racing el Clásico de Avellaneda?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","Si", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Cuantos pares son tres botas?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","Pregunta de nuevo", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Seré millonario?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","Es muy probable", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Tendré problemas financieros en el corto plazo?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","No lo creo", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Argentina es un país para apostar?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","No sé \uD83D\uDE41", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Conviene pensar en nuevos horizontes?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","Tal vez", System.currentTimeMillis()))
//        messagesList.add(Message("User","¿Me voy al exterior entonces?", System.currentTimeMillis()))
//        messagesList.add(Message("Bot","Si", System.currentTimeMillis()))

        // Con el objeto adapter creado debo instanciar un adapter:
        val adapter = ChatAdapter()
        // Asigno el adapter a mi data binding:
        binding.messagesRecycler.adapter = adapter
        // Le paso al adapter la lista de valores que debe replicar y cargar:
        adapter.submitList(messagesList)

        binding.sendButton.setOnClickListener {

            if (binding.messageEdit.text.toString() == "") {
                Log.w("MainActivity","The message is empty")
                Toast.makeText(this, getString(R.string.empty_message),Toast.LENGTH_SHORT).show()
            } else {
                val text = binding.messageEdit.text.toString()
                val message = Message("User", text, System.currentTimeMillis())
                messagesList.add(message)
                binding.chatEmptyView.visibility = View.GONE
                adapter.notifyItemInserted(messagesList.size - 1)
                binding.messagesRecycler.scrollToPosition(messagesList.size - 2)
                binding.messageEdit.text.clear()
                binding.sendButton.postDelayed(
                    {
                        val randomResponse = possibleAnswers.random()
                        messagesList.add(randomResponse)
                        adapter.notifyItemInserted(messagesList.size - 1)
                        binding.messagesRecycler.scrollToPosition(messagesList.size - 2)
                    },
                    1000)
            }
        }
    }
}