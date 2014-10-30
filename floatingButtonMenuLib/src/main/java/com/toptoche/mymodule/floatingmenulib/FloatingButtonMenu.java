package com.toptoche.mymodule.floatingmenulib;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by romac on 10/29/2014.
 */
public class FloatingButtonMenu extends LinearLayout {

    private boolean isOpen;

    private View.OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
             /* Create Animation */
            Animation rotationFortyFive = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);

            Animation rotationZero = AnimationUtils.loadAnimation(getContext(), R.anim.rotation_zero);


            rotationZero.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isOpen = false;
                    imgActionButton.setImageResource(R.drawable.ic_new);
                    for (int i = 1; i < getChildCount(); i++) {
                        getChildAt(i).setVisibility(GONE);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            rotationFortyFive.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isOpen = true;
                    imgActionButton.setImageResource(R.drawable.ic_action_cancel);
                    for (int i = 1; i < getChildCount(); i++) {
                        getChildAt(i).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right));
                        getChildAt(i).setVisibility(VISIBLE);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

                /* start Animation */
            if (isOpen) {
                imgActionButton.startAnimation(rotationZero);
            } else {
                imgActionButton.startAnimation(rotationFortyFive);
            }


//            Toast.makeText(getContext(),String.valueOf(getChildCount()),Toast.LENGTH_SHORT).show();
        }
    };
    private ImageView imgActionButton;

    public FloatingButtonMenu(Context context) {
        this(context, null);
    }

    public FloatingButtonMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingButtonMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        float floatDimension = getResources().getDimension(R.dimen.action_button);
        LayoutParams layoutParams = new LayoutParams((int) floatDimension, (int) floatDimension);
        layoutParams.setMargins(10, 0, 10, 0);
        imgActionButton = new ImageView(context);

        if (Build.VERSION.SDK_INT >= 16) {
            imgActionButton.setBackground(getResources().getDrawable(R.drawable.upload_photo));
        } else {
            imgActionButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.upload_photo));
        }

        imgActionButton.setImageResource(R.drawable.ic_new);
        imgActionButton.setLayoutParams(layoutParams);
        imgActionButton.setPadding(7, 7, 7, 7);
        imgActionButton.setOnClickListener(clickListener);

        addView(imgActionButton);
    }

    public void addButton(int intIcon, OnClickListener onClickListener) {

        float floatDimension = getResources().getDimension(R.dimen.action_button);

        LayoutParams layoutParams = new LayoutParams((int) floatDimension, (int) floatDimension);
        layoutParams.setMargins(10, 0, 10, 0);

        ImageView imageView = new ImageView(getContext());

        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(getResources().getDrawable(R.drawable.upload_photo));
        } else {
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.upload_photo));
        }

        imageView.setImageResource(intIcon);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(7, 7, 7, 7);
        imageView.setOnClickListener(onClickListener);
        imageView.setVisibility(GONE);
        addView(imageView);
    }

}
