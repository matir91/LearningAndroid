package com.mirland.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mirland on 21/07/15.
 */
public class CheatActivity  extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.mirland.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.mirland.geoquiz.answer_shown";

    private static final String KEY_CHEAT = "index";


    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private LinearLayout mCheatLinearLayout;
    private Button mShowAnswer;

    private void showVersion(){
        TextView version = new TextView(this);
        version.setText("API level " + Build.VERSION.SDK_INT);
        mCheatLinearLayout = (LinearLayout)findViewById(R.id.cheatLinearLayout);
        mCheatLinearLayout.addView(version);
        version.setGravity(Gravity.CENTER);


    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = false;

        if (savedInstanceState != null) {
            mAnswerIsTrue = savedInstanceState.getBoolean(KEY_CHEAT, mAnswerIsTrue);
        }


        setAnswerShownResult(mAnswerIsTrue);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);


        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

        showVersion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_CHEAT, mAnswerIsTrue);
    }

}
