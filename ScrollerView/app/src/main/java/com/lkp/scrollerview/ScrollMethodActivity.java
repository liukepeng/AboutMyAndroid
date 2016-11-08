package com.lkp.scrollerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eastmoney.scrollerview.R;

public class ScrollMethodActivity extends AppCompatActivity {
    ViewGroup mContentRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_method);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContentRoot = (ViewGroup) findViewById(R.id.content_scroll_method);
        findViewById(R.id.btn_scroll_to).setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_scroll_by).setOnClickListener(mOnClickListener);
    }
//    private View.OnClickListener mOnClickListener = v -> {
//        int id = v.getId();
//        switch (id) {
//            case R.id.btn_scroll_to: {
//                mContentRoot.scrollTo(100, 100);
//                break;
//            }
//            case R.id.btn_scroll_by: {
//                mContentRoot.scrollBy(10, 20);
//                break;
//            }
//        }
//    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
        switch (id) {
            case R.id.btn_scroll_to: {
                mContentRoot.scrollTo(100, 100);
                break;
            }
            case R.id.btn_scroll_by: {
                mContentRoot.scrollBy(10, 20);
                break;
            }
        }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
