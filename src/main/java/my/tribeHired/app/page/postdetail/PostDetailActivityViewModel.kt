package my.tribeHired.app.page.postdetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.tribeHired.app.DataRepository
import my.tribeHired.app.model.BaseModel
import my.tribeHired.app.model.Comment
import my.tribeHired.app.model.Post
import java.lang.Exception

class PostDetailActivityViewModel : ViewModel() {

    var postDetail : Post? = null
    var commentList : MutableList<Comment> ? = null

    val filterPostCommentListLD = MutableLiveData<MutableList<BaseModel>>()

    fun init(postId: String? ) {

        viewModelScope.launch {

            try {

                postDetail = getPostDetail(postId)
                commentList = getCommentList(postId)

                val list = mutableListOf<BaseModel>()

                postDetail?.let{
                    list.add(it)
                }

                commentList?.let{
                    list.addAll(it)
                }

                filterPostCommentListLD.postValue(list)

            } catch ( ex : Exception) {

                ex.printStackTrace()
            }
        }
    }

    fun filter(key : String) {

        val list = mutableListOf<BaseModel>()

        Log.d("###", "search $key")

        postDetail?.let{
            list.add(it)
        }

        list.addAll(commentList?.filter { it.name?.contains(key) == true || it.email?.contains(key) == true || it.body?.contains(key) == true} as MutableList)

        filterPostCommentListLD.postValue(list)
    }


    suspend fun getPostDetail(postId : String?) : Post {
        return DataRepository.getPostDetail(postId)
    }

    suspend fun getCommentList(postId: String?) : MutableList<Comment> {
        return DataRepository.getPostComment(postId)
    }

}