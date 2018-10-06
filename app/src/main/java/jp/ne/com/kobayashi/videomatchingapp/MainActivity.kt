package jp.ne.com.kobayashi.videomatchingapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    // onCreateはアプリが起動されたときに呼び出される（最初の一度だけ実行)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.currentUser

        // ユーザーがログインしていない場合
        if(currentUser == null) {
            // インテントの作成
            val startIntent = Intent(this, StartActivity::class.java)
            // 遷移先の画面を起動
            startActivity(startIntent)
            finish()
        }
    }
}
