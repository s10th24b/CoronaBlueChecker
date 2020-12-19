package kr.s10th24b.app.coronabluechecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTest.setOnClickListener {
            val intent = Intent(this,CheckWebViewActivity::class.java)
            startActivity(intent)
        }
        buttonCheck.setOnClickListener {
            val intent = Intent(this,VisualizationMenu::class.java)
            startActivity(intent)
        }
    }
}