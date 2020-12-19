package kr.s10th24b.app.coronabluechecker

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_personal_visualization.*


class PersonalVisualization : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_visualization)
        piechart.setUsePercentValues(true)
        piechart.description.isEnabled = false
        piechart.setExtraOffsets(5f, 10f, 5f, 5f)
        piechart.dragDecelerationFrictionCoef = 0.95f
        piechart.isDrawHoleEnabled = false
        piechart.setHoleColor(Color.BLACK)
        piechart.transparentCircleRadius = 61f

        val yValues = ArrayList<PieEntry>()

        yValues.add(PieEntry(5.3f, "종로구"))
        yValues.add(PieEntry(3.2f, "중구"))
        yValues.add(PieEntry(2.1f, "용산구"))
        yValues.add(PieEntry(6.1f, "성동구"))
        yValues.add(PieEntry(6.5f, "광진구"))
        yValues.add(PieEntry(2.1f, "동대문구"))
        yValues.add(PieEntry(6f, "중랑구"))
        yValues.add(PieEntry(7.3f, "성북구"))
        yValues.add(PieEntry(5.7f, "강북구"))
        yValues.add(PieEntry(6f, "도봉구"))
        yValues.add(PieEntry(6.3f, "노원구"))
        yValues.add(PieEntry(7.6f, "은평구"))
        yValues.add(PieEntry(2.9f, "서대문구"))
        yValues.add(PieEntry(2.6f, "마포구"))
        yValues.add(PieEntry(3.6f, "양천구"))
        yValues.add(PieEntry(3.6f, "강서구"))
        yValues.add(PieEntry(2.7f, "구로구"))
        yValues.add(PieEntry(5.4f, "금천구"))
        yValues.add(PieEntry(3.1f, "영등포구"))
        yValues.add(PieEntry(10.6f, "동작구"))
        yValues.add(PieEntry(3.8f, "관악구"))
        yValues.add(PieEntry(5f, "서초구"))
        yValues.add(PieEntry(5.4f, "강남구"))
        yValues.add(PieEntry(2.8f, "송파구"))
        yValues.add(PieEntry(6.4f, "강동구"))


        piechart.description = Description().apply {
            text = "서울 시민 우울감 경험률"
            textSize = 15f
        }

        piechart.animateY(1000, Easing.EasingOption.EaseInOutCubic) //애니메이션

        val dataSet = PieDataSet(yValues, "").apply {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.JOYFUL_COLORS)
        }

        val data = PieData(dataSet).apply {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
        }

        piechart.data = data
    }
}