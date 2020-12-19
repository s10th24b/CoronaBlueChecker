package kr.s10th24b.app.coronabluechecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_visualization_menu.*

class VisualizationMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualization_menu)
        buttonPersonalVisual.setOnClickListener {
            val intent = Intent(this,PersonalVisualization::class.java)
            startActivity(intent)
        }
        buttonPublicVisual.setOnClickListener {
            val intent = Intent(this,WebViewPracticeActivity::class.java)
            startActivity(intent)
        }
    }
}