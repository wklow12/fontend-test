package my.tribeHired.app.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_comment.view.*
import my.tribeHired.app.model.Comment

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(comment : Comment?) {

        comment?.let {

            itemView.mNameTV.text = it.name
            itemView.mBodyTV.text = it.body
        }

    }
}