package my.tribeHired.app

import my.tribeHired.app.model.Comment
import my.tribeHired.app.model.Post
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {

    @GET("posts")
    suspend fun getAllPost() : MutableList<Post>

    @GET("posts/{id}")
    suspend fun getPostDetail(@Path ("id") postId : String?) : Post

    @GET("comments")
    suspend fun getPostComment(@Query("postId") postId : String?) : MutableList<Comment>

}