package github.noargs.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    //var count = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cannot construct viewModel object as other objects
        // we have to need provider to construct the object
//        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)

        // textView.text = count.toString()
//        textView.text = viewModel.count.toString()

        button.setOnClickListener {
//            viewModel.updateCount()
//            textView.text = viewModel.count.toString()
        }

    }
}