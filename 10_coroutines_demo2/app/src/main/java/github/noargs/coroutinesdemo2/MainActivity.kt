package github.noargs.coroutinesdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Coroutines Demo 2
// - How to change the thread of a coroutine?

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tvCount)
        val countButton = findViewById<Button>(R.id.btnCount)
        val downloadButton = findViewById<Button>(R.id.btnDownload)

        countButton.setOnClickListener {
            textView.text = count++.toString()
        }
        downloadButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..100000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")

            // to prevent logcat: Unexpected EOF error causes by logcat unable to
            // catch up with all the log messages generating in high speed by a device
            // OR device shutdown OR logd crashes
            // you have to use `suspend` keyword with downloadUserData() function
            delay(100)
        }
    }

}

