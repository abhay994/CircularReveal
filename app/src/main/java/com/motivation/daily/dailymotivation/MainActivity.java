package com.motivation.daily.dailymotivation;

import android.animation.Animator;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity {
    static NativeExpressAdView adView;
    static AdRequest request;
     RelativeLayout relativeLayout,relativeLayout1,relativeLayout3;
 Button button;
 Animator anim;
    boolean bb = true;
 ImageView floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=(RelativeLayout)findViewById(R.id.my_viw);
        relativeLayout3=(RelativeLayout)findViewById(R.id.vr44);
        relativeLayout1=(RelativeLayout)findViewById(R.id.my3);

                floatingActionButton=(ImageView) findViewById(R.id.fab);



      floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int transitionid =R.transition.my_trc;
                TransitionInflater transitionInflater=TransitionInflater.from(MainActivity.this);
                Transition transition=transitionInflater.inflateTransition(transitionid);
                final ViewGroup.LayoutParams originalParams = floatingActionButton.getLayoutParams();
                transition.addListener(new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(Transition transition) {

                    }

                    @Override
                    public void onTransitionEnd(Transition transition) {


                      /*  floatingActionButton.setVisibility(View.GONE);*/
                        floatingActionButton.setLayoutParams(originalParams);
                    anim();

                    }

                    @Override
                    public void onTransitionCancel(Transition transition) {

                    }

                    @Override
                    public void onTransitionPause(Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(Transition transition) {

                    }
                });
                TransitionManager.beginDelayedTransition(relativeLayout3,transition);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                if (bb){
                floatingActionButton.setImageResource(R.mipmap.ic_launcher);
              floatingActionButton.setLayoutParams(layoutParams);}
                else {
                    floatingActionButton.setImageResource(R.mipmap.ic_launcher_round);
                    floatingActionButton.setLayoutParams(layoutParams);
                }
            }
        });


    }
    void anim() {
        int cx = (relativeLayout3.getLeft() + relativeLayout3.getRight()) / 2;
        int cy = (relativeLayout3.getTop() + relativeLayout3.getBottom()) / 2;
        int finalRadius = (int) Math.hypot(relativeLayout3.getWidth(), relativeLayout3.getHeight());
        if (bb) {



            anim = ViewAnimationUtils.createCircularReveal(relativeLayout, cx, cy, 0, finalRadius);


            anim.setDuration(1000);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    floatingActionButton.setImageResource(R.mipmap.ic_launcher);


                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            relativeLayout.setVisibility(View.VISIBLE);


            anim.start();

            bb=false;

        } else {



           Animator anim2 = ViewAnimationUtils.createCircularReveal(relativeLayout1, cx, cy, finalRadius, 0);
            anim2.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    relativeLayout.setVisibility(View.GONE);

                    floatingActionButton.setImageResource(R.mipmap.ic_launcher_round);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            relativeLayout1.setVisibility(View.VISIBLE);
            anim2.setDuration(500);
            anim2.start();
            bb=true;
        }
    }
}

