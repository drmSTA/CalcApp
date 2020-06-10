package jp.techacademy.drmS

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import android.support.v4.app.NotificationCompat.getExtras



class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        textView4formula.setText(intent.getStringExtra("formula"))
        textView4computedValue.setText(intent.getStringExtra("computedValue"))
    }
}
