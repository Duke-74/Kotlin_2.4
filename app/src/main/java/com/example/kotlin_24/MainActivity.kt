package com.example.kotlin_24

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.alpha

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val km = findViewById<EditText>(R.id.km)
        val m = findViewById<EditText>(R.id.m)
        val dm = findViewById<EditText>(R.id.dm)
        val sm = findViewById<EditText>(R.id.sm)
        val mm = findViewById<EditText>(R.id.mm)
        val result = findViewById<TextView>(R.id.result)
        val answer = findViewById<ImageView>(R.id.answer)

        val button = findViewById<Button>(R.id.inspect)
        button.setOnClickListener {

            val kmText = km.text.toString()
            var kmNum = kmText.toIntOrNull()
            if (kmNum == null) {
                kmNum = 2
            }

            val mText = m.text.toString()
            var mNum = mText.toIntOrNull()
            if (mNum == null){
                mNum = 1
            }

            val dmText = dm.text.toString()

            var dmNum = dmText.toIntOrNull()
            if (dmNum == null) {
                dmNum = 0
            }

            val smText = sm.text.toString()
            var smNum = smText.toIntOrNull()
            if (smNum == null) {
                smNum = 0
            }

            val mmText = mm.text.toString()
            var mmNum = mmText.toIntOrNull()
            if (mmNum == null) {
                mmNum = 0
            }

            if ((kmNum * 1000 == mNum) &&
                (mNum * 10 == dmNum) &&
                (dmNum * 10 == smNum) &&
                (smNum * 10 == mmNum)
            ) {
                result.text = "Отлично!"
                result.setTextColor(Color.parseColor("#0000cd"))
                answer.setImageResource(R.drawable.cool)
            }
            else{
                result.text = "Повторите материал, ответ неверный!"
                result.setTextColor(Color.parseColor("#B22222"))
                answer.setImageResource(R.drawable.bad)
            }
        }

        answer.setOnTouchListener { view, motionEvent ->
            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                if(answer.alpha != 0.1f) {
                    answer.alpha -= 0.1f
                    Log.i("Info", "Проверку прошёл")
                }
                if (answer.alpha <= 0.1f) {
                    answer.alpha = 1f
                    Log.i("Info", "Проверку не прошёл")
                }

            true
        }
    }
}