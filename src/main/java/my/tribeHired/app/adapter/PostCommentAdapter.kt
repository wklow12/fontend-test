package my.tribeHired.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.tribeHired.app.model.BaseModel
import my.tribeHired.app.model.Comment
import my.tribeHired.app.model.Post
import my.tribeHired.app.viewholder.CommentViewHolder
import my.tribeHired.app.viewholder.PostViewHolder
import my.tribeHired.app.R

class PostCommentAdapter(val context : Context?, val allowClickPost : Boolean) : BaseAdapter<BaseModel>(context)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> PostViewHolder(context, LayoutInflater.from(context).inflate(R.layout.viewholder_post, parent, false), allowClickPost)
            2 -> CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_comment, parent, false))
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> holder.bind(getItem(position) as? Post)
            is CommentViewHolder -> holder.bind(getItem(position) as? Comment)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Post -> 1
            is Comment -> 2
            else -> super.getItemViewType(position)
        }
    }
}