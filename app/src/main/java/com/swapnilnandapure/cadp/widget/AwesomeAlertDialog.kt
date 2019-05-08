package com.swapnilnandapure.cadp.widget

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.swapnilnandapure.cadp.R

/**
 * Created by Swapnil Nandapure
 * This class is use to show custom Alert Dialog
 */
class AwesomeAlertDialog private constructor(builder: Builder) {

    private val title: String?
    private val message: String?
    private val positiveBtnText: String?
    private val negativeBtnText: String?
    private val activity: Activity
    private val icon: Int
    private val visibility: AwesomeIcon?
    private val animation: AwesomeAnimation?
    private val pListener: AwesomeAlertDialogListener?
    private val nListener: AwesomeAlertDialogListener?
    private val pBtnColor: Int
    private val nBtnColor: Int
    private val bgColor: Int
    private val cancel: Boolean
    private val btnPositive: Boolean
    private val btnNegative: Boolean
    private val txtMessage: Boolean


    init {
        this.title = builder.title
        this.message = builder.message
        this.activity = builder.activity
        this.icon = builder.icon
        this.animation = builder.animation
        this.visibility = builder.visibility
        this.pListener = builder.pListener
        this.nListener = builder.nListener
        this.positiveBtnText = builder.positiveBtnText
        this.negativeBtnText = builder.negativeBtnText
        this.pBtnColor = builder.pBtnColor
        this.nBtnColor = builder.nBtnColor
        this.bgColor = builder.bgColor
        this.cancel = builder.cancel
        this.btnPositive = builder.btnPositive
        this.btnNegative = builder.btnNegative
        this.txtMessage = builder.txtMessage
    }


    class Builder(val activity: Activity) {
        var title: String? = null
        var message: String? = null
        var positiveBtnText: String? = null
        var negativeBtnText: String? = null
        var icon: Int = 0
        var visibility: AwesomeIcon? = null
        var animation: AwesomeAnimation? = null
        var pListener: AwesomeAlertDialogListener? = null
        var nListener: AwesomeAlertDialogListener? = null
        var pBtnColor: Int = 0
        var nBtnColor: Int = 0
        var bgColor: Int = 0
        var cancel = false
        var btnPositive = true
        var btnNegative = true
        var txtMessage = true

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setBackgroundColor(bgColor: Int): Builder {
            this.bgColor = bgColor
            return this
        }

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setPositiveBtnText(positiveBtnText: String): Builder {
            this.positiveBtnText = positiveBtnText
            return this
        }

        fun setPositiveBtnBackground(pBtnColor: Int): Builder {
            this.pBtnColor = pBtnColor
            return this
        }

        fun setNegativeBtnText(negativeBtnText: String): Builder {
            this.negativeBtnText = negativeBtnText
            return this
        }

        fun setNegativeBtnBackground(nBtnColor: Int): Builder {
            this.nBtnColor = nBtnColor
            return this
        }


        //setIcon
        fun setIcon(icon: Int, visibility: AwesomeIcon): Builder {
            this.icon = icon
            this.visibility = visibility
            return this
        }

        fun setAnimation(animation: AwesomeAnimation): Builder {
            this.animation = animation
            return this
        }

        //set Positive listener
        fun OnPositiveClicked(pListener: AwesomeAlertDialogListener): Builder {
            this.pListener = pListener
            return this
        }

        //set Negative listener
        fun OnNegativeClicked(nListener: AwesomeAlertDialogListener): Builder {
            this.nListener = nListener
            return this
        }

        fun isCancellable(cancel: Boolean): Builder {
            this.cancel = cancel
            return this
        }

        fun isPositiveVisible(btnPositive: Boolean): Builder {
            this.btnPositive = btnPositive
            return this
        }

        fun isNegativeVisible(btnNegative: Boolean): Builder {
            this.btnNegative = btnNegative
            return this
        }

        fun isMessageVisible(txtMessage: Boolean): Builder {
            this.txtMessage = txtMessage
            return this
        }

        fun build(): AwesomeAlertDialog {
            val message1: TextView
            val title1: TextView
            val iconImg: ImageView
            val nBtn: Button
            val pBtn: Button
            val view: View
            val dialog: Dialog
            if (animation == AwesomeAnimation.POP)
                dialog = Dialog(activity, R.style.PopTheme)
            else if (animation == AwesomeAnimation.SIDE)
                dialog = Dialog(activity, R.style.SideTheme)
            else if (animation == AwesomeAnimation.SLIDE)
                dialog = Dialog(activity, R.style.SlideTheme)
            else
                dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            try {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            dialog.setCancelable(cancel)
            dialog.setContentView(R.layout.custom_alert_dialog)

            //getting resources
            view = dialog.findViewById(R.id.background) as View
            title1 = dialog.findViewById<View>(R.id.title) as TextView
            message1 = dialog.findViewById<View>(R.id.message) as TextView
            iconImg = dialog.findViewById<View>(R.id.icon) as ImageView
            nBtn = dialog.findViewById<View>(R.id.negativeBtn) as Button
            pBtn = dialog.findViewById<View>(R.id.positiveBtn) as Button
            title1.text = title
            message1.text = message
            if (!txtMessage) message1.visibility = View.GONE
            if (!btnNegative) nBtn.visibility = View.GONE
            if (!btnPositive) pBtn.visibility = View.GONE

            if (positiveBtnText != null)
                pBtn.text = positiveBtnText
            if (pBtnColor != 0) {
                val bgShape = pBtn.background as GradientDrawable
                bgShape.setColor(pBtnColor)
            }
            if (nBtnColor != 0) {
                val bgShape = nBtn.background as GradientDrawable
                bgShape.setColor(nBtnColor)
            }
            if (negativeBtnText != null)
                nBtn.text = negativeBtnText
            iconImg.setImageResource(icon)
            if (visibility == AwesomeIcon.Visible)
                iconImg.visibility = View.VISIBLE
            else
                iconImg.visibility = View.GONE
            if (bgColor != 0)
                view.setBackgroundColor(bgColor)
            if (pListener != null) {
                pBtn.setOnClickListener {
                    pListener!!.OnClick()
                    dialog.dismiss()
                }
            } else {
                pBtn.setOnClickListener { dialog.dismiss() }
            }

            if (nListener != null) {
                nBtn.visibility = View.VISIBLE
                nBtn.setOnClickListener {
                    nListener!!.OnClick()

                    dialog.dismiss()
                }
            }


            dialog.show()

            return AwesomeAlertDialog(this)

        }
    }

}
