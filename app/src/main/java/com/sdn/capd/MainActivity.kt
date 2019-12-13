package com.sdn.capd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.sdn.capd.databinding.ActivityMainBinding
import com.sdn.capd.widget.swapdroid.*

/**
 * Created by Swapnil Nandapure
 * 28 NOV 2019
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var currentProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnAlertDialog.setOnClickListener { showDialogWithTwoButtons() }
        binding.btnProgressDialog.setOnClickListener { showProgressDialog() }
        binding.btnInfiniteProgressDialog.setOnClickListener { showOnlyProgressDialog() }

    }

    /**
     * show alert dialog with positive and negative buttons
     * you can set message, title, top background color, positive and negative buttons.
     * you can hide message text, negative button by passing false value
     * you can change dialog icon as well
     */
    private fun showDialogWithTwoButtons() {
        SwapdroidAlertDialog.Builder(this)
            .setTitle(getString(R.string.rate_us_if_you_like_the_app))
            .setMessage(getString(R.string.do_you_really_want_to_exit))
            .isMessageVisible(true)
            .setBackgroundColor(Color.parseColor(SwapdroidColorConstants.BACK_COLOR))
            .setNegativeBtnText(getString(R.string.no))
            .isNegativeVisible(true)
            .setPositiveBtnBackground(Color.parseColor(SwapdroidColorConstants.POSITIVE_COLOR))
            .setPositiveBtnText(getString(R.string.yes))
            .isPositiveVisible(true)
            .setNegativeBtnBackground(Color.parseColor(SwapdroidColorConstants.NEGATIVE_COLOR))
            .setAnimation(SwapdroidAnimation.POP)
            .isCancellable(false)
            .setIcon(R.drawable.ic_info_icon, SwapdroidIcon.Visible)  //ic_star_border_black_24dp
            .OnPositiveClicked {

            }
            .OnNegativeClicked {
                // if this button is clicked, just close
                // the dialog box and do nothing
            }
            .build()
    }

    /**
     * show progress dialog with percentage
     */
    private fun showProgressDialog() {
        SwapdroidProgressBar.showDialog(
            this,
            getString(R.string.in_progress),
            false,
            R.drawable.ic_info_icon
        )
        SwapdroidProgressBar.updateMessageAndProgress(getString(R.string.in_progress), 0)
        currentProgress = 0
        progress()
    }

    /**
     * show progress dialog without percentage
     */
    private fun showOnlyProgressDialog() {
        SwapdroidProgressBar.showDialog(
            this,
            getString(R.string.in_progress),
            true,
            R.drawable.ic_info_icon
        )
        SwapdroidProgressBar.updateMessageAndProgress(getString(R.string.in_progress), 0)
        currentProgress = 0
        progress()
    }

    /**
     * update progress
     */
    private fun progress() {
        if (currentProgress < 100) {
            currentProgress += 1
            Handler().postDelayed({
                SwapdroidProgressBar.updateMessageAndProgress(
                    "$currentProgress% Progress Done.",
                    currentProgress
                )
                if (currentProgress == 100) {
                    SwapdroidProgressBar.hideDialog()
                } else {
                    progress()
                }
            }, 50)
        }
    }

    override fun onBackPressed() {
        finish()
    }
}
