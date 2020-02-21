package my.tribeHired.app.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_post.view.*
import my.tribeHired.app.model.Post
import my.tribeHired.app.page.postdetail.PostDetailActivity

class PostViewHolder(val context : Context?, itemView : View, val allowClickPost : Boolean) : RecyclerView.ViewHolder(itemView) {

    fun bind(post : Post?) {

        post?.let{
            itemView.mTitleTV.text = it.title
            itemView.mBodyTV.text = it.body

            if(allowClickPost)
            itemView.setOnClickListener {_ ->

                PostDetailActivity.start(context, it.id)
            }
        }
    }

}