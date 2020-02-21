package my.tribeHired.app.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T>(var mContext: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<T>()

    override fun getItemCount(): Int {
        return list.size
    }

    open fun add(item: T) {
        list.add(item)
        notifyDataSetChanged()
    }

    open fun addAll(items: MutableList<T>?) {
        items?.let {
            list.addAll(it)
        }
        notifyDataSetChanged()
    }

    open fun remove(item : T?) {
        list.remove(item)
        notifyDataSetChanged()
    }

    open fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun getList(): MutableList<T> {
        return list
    }

    open fun getItem(position: Int): T? {
        return list[position]
    }

    open fun setList(list: MutableList<T>?) {
        list?.let {
            this.list = it
            notifyDataSetChanged()
        }
    }

    open fun getPositionByItem(item: T?): Int? {
        return this.list.indexOf(item)
    }

    open fun isFirstItem(position: Int) : Boolean {
        return position == 0
    }

    open fun isLastItem(position: Int) : Boolean{
        return position == list.size - 1
    }

}