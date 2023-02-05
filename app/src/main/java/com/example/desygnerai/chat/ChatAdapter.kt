package com.example.desygnerai.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desygnerai.R


class ChatAdapter(context: Context, messages: List<Message>) :
    RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    private val MESSAGE_OUTGOING = 123
    private val MESSAGE_INCOMING = 321

    private var mMessages: List<Message>
    private var mContext: Context

    fun chatAdapter(context: Context, messages: List<Message>) {
        mMessages = messages
        mContext = context
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return if (viewType == MESSAGE_INCOMING) {
            val contactView: View =
                inflater.inflate(R.layout.message_incoming, parent, false)
            IncomingMessageViewHolder(contactView)
        } else if (viewType == MESSAGE_OUTGOING) {
            val contactView: View =
                inflater.inflate(R.layout.message_outgoing, parent, false)
                inflater.inflate(R.layout.message_outgoing, parent, false)
            OutgoingMessageViewHolder(contactView)
        } else {
            throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun getItemCount(): Int {
        return mMessages.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            MESSAGE_OUTGOING
        } else {
            MESSAGE_INCOMING
        }
    }


    abstract class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindMessage(message: Message?)
    }

    init {
        mMessages = messages
        mContext = context
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = mMessages[position]
        holder.bindMessage(message)
    }
    class IncomingMessageViewHolder(itemView: View) :
        MessageViewHolder(itemView) {
        var body: TextView
        override fun bindMessage(message: Message?) {
            // TODO: implement later
        }
        init {
            body = itemView.findViewById<View>(R.id.tvBody) as TextView
        }
    }

    class OutgoingMessageViewHolder(itemView: View) :
        MessageViewHolder(itemView) {
        var body: TextView
        override fun bindMessage(message: Message?) {
            // TODO: implement later
        }

        init {
            body = itemView.findViewById<View>(R.id.tvBody) as TextView
        }
    }
}
