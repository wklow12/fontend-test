package my.tribeHired.app.page.allpost

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.tribeHired.app.DataRepository
import my.tribeHired.app.model.Post
import java.lang.Exception

class AllPostActivityViewModel : ViewModel() {

    val allPostLD = MutableLiveData<MutableList<Post>>()

    fun init() {

        viewModelScope.launch {

            try {

                val list = getAllPost()

                if(list.isNotEmpty()) {
                    allPostLD.postValue(list)
                }

            } catch ( ex : Exception) {

                ex.printStackTrace()
            }
        }
    }


    suspend fun getAllPost() : MutableList<Post> {

        return DataRepository.getAllPost()
    }
}