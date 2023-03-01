package github.noargs.viewmodeldemo.model

import kotlinx.coroutines.delay

class UserRepository {
  suspend fun getUsers(): List<User>{
    delay(8000)
    val users: List<User> = listOf(
      User(1, "Ibn"),
      User(2, "Sam"),
      User(3, "Jav"),
      User(4, "Jam"),
      User(5, "Fam")
    )
    return users
  }
}