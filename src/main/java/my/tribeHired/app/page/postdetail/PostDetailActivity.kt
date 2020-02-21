package my.tribeHired.app.page.postdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.activity_post.mPostRV
import kotlinx.android.synthetic.main.activity_post_detail.*
import my.tribeHired.app.R
import my.tribeHired.app.adapter.PostCommentAdapter

class PostDetailActivity : AppCompatActivity() {

    var postDetailActivityViewModel : PostDetailActivityViewModel?= null
    var postCommentAdapter : PostCommentAdapter? = null

    companion object {

        val EXTRA_POST_ID = "extra_post_id"

        fun start (context : Context?, postId : String?) {

            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra(EXTRA_POST_ID, postId)

            context?.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        title = "Post Detail"

        postDetailActivityViewModel = ViewModelProvider.NewInstanceFactory().create(PostDetailActivityViewModel::class.java)
        postCommentAdapter = PostCommentAdapter(this, false)

        init()
    }

    private fun init() {


        mPostRV.adapter = postCommentAdapter
        mPostRV.layoutManager = LinearLayoutManager(this)

        mSearchET.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                postDetailActivityViewModel?.filter(mSearchET.text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        postDetailActivityViewModel?.filterPostCommentListLD?.observe(this, Observer {

            postCommentAdapter?.setList(it)
        })

        postDetailActivityViewModel?.init(intent?.extras?.getString(EXTRA_POST_ID))


    }
}