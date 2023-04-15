package com.example.fakebot

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fakebot.databinding.ChatListItemsBinding

class ChatAdapter : ListAdapter<Message, ChatAdapter.ChatViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.content == newItem.content
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ChatViewHolder {

        // El binding en los adapter se carga de forma algo distinta. Cambia el contenido del .inflate():
        val binding = ChatListItemsBinding.inflate(LayoutInflater.from(parent.context))
        return ChatViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ChatAdapter.ChatViewHolder, position: Int) {

        val message = getItem(position)
        holder.bind(message)

    }


    inner class ChatViewHolder(private val binding : ChatListItemsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            binding.chatListMessage.text = message.content

            if (message.transmitter == "User") {
                binding.chatListMessage.setBackgroundResource(R.color.green)
                binding.chatListMessage.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            } else {
                binding.chatListMessage.setBackgroundResource(R.color.blue)
                binding.chatListMessage.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            }

            binding.executePendingBindings()
        }
    }
}