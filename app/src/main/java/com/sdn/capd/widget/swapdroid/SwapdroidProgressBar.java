package com.sdn.capd.widget.swapdroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.adprogressbarlib.AdCircleProgress;
import com.sdn.capd.R;

/**
 * Created by Swapnil Nandapure
 * This class is use to show progress dialog
 * https://github.com/Adilhusen/circle-progress-ad-android?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=7517
 */

public class SwapdroidProgressBar {

    private static Dialog dialog;
    @SuppressLint("StaticFieldLeak")
    private static TextView tvMessage;
    private static AdCircleProgress pgbProgress, pgbProgressIcon;
    private static boolean forNoProg;
    private static Handler handler;
    private static boolean showProgress = false;

    /**
     * function to use to show progress dialog
     *
     * @param activity - it contain context
     * @param message  - is an message of progress dialog
     */
    public static void showDialog(final Activity activity, final String message, final boolean forNoProgress, int resource) {
        try {
            dialog = new Dialog(activity); //, R.style.PopTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            try {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            } catch (Exception e) {
                e.printStackTrace();
            }
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.swapdroid_progress_bar);
            forNoProg = forNoProgress;

            ImageView iv_360Icon = dialog.findViewById(R.id.iv_360Icon);
            RelativeLayout rl_full_progress = dialog.findViewById(R.id.rl_full_progress);
            pgbProgress = dialog.findViewById(R.id.pgb_progress);
            pgbProgress.setMax(100);
            pgbProgress.setProgress(0);
            pgbProgressIcon = dialog.findViewById(R.id.pgb_progress_icon);
            pgbProgressIcon.setMax(100);
            pgbProgressIcon.setProgress(0);
            handler = new Handler();

            if (forNoProg) {
                rl_full_progress.setVisibility(View.VISIBLE);
                pgbProgress.setVisibility(View.GONE);
                showProgress = true;
                iv_360Icon.setImageResource(resource);
                handler.postDelayed(run, 100);
            } else {
                rl_full_progress.setVisibility(View.GONE);
                pgbProgress.setVisibility(View.VISIBLE);
            }

            tvMessage =  dialog.findViewById(R.id.tv_message);
            tvMessage.setText(message);

            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function use to update message and progress
     *
     * @param message - is contain updated message of dialog
     * @param progress - is contain performed progress of 100
     */
    public static void updateMessageAndProgress(final String message, final int progress) {
        try {
            if (dialog != null && dialog.isShowing()) {
                if (!forNoProg) {
                    tvMessage.setText(message);
                    pgbProgress.setProgress(progress);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this runnable is use to show temp progress
     */
    private static Runnable run = new Runnable() {
        @Override
        public void run() {
            try {
                if (showProgress) {
                    float prog = pgbProgressIcon.getProgress() + 5;
                    if (prog > 100) prog = 5;
                    pgbProgressIcon.setProgress(prog);
                    handler.postDelayed(run, 100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * function use to update progress
     *
     * @param progress - is contain performed progress of 100
     */
    public static void updateProgress(final int progress) {
        try {
            if (dialog != null && dialog.isShowing()) {
                if (!forNoProg) {
                    pgbProgress.setProgress(progress);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function to use to hide progress dialog
     */
    public static void hideDialog() {
        try {
            if (dialog != null && dialog.isShowing()) {
                showProgress = false;
                handler.removeCallbacks(run);
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function to use to hide progress dialog
     */
    public static int getProgress() {
        int progress = 0;
        try {
            if (dialog != null && dialog.isShowing()) {
                if (!forNoProg) {
                    progress = Integer.parseInt(String.valueOf(Math.round(pgbProgress.getProgress())));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progress;
    }
}