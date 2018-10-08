package jp.ne.com.kobayashi.videomatchingapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mToolBar: Toolbar

    private lateinit var mViewPager: ViewPager
    private lateinit var mSectionsPagerAdapter: SectionsPagerAdapter

    private lateinit var mTabLayout: TabLayout

    // onCreateはアプリが起動されたときに呼び出される（最初の一度だけ実行)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        mToolBar = findViewById(R.id.main_page_toolbar)
        setSupportActionBar(mToolBar)
        supportActionBar?.title = "LoveWise"

        // Tabs
        mViewPager = findViewById(R.id.main_tabPager)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mViewPager.adapter = mSectionsPagerAdapter

        mTabLayout = findViewById(R.id.main_tabs)
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.currentUser

        // ユーザーがログインしていない場合
        if(currentUser == null) {
            sendToStart()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId == R.id.main_logout_btn) {
            FirebaseAuth.getInstance().signOut()
            sendToStart()
        }

        return true
    }

    // スタート画面に遷移
    private fun sendToStart() {
        // インテントの作成
        val startIntent = Intent(this, StartActivity::class.java)
        // 遷移先の画面を起動
        startActivity(startIntent)
        finish()
    }
}
