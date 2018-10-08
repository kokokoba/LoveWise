package jp.ne.com.kobayashi.videomatchingapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class StartActivity : AppCompatActivity() {

    private lateinit var mRegBtn: Button
    private lateinit var mLogBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        mRegBtn = findViewById(R.id.start_reg_btn)
        mLogBtn = findViewById(R.id.start_login_btn)

        mRegBtn.setOnClickListener {
            val regIntent = Intent(this, RegisterActivity::class.java)
            startActivity(regIntent)
        }

        mLogBtn.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}
