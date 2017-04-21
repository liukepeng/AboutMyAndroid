package com.lkp.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.lkp.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.lkp.android.geoquiz.answer_shown";
    private static final String EXTRA_ANSWER_SHOWN_TWO = "com.lkp.android.geoquiz.answer_shown_two";
    private boolean mAnswerIsTrue;
    private boolean mIsCheater;
    private Button mShowButton;
    private TextView mAnswerTextView;
    private TextView mApiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mApiTextView = (TextView) findViewById(R.id.api_text);
        mApiTextView.setText("API：" + Build.VERSION.SDK_INT);

        mShowButton = (Button) findViewById(R.id.show_answer_button);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_text);
                }else{
                    mAnswerTextView.setText(R.string.false_text);
                }
                setAnswerShownResult(true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mShowButton.getWidth() / 2;
                    int cy = mShowButton.getHeight() / 2;
                    float radius = mShowButton.getWidth();
                    Animator anim = ViewAnimationUtils
                            .createCircularReveal(mShowButton, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mShowButton.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }else {
                    mShowButton.setVisibility(View.INVISIBLE);
                }
            }
        });
        if (savedInstanceState!=null){
            mIsCheater = savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN,false);
            setAnswerShownResult(mIsCheater);
        }
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        mIsCheater = isAnswerShown;
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent intent = new Intent(packageContext,CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(EXTRA_ANSWER_SHOWN,mIsCheater);
    }
}
