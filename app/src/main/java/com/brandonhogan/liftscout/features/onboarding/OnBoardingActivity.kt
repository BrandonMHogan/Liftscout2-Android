package com.brandonhogan.liftscout.features.onboarding

import android.content.Intent
import android.os.Bundle
import com.brandonhogan.liftscout.R
import com.codemybrainsout.onboarder.AhoyOnboarderActivity
import android.widget.Toast
import android.support.v4.content.ContextCompat
import android.os.Build
import com.brandonhogan.liftscout.features.calendar.CalendarFragment
import com.codemybrainsout.onboarder.AhoyOnboarderCard


/**
 * @Creator         bhogan
 * @Date            2018-01-09
 * @Description     Onbarding activity is for the inital onbarding presented to a new user.
 * Will walk them through initial setup, and description of the application.
 */

class OnBoardingActivity: AhoyOnboarderActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val card1 = AhoyOnboarderCard(R.string.intro_slide_one_title, R.string.intro_slide_one_description, R.mipmap.ic_launcher)
        val card2 = AhoyOnboarderCard(R.string.intro_slide_two_title, R.string.intro_slide_two_description, R.drawable.ic_assignment_black_48px)
        val card3 = AhoyOnboarderCard(R.string.intro_slide_three_title, R.string.intro_slide_three_description, R.drawable.ic_assessment_black_48px)
        val card4 = AhoyOnboarderCard(R.string.intro_slide_four_title, R.string.intro_slide_four_description, R.drawable.ic_done_black_48px)

        card1.setBackgroundColor(R.color.black_transparent)
        card2.setBackgroundColor(R.color.black_transparent)
        card3.setBackgroundColor(R.color.black_transparent)
        card4.setBackgroundColor(R.color.black_transparent)

        val pages = ArrayList<AhoyOnboarderCard>()

        pages.add(card1)
        pages.add(card2)
        pages.add(card3)
        pages.add(card4)

        for (page in pages) {
            page.setTitleColor(R.color.white)
            page.setDescriptionColor(R.color.grey_200)
            //page.setTitleTextSize(dpToPixels(12, this));
            //page.setDescriptionTextSize(dpToPixels(8, this));
            //page.setIconLayoutParams(width, height, marginTop, marginLeft, marginRight, marginBottom);
        }

        setFinishButtonTitle("Begin")
        showNavigationControls(true)
        setGradientBackground()

        //set the button style you created
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button))
        }

//        val face = Typeface.createFromAsset(assets, "fonts/Roboto-Light.ttf")
//        setFont(face)

        setOnboardPages(pages)


    }


    override fun onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, CalendarFragment::class.java)
        startActivity(intent)

        finish()
    }

}