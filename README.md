## Custom Alert Dialog Provider
You can use this project to show alert and progress dialogs with full customizable UI and animation.
This project is in Kotlin.

### Use Below Code
#### For Single Button
```
SwapdroidAlertDialog.Builder(this)
                .setTitle("Your Title!")
                .setMessage("Your Message!")
                .isMessageVisible(true)
                .setBackgroundColor(Color.parseColor(ColorConstant.BACK_COLOR)) 
                .setNegativeBtnText("OK")
                .isNegativeVisible(true)
                .setPositiveBtnBackground(Color.parseColor(ColorConstant.POSITIVE_COLOR))  
                .setPositiveBtnText("OK")
                .isPositiveVisible(false)
                .setNegativeBtnBackground(Color.parseColor(ColorConstant.NEGATIVE_COLOR)) 
                .setAnimation(SwapdroidAnimation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_info_icon, SwapdroidIcon.Visible)  //ic_star_border_black_24dp
                .OnNegativeClicked(object : SwapdroidAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .build()
```

#### For Double Buttons
```
SwapdroidAlertDialog.Builder(this)
                .setTitle("Your Title!")
                .setMessage("Your Message!")
                .isMessageVisible(false)
                .setBackgroundColor(Color.parseColor(ColorConstant.BACK_COLOR)) 
                .setNegativeBtnText("NO")
                .isNegativeVisible(true)
                .setPositiveBtnBackground(Color.parseColor(ColorConstant.POSITIVE_COLOR))  
                .setPositiveBtnText("YES")
                .isPositiveVisible(true)
                .setNegativeBtnBackground(Color.parseColor(ColorConstant.NEGATIVE_COLOR))  
                .setAnimation(SwapdroidAnimation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_info_icon, SwapdroidIcon.Visible)  //ic_star_border_black_24dp
                .OnPositiveClicked(object : SwapdroidAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .OnNegativeClicked(object : SwapdroidAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .build()
```

#### For Progress Bar
```
SwapdroidProgressBar.showDialog(
            this,
            getString(R.string.in_progress),
            false,
            R.drawable.ic_info_icon
        )
        SwapdroidProgressBar.updateMessageAndProgress(getString(R.string.in_progress), 0)
        
```

### Output :

<p align="center">
  <img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/first_screen.jpg" width="200">
<img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/second_screen.jpg.jpg" width="200">
<img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/third_screen.jpg.jpg" width="200">
</p>
