package github.noargs.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.noargs.viewmodeldemo.model.User
import github.noargs.viewmodeldemo.model.UserRepository
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

  private var userRepository = UserRepository()
  var users: MutableLiveData<List<User>> = MutableLiveData()

//  private val job = Job()
//  private val scope = CoroutineScope(Dispatchers.IO + job)

  // instead of creating scope and tie a job you rather use
  // viewModelScope instead
  // from implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
  fun getUserData() {
    viewModelScope.launch {
      var result: List<User>? = null
      withContext(Dispatchers.IO){
        result = userRepository.getUsers()
      }
      users.value = result
    }
  }

  // ViewModel when gets removed from the memory it invokes onCleared
  // some of coroutines we launched can run even after the ViewModel
  // is cleared from memory and potentially cause memory leaks
//  override fun onCleared() {
//    super.onCleared()
//    job.cancel()
//  }
}