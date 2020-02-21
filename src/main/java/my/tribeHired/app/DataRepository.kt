package my.tribeHired.app

import my.tribeHired.app.manager.RetrofitManager
import my.tribeHired.app.model.Comment
import my.tribeHired.app.model.Post


object DataRepository {

    suspend fun getAllPost() : MutableList<Post> {
        return RetrofitManager.appApi.getAllPost()
    }

    suspend fun getPostDetail(postId : String?) : Post {
        return RetrofitManager.appApi.getPostDetail(postId)
    }

    suspend fun getPostComment( postId : String?) : MutableList<Comment> {
        return RetrofitManager.appApi.getPostComment(postId)
    }
}