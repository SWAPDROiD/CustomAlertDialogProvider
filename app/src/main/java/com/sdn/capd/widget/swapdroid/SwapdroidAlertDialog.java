package com.sdn.capd.widget.swapdroid;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sdn.capd.R;

/**
 * Created by Swapnil Nandapure
 * This class is use to show custom Alert Dialog
 */
public class SwapdroidAlertDialog {

    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText;
        private Activity activity;
        private int icon;
        private SwapdroidIcon visibility;
        private SwapdroidAnimation animation;
        private SwapdroidAlertDialogListener pListener, nListener;
        private int pBtnColor, nBtnColor, bgColor;
        private boolean cancel = false, btnPositive = true, btnNegative = true, txtMessage = true;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBackgroundColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setPositiveBtnBackground(int pBtnColor) {
            this.pBtnColor = pBtnColor;
            return this;
        }

        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnBackground(int nBtnColor) {
            this.nBtnColor = nBtnColor;
            return this;
        }


        //setIcon
        public Builder setIcon(int icon, SwapdroidIcon visibility) {
            this.icon = icon;
            this.visibility = visibility;
            return this;
        }

        public Builder setAnimation(SwapdroidAnimation animation) {
            this.animation = animation;
            return this;
        }

        //set Positive listener
        public Builder OnPositiveClicked(SwapdroidAlertDialogListener pListener) {
            this.pListener = pListener;
            return this;
        }

        //set Negative listener
        public Builder OnNegativeClicked(SwapdroidAlertDialogListener nListener) {
            this.nListener = nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder isPositiveVisible(boolean btnPositive) {
            this.btnPositive = btnPositive;
            return this;
        }

        public Builder isNegativeVisible(boolean btnNegative) {
            this.btnNegative = btnNegative;
            return this;
        }

        public Builder isMessageVisible(boolean txtMessage) {
            this.txtMessage = txtMessage;
            return this;
        }

        /**
         * function to use to build and show alert dialog
         */
        public void build() {
            TextView message1, title1;
            ImageView iconImg, cancel_icon;
            Button nBtn, pBtn;
            View view;
            final Dialog dialog;
            if (animation == SwapdroidAnimation.POP)
                dialog = new Dialog(activity, R.style.PopTheme);
            else if (animation == SwapdroidAnimation.SIDE)
                dialog = new Dialog(activity, R.style.SideTheme);
            else if (animation == SwapdroidAnimation.SLIDE)
                dialog = new Dialog(activity, R.style.SlideTheme);
            else
                dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            try {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }catch (Exception e){
                e.printStackTrace();
            }
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.swapdroid_alert_dialog);

            //getting resources
            view = dialog.findViewById(R.id.background);
            title1 = dialog.findViewById(R.id.title);
            message1 = dialog.findViewById(R.id.message);
            iconImg = dialog.findViewById(R.id.icon);
            cancel_icon =  dialog.findViewById(R.id.cancel_icon);
            nBtn = dialog.findViewById(R.id.negativeBtn);
            pBtn = dialog.findViewById(R.id.positiveBtn);
            title1.setText(title);
            message1.setText(message);
            if(!txtMessage) message1.setVisibility(View.GONE);
            if(!btnNegative) nBtn.setVisibility(View.GONE);
            if(!btnPositive) pBtn.setVisibility(View.GONE);

            if (positiveBtnText != null)
                pBtn.setText(positiveBtnText);
            if (pBtnColor != 0) {
                GradientDrawable bgShape = (GradientDrawable) pBtn.getBackground();
                bgShape.setColor(pBtnColor);
            }
            if (nBtnColor != 0) {
                GradientDrawable bgShape = (GradientDrawable) nBtn.getBackground();
                bgShape.setColor(nBtnColor);
            }
            if (negativeBtnText != null)
                nBtn.setText(negativeBtnText);
            iconImg.setImageResource(icon);
            if (visibility == SwapdroidIcon.Visible)
                iconImg.setVisibility(View.VISIBLE);
            else
                iconImg.setVisibility(View.GONE);
            if (bgColor != 0)
                view.setBackgroundColor(bgColor);
            if (pListener != null) {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pListener.OnClick();
                        dialog.dismiss();
                    }
                });
            } else {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }

            if (nListener != null) {
                nBtn.setVisibility(View.VISIBLE);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nListener.OnClick();
                        dialog.dismiss();
                    }
                });
            }

            cancel_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            //show dialog
            dialog.show();
        }
    }

}
