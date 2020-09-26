package com.nirajprajapati.circularprogress

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        circularProgressView.setRounded(true)
        cbRounded.setOnCheckedChangeListener { _, b ->
            circularProgressView.setRounded(b)
        }

        circularProgressView.setProgressColor(ContextCompat.getColor(this, R.color.colorPrimary))
        ivProgressColor.setOnClickListener { pickColor(ivProgressColor, 0) }
        circularProgressView.setProgressBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        ivBgColor.setOnClickListener { pickColor(ivBgColor, 1) }

        circularProgressView.setProgress(progress.progress.toFloat())
        progress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                circularProgressView.setProgress(p1.toFloat())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                /*required*/
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                /*required*/
            }
        })

        circularProgressView.setProgressWidth(dipToPixels(progressWidth.progress.toFloat()))
        progressWidth.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                circularProgressView.setProgressWidth(dipToPixels(p1.toFloat()))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                /*required*/
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                /*required*/
            }
        })

        circularProgressView.setBackgroundWidth(dipToPixels(bgWidth.progress.toFloat()))
        bgWidth.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                circularProgressView.setBackgroundWidth(dipToPixels(p1.toFloat()))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                /*required*/
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                /*required*/
            }
        })
    }

    private fun pickColor(ivColor: AppCompatImageView, i: Int) {
        ColorPickerDialogBuilder
            .with(this)
            .setTitle("Choose color")
            .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
            .density(12)
            .setPositiveButton("ok") { _, selectedColor, _ ->
                when (i) {
                    0 -> {
                        ivColor.setBackgroundColor(selectedColor)
                        circularProgressView.setProgressColor(selectedColor)
                    }
                    1 -> {
                        ivColor.setBackgroundColor(selectedColor)
                        circularProgressView.setProgressBackgroundColor(selectedColor)
                    }
                }
            }
            .setNegativeButton("cancel") { _, _ -> /*do nothing*/ }
            .build()
            .show()
    }

    private fun dipToPixels(dipValue: Float): Float {
        val metrics: DisplayMetrics = resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
    }
}