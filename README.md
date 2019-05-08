## Custom Alert Dialog Provider
You can use this project to show alert with good UI and animation from any where without eriting repetative things.
This project is in Kotlin.

### Use Below Code
##### For Single Button
```
AwesomeAlertDialog.Builder(this)
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
                .setAnimation(AwesomeAnimation.POP)
                .isCancellable(false)
                .setIcon(R.drawable.ic_info_icon, AwesomeIcon.Visible)  //ic_star_border_black_24dp
                .OnNegativeClicked(object : AwesomeAlertDialogListener {
                    override fun OnClick() {
                        // do something
                    }
                })
                .build()
```

##### For Double Buttons
```
AwesomeAlertDialog.Builder(this)
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
```

### Output :

<p align="center">
  <img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/first_screen.jpg" width="200">
<img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/second_screen.jpg.jpg" width="200">
<img src="https://github.com/SWAPDROiD/CustomAlertDialogProvider/blob/master/images/third_screen.jpg.jpg" width="200">
</p>
