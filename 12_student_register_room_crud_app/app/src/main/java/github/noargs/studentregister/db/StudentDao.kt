package github.noargs.studentregister.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

  @Query("SELECT * FROM student_data_table")
  fun getAllStudents(): LiveData<List<Student>>

  @Insert
  suspend fun insertStudent(student: Student)

  @Update
  suspend fun updateStudent(student: Student)

  @Delete
  suspend fun deleteStudent(student: Student)

}