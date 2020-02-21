package my.tribeHired.app.model

import com.google.gson.annotations.SerializedName

class Post : BaseModel() {

    @SerializedName("userId")
    var userId: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("body")
    var body: String? = null

}