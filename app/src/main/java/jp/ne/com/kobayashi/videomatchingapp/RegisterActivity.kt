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




 class RegisterActivity : AppCompatActivity() {


    private lateinit var mDisplayName: TextInputLayout
    private lateinit var mEmail: TextInputLayout
    private lateinit var  mPassword: TextInputLayout
    private lateinit var mCreateBtn: Button

    private lateinit var mToolBar: Toolbar


    // Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // ToolBar Set
        mToolBar = findViewById(R.id.register_toolbar)
        setSupportActionBar(mToolBar)
        supportActionBar?.title = "会員登録"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Android Fields
        mDisplayName = findViewById(R.id.reg_display_name)
        mEmail = findViewById(R.id.login_email)
        mPassword = findViewById(R.id.login_password)
        mCreateBtn = findViewById(R.id.reg_create_btn)

        mCreateBtn.setOnClickListener{
            val displayName = mDisplayName.editText?.text.toString()
            val email = mEmail.editText?.text.toString()
            val password = mPassword.editText?.text.toString()

            if(!TextUtils.isEmpty(displayName) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                registerUser(displayName, email, password)
            }
        }

    }

     private fun registerUser(displayName: String, email: String, password: String) {
         mAuth.createUserWithEmailAndPassword(email, password)
             .addOnCompleteListener(this, { task ->
                 if (task.isSuccessful) {
                     val mainIntent = Intent(this, MainActivity::class.java)
                      (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                     startActivity(mainIntent)
                     finish()
                 } else {
                     Toast.makeText(this, "登録できませんでした。フォームを確認してください。", Toast.LENGTH_SHORT).show()
                 }
             })
     }
 }
