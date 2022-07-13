package com.example.tictactoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_end.*

class endActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        var tmp = intent.extras!!.get("winner")
        if(tmp!=0)
        textView2.text="Player $tmp won!"
        else {
            textView2.text="It is a Draw !"
        }
    }
    fun playAgain(view: View) {
        startActivity(Intent(this,MainActivity::class.java))
    }
}
