package com.example.tictactoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun twoPlayers(view: View) {
        var intent = Intent(this,secondActivity::class.java)
        intent.putExtra("mode",1)
        startActivity(intent)
    }
    fun onePlayer(view:View) {
        var intent = Intent(this,secondActivity::class.java)
        intent.putExtra("mode",2)
        startActivity(intent)
    }

}
