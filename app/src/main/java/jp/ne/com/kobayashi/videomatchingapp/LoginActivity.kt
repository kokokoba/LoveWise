package jp.ne.com.kobayashi.videomatchingapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth




class LoginActivity : AppCompatActivity() {

    private lateinit var mLoginEmail: TextInputLayout
    private lateinit var mLoginPassword: TextInputLayout

    private lateinit var mToolBar: Toolbar

    private lateinit var mLoginBtn: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        // ToolBar Set
        mToolBar = findViewById(R.id.login_toolbar)
        setSupportActionBar(mToolBar)
        supportActionBar?.title = "ログイン"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mLoginEmail = findViewById(R.id.login_email)
        mLoginPassword = findViewById(R.id.login_password)
        mLoginBtn = findViewById(R.id.login_btn)

        mLoginBtn.setOnClickListener {
            val email = mLoginEmail.editText?.text.toString()
            val password = mLoginPassword.editText?.text.toString()

            if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                println(email + password)

                loginUser(email, password)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, { task ->
                println(task)
                if (task.isSuccessful) {
                    val mainIntent = Intent(this, MainActivity::class.java)
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(mainIntent)
                    finish()
                } else {
                    Toast.makeText(this, "ログインできませんでした。フォームを確認してください。", Toast.LENGTH_LONG).show()
                }
            })
    }
}
