package cz.rimu.ilovememes.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cz.rimu.ilovememes.R
import cz.rimu.ilovememes.rest.model.HotChildren

class AllFunnyAdapter : RecyclerView.Adapter<AllFunnyAdapter.AllFunnyViewHolder>() {

    private lateinit var view: View
    private var hotChildren: List<HotChildren>? = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllFunnyViewHolder {
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.funny_row_item, parent, false)
        return AllFunnyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllFunnyViewHolder, position: Int) {
        holder.title.text = hotChildren?.get(position)?.data?.title

        Glide
            .with(holder.title.context)
            .load(hotChildren?.get(position)?.data?.thumbnail)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return hotChildren?.size ?: 0
    }

    class AllFunnyViewHolder(
        view: View
    ) :
        RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.hotTitle)
        val thumbnail: ImageView = view.findViewById(R.id.thumbnail)
    }

    fun updateHotChildren(newHotChildren: List<HotChildren>?) {
        hotChildren = newHotChildren
    }
}