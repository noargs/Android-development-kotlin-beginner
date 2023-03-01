package github.noargs.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val fruitsList = listOf<Fruit>(
        Fruit("Cherries", "Joe"),
        Fruit("Avocado", "Frank"),
        Fruit("Orange", "Tom"),
        Fruit("Apple", "Joe"),
        Fruit("Lemon", "Alex"),
        Fruit("Pear", "Joe"),
        Fruit("Banana", "Tom")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)

        // there are 3 layout manager to choose, Linear, Grid, StaggeredGrid Layout Manager
        // you can also create custom layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(
            this@MainActivity,
            "Supplier is : ${fruit.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}