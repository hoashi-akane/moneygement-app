package com.example.moneygement.controller

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.SavingAmountQuery
import com.example.TargetAmountQuery
import com.example.moneygement.R
import com.example.moneygement.repository.SavingsDetails
import com.example.moneygement.repository.TargetAmount
import com.example.moneygement.service.AuthService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var sa:Int =0
    var ta:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var encryptedSharedPreferences = AuthService().createAuthSharedPreferences(applicationContext)
        var userId = encryptedSharedPreferences.getInt("id", 0)
//      例外処理
        if(userId == 0){

        }

        GlobalScope.launch {
            var savingAmountQuery = SavingAmountQuery.builder()
                    .userId(userId)
                    .build()
            var targetAmountQuery = TargetAmountQuery.builder()
                    .userId(userId)
                    .build()

            var savingAmount = SavingsDetails().getSavingsAmout(savingAmountQuery)
            sa = savingAmount!!.expenseAmount()+ savingAmount.savingAmount()

            var targetAmount = TargetAmount().getTargetAmount(targetAmountQuery)
            ta = targetAmount!!


        }
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
                var i= Intent(this@MainActivity,DispShareLedgerActivity::class.java)
                startActivity(i)
        };

        var ibtn5 = findViewById<ImageButton>(R.id.imageButton9)
            ibtn5.setOnClickListener {
                var i= Intent(this@MainActivity,AdvisorIntroductionActivity::class.java)
                startActivity(i);
        };



        var textView1 = findViewById<TextView>(R.id.textView15)
        textView1.text = "¥" + ta.toString()

        var textView2 = findViewById<TextView>(R.id.textView16)
        textView2.text = "¥" + sa.toString()

        val t: Double =ta.toDouble()
        val s: Double =sa.toDouble()

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        var level = s / t
        println(sa)
        println(ta)
        println(level)
        when {
            level < 0.5 -> imageView2.setImageResource(R.mipmap.`level1`)
            level < 1.0 -> imageView2.setImageResource(R.mipmap.level2)
            level == 1.0 -> imageView2.setImageResource(R.mipmap.`level2`)
        }

    }
}