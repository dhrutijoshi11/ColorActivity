package com.example.colorofsky;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button sunsetButton, sunriseButton;
    ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sunsetButton = findViewById(R.id.btnSunset);
        sunriseButton = findViewById(R.id.btnSunrise);




        sunsetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSunsetAnimation();

            }
        });

        sunriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSunriseAnimation();
            }
        });

    }
    private void startSunsetAnimation() {
        // Get references to the layout and sun views
        View layout = findViewById(R.id.main_layout);
        ImageView sun = findViewById(R.id.sun);
        View star_1 = findViewById(R.id.star);
        View star_2 = findViewById(R.id.star2);
        View star_3 = findViewById(R.id.star3);
        View star_4 = findViewById(R.id.star4);
        View star_5 = findViewById(R.id.star5);
        View star_6 = findViewById(R.id.star6);
        star_1.setVisibility(View.VISIBLE);
        star_2.setVisibility(View.VISIBLE);
        star_3.setVisibility(View.VISIBLE);
        star_4.setVisibility(View.VISIBLE);
        star_5.setVisibility(View.VISIBLE);
        star_6.setVisibility(View.VISIBLE);

        int startColor = Color.parseColor("#66ccff");
        int endColor = Color.parseColor("#191f26");
        int startSunColor = Color.parseColor("#CDDC39");
        int endSunColor = Color.parseColor("#e3dedc");


        ValueAnimator colorForSky = ValueAnimator.ofArgb(startColor, endColor);
        colorForSky.setDuration(4000);
        colorForSky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                layout.setBackgroundColor((int) animator.getAnimatedValue());
            }
        });


        ValueAnimator sunColor = ValueAnimator.ofArgb(startSunColor, endSunColor);
        sunColor.setDuration(4000);
        sunColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                sun.setColorFilter((int) animator.getAnimatedValue());
            }
        });

        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f, 1f);
        ObjectAnimator starAnimator = ObjectAnimator.ofPropertyValuesHolder(star_1, scaleX, scaleY);
        starAnimator.setDuration(2000);
        ObjectAnimator star2Animator = ObjectAnimator.ofPropertyValuesHolder(star_2, scaleX, scaleY);
        star2Animator.setDuration(2000);
        ObjectAnimator star3Animator = ObjectAnimator.ofPropertyValuesHolder(star_3, scaleX, scaleY);
        star3Animator.setDuration(2000);
        ObjectAnimator star4Animator = ObjectAnimator.ofPropertyValuesHolder(star_4, scaleX, scaleY);
        star4Animator.setDuration(2000);
        ObjectAnimator star5Animator = ObjectAnimator.ofPropertyValuesHolder(star_5, scaleX, scaleY);
        star5Animator.setDuration(2000);
        ObjectAnimator star6Animator = ObjectAnimator.ofPropertyValuesHolder(star_6, scaleX, scaleY);
        star6Animator.setDuration(2000);


        // Create an AnimatorSet to group the animations
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(colorForSky, sunColor,starAnimator,star2Animator,star3Animator,star4Animator, star5Animator, star6Animator);
        animatorSet.start();

    }

    private void startSunriseAnimation() {
        View layout = findViewById(R.id.main_layout);
        ImageView sun = findViewById(R.id.sun);
        View star_1 = findViewById(R.id.star);
        View star_2 = findViewById(R.id.star2);
        View star_3 = findViewById(R.id.star3);
        View star_4 = findViewById(R.id.star4);
        View star_5 = findViewById(R.id.star5);
        View star_6 = findViewById(R.id.star6);
        star_1.setVisibility(View.GONE);
        star_2.setVisibility(View.GONE);
        star_3.setVisibility(View.GONE);
        star_4.setVisibility(View.GONE);
        star_5.setVisibility(View.GONE);
        star_6.setVisibility(View.GONE);


        int startColor = Color.parseColor("#191f26");
        int endColor = Color.parseColor("#43bae0");
        int startSunColor = Color.parseColor("#e3dedc");
        int endSunColor = Color.parseColor("#fccb38");
        int animationDuration = 3000;

        ValueAnimator colorForSky = ValueAnimator.ofArgb(startColor, endColor);
        colorForSky.setDuration(animationDuration);
        colorForSky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                layout.setBackgroundColor((int) animator.getAnimatedValue());
            }
        });

        ValueAnimator sunColor = ValueAnimator.ofArgb(startSunColor, endSunColor);
        sunColor.setDuration(animationDuration);
        sunColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                sun.setColorFilter((int) animator.getAnimatedValue());
            }
        });

        ObjectAnimator sunColorChanging = ObjectAnimator.ofFloat(sun, "translationY", 1700f, 0f);
        sunColorChanging.setDuration(animationDuration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(colorForSky, sunColor, sunColorChanging);
        animatorSet.start();



    }

}