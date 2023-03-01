package github.noargs.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitsList: List<Fruit>,
    private val clickListener:(Fruit) -> Unit
) : RecyclerView.Adapter<MyViewHodler>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHodler(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {
        val fruit = fruitsList[position]
//        holder.myTextView.text = fruit.name
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

}

class MyViewHodler(val view: View) : RecyclerView.ViewHolder(view) {
//    val myTextView = view.findViewById<TextView>(R.id.tvName)
    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit){
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener {
            clickListener(fruit)
        }
    }

}