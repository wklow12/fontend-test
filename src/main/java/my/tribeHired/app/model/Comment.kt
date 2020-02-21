package my.tribeHired.app.model

import com.google.gson.annotations.SerializedName

class Comment : BaseModel() {

    @SerializedName("postId")
    var postId : String? = null

    @SerializedName("name")
    var name : String? = null

    @SerializedName("email")
    var email : String? = null

    @SerializedName("body")
    var body : String? = null
}