package com.example.moneygement.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moneygement.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume();

        var ibtn1 = findViewById<ImageButton>(R.id.imageButton5)
        ibtn1.setOnClickListener{
            var i = Intent(this@MainActivity, DispLedgerActivity::class.java)
            startActivity(i);
        };

        var ibtn2 = findViewById<ImageButton>(R.id.imageButton6)
        ibtn2.setOnClickListener{
                var i= Intent(this@MainActivity,DispLedgerGraphActivity::class.java)
                startActivity(i);
        };

        var ibtn3 = findViewById<ImageButton>(R.id.imageButton7)
            ibtn3.setOnClickListener{
                var i= Intent(this@MainActivity,DispCalendarActivity::class.java)
                startActivity(i);
        };

        var ibtn4 = findViewById<ImageButton>(R.id.imageButton8)
            ibtn4.setOnClickListener {
                var i= Intent(this@MainActivity,DispShareLedgerMenuActivity::class.java)
                startActivity(i)
        };

        var ibtn5 = findViewById<ImageButton>(R.id.imageButton9)
            ibtn5.setOnClickListener {
                var i= Intent(this@MainActivity,MemberInfoActivity::class.java)
                startActivity(i);
        };

        var ibtn6 = findViewById<Button>(R.id.adviserbtn)
        ibtn6.setOnClickListener{
            var i= Intent(this@MainActivity,DispAdvisorActivity::class.java)
            startActivity(i);
        };

        var ibtn7 = findViewById<ImageButton>(R.id.imageButton10)
        ibtn7.setOnClickListener {
            var i= Intent(this@MainActivity,AdvisorIntroductionActivity::class.java)
            startActivity(i);
        };

        var targetAmount = 80000
        var savingAmount = 70000

        var textView1 = findViewById<TextView>(R.id.textView15)
        textView1.text = "¥" + targetAmount.toString()

        var textView2 = findViewById<TextView>(R.id.textView16)
        textView2.text = "¥" + savingAmount.toString()

        val t: Double =targetAmount.toDouble()
        val s: Double =savingAmount.toDouble()

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        var level = s / t
        println(savingAmount)
        println(targetAmount)
        println(level)
        when {
            level < 0.5 -> imageView2.setImageResource(R.mipmap.`level1`)
            level < 1.0 -> imageView2.setImageResource(R.mipmap.level2)
            level == 1.0 -> imageView2.setImageResource(R.mipmap.`level2`)
        }




    }
}