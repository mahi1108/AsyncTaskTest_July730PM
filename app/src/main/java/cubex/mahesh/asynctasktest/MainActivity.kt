package cubex.mahesh.asynctasktest

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    var iview:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iview = findViewById(R.id.iview)

        b1.setOnClickListener({
                var task = MyTask(iview!!)
                task.execute( )
        })

        var policy  = StrictMode.ThreadPolicy.Builder().
                                    permitAll().build()
         StrictMode.setThreadPolicy(policy)

    } //  OnCreate

    class MyTask(var iview:ImageView) : AsyncTask<Unit,Unit,Unit>()
    {
        var isr:InputStream? = null
        override fun doInBackground(vararg p0: Unit?) {
                val u =  URL("https://techcrunch.com/wp-content/uploads/2018/03/android-p.png?w=1390&crop=1")
                isr = u.openStream()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            var bmp = BitmapFactory.decodeStream(isr)
            iview.setImageBitmap(bmp)
        }

    }


} // MainActivity
