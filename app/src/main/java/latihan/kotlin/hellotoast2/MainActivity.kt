package latihan.kotlin.hellotoast2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cCount = 0
    var viewCount: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btn_toast)
        val btnCount = findViewById<Button>(R.id.btn_count)
        viewCount= findViewById<TextView>(R.id.count_view)

        btnToast.setOnClickListener{
            Toast.makeText(this,"This is Toast Button",Toast.LENGTH_SHORT).show()

        }
        Log.d("onCreate",cCount.toString())
        btnCount.setOnClickListener{
            cCount+=1
            viewCount?.setText(cCount.toString())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key",cCount)
        Log.d("onSaveInstanceState",cCount.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewCount?.setText(savedInstanceState.get("key").toString())
        Log.d("onRestoreInstanceState",cCount.toString())
    }
}
