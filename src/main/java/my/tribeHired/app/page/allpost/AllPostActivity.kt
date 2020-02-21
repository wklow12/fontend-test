package my.tribeHired.app.page.allpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_post.*
import my.tribeHired.app.R
import my.tribeHired.app.adapter.PostCommentAdapter
import my.tribeHired.app.model.BaseModel

class AllPostActivity : AppCompatActivity() {

    var allPostActivityViewModel : AllPostActivityViewModel?= null
    var postCommentAdapter : PostCommentAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        title = "All Post"

        allPostActivityViewModel = ViewModelProvider.NewInstanceFactory().create(AllPostActivityViewModel::class.java)
        postCommentAdapter = PostCommentAdapter(this, true)

        init()
    }

    private fun init() {


        mPostRV.adapter = postCommentAdapter
        mPostRV.layoutManager = LinearLayoutManager(this)

        allPostActivityViewModel?.allPostLD?.observe(this, Observer {

            postCommentAdapter?.setList(it as? MutableList<BaseModel>)
        })

        allPostActivityViewModel?.init()


    }
}
