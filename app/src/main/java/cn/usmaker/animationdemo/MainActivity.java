package cn.usmaker.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TextView text;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        mImageView = (ImageView) findViewById(R.id.image);
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(text,"translationX",-500f,0f);
                moveIn.setRepeatCount(1);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(text,"rotation",0f,360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(text,"alpha",1f,0f,1f);
                AnimatorSet animatorSet =  new AnimatorSet();
                animatorSet.play(rotate).with(fadeInOut).after(moveIn);
                animatorSet.setDuration(5000);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.d(TAG, "onAnimationStart: ");
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.d(TAG, "onAnimationEnd: ");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        Log.d(TAG, "onAnimationCancel: ");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        Log.d(TAG, "onAnimationRepeat: ");
                    }
                });
                break;
        }
    }
}
