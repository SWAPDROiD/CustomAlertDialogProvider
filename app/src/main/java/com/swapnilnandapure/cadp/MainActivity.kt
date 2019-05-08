package com.swapnilnandapure.cadp

import android.app.Activity
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.swapnilnandapure.cadp.databinding.ActivityMainBinding
import com.swapnilnandapure.cadp.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.btnBoth.setOnClickListener {
            AwesomeAlertDialog.Builder(this)
                .setTitle("Your Title!")
                .setMessage("Your Message!")
                .isMessageVisible(false)
                .setBackgroundColor(Color.parseColor(ColorConstant.BACK_COLOR))  //Don't pass R.color.colorvalue
                .setNegativeBtnText("NO")
                .isNegativeVisible(true)
                .setPositiveBtnBackground(Color.parseColor(ColorConstant.POSITIVE_COLOR))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("YES")
                .isPositiveVisible(true)
                .setNegativeBtnBackground(Color.parseColor(ColorConstant.NEGATIVE_COLOR))  //Don't pass R.color.colorvalue
                .setAnimation(AwesomeAnimation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_info_icon, AwesomeIcon.Visible)  //ic_star_border_black_24dp
                .OnPositiveClicked(object : AwesomeAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .OnNegativeClicked(object : AwesomeAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .build()
        }

        binding.btnSingle.setOnClickListener {
            AwesomeAlertDialog.Builder(this)
                .setTitle("Your Title!")
                .setMessage("Your Message!")
                .isMessageVisible(true)
                .setBackgroundColor(Color.parseColor(ColorConstant.BACK_COLOR))  //Don't pass R.color.colorvalue
                .setNegativeBtnText("OK")
                .isNegativeVisible(true)
                .setPositiveBtnBackground(Color.parseColor(ColorConstant.POSITIVE_COLOR))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("OK")
                .isPositiveVisible(false)
                .setNegativeBtnBackground(Color.parseColor(ColorConstant.NEGATIVE_COLOR))  //Don't pass R.color.colorvalue
                .setAnimation(AwesomeAnimation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_info_icon, AwesomeIcon.Visible)  //ic_star_border_black_24dp
                .OnNegativeClicked(object : AwesomeAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .build()
        }

    }
}
