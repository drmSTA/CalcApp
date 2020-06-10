package jp.techacademy.drmS

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button4addition.setOnClickListener(this)
        button4substraction.setOnClickListener(this)
        button4multiplication.setOnClickListener(this)
        button4division.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        view.apply {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        val textA:String = inputA.text.toString()
        val textB:String = inputB.text.toString()

        if(!textA.equals("") && !textB.equals("") && view is Button){


            val numberA = textA.toDouble();
            val numberB = textB.toDouble();
            if(numberB == 0.0 && view.id.equals(R.id.button4division)){
                Snackbar.make(view, "０で除算はできません", Snackbar.LENGTH_SHORT)
                    .setAction("確認",null).show()
                return
            }

            val formula:String = textA + " " + view.text.toString() + " " + textB
//            Log.d("UI_", formula)

            val computedValue:Double = when {
                view == button4addition -> numberA + numberB
                view == button4substraction -> numberA - numberB
                view == button4multiplication -> numberA * numberB
                view == button4division -> numberA / numberB
                else -> 0.0
            }

            val intent = Intent(this, Result::class.java)
            intent.putExtra("formula", formula)
            intent.putExtra("computedValue", computedValue.toString())
            startActivity(intent)
        }else{
            Snackbar.make(view, "数値を入力して下さい", Snackbar.LENGTH_SHORT)
                .setAction("確認",null).show()
            return
        }
    }
}
