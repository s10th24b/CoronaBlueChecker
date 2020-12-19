package kr.s10th24b.app.coronabluechecker

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.expressions.Expression
import com.mapbox.mapboxsdk.style.layers.CircleLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.sources.VectorSource
import kotlinx.android.synthetic.main.activity_map_box_practice.*


/**
 * Set the radii of a CircleLayer's circles based on a data property.
 */
class MapBoxPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token))
        setContentView(R.layout.activity_map_box_practice)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.setStyle(Style.DARK) { style -> // replace examples.8mj5l1r9 with the map ID for the tileset
                // you created by uploading data to your Mapbox account
                style.addSource(VectorSource("trees-source", "mapbox://examples.8mj5l1r9"))
                val circleLayer = CircleLayer("trees-style", "trees-source")
                // replace street-trees-DC-9gvg5l with the name of your source layer
                circleLayer.sourceLayer = "street-trees-DC-9gvg5l"
                circleLayer.withProperties(
                    PropertyFactory.circleOpacity(0.6f),
                    PropertyFactory.circleColor(Color.parseColor("#ffffff")),
                    PropertyFactory.circleRadius(
                        Expression.interpolate(
                            Expression.exponential(1.0f), Expression.get("DBH"),
                            Expression.stop(0, 0f),
                            Expression.stop(1, 1f),
                            Expression.stop(110, 11f)
                        )
                    )
                )
                style.addLayer(circleLayer)
            }
        })
    }

    // Add the mapView's own lifecycle methods to the activity's lifecycle methods
    public override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}

