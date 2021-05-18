package com.ghostware.notificationlisttest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ghostware.notificationlisttest.databinding.RecylcerItemBinding

class Adapter(var notifications: ArrayList<NotificationObject>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recylcer_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val notification = notifications[position]
        if (holder is ViewHolder) {
            holder.binding.appName.text = notification.appName
            holder.binding.notification.text = notification.notification?.tickerText
            holder.binding.logo.setImageDrawable(notification.icon)
        }
    }

    class ViewHolder(@NonNull var binding: RecylcerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}