package com.lkp.scrollerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eastmoney.scrollerview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_scroll_method).setOnClickListener(mOnClickLinstener);
        findViewById(R.id.btn_scroll_layout).setOnClickListener(mOnClickLinstener);
        findViewById(R.id.btn_scroll_pager).setOnClickListener(mOnClickLinstener);
    }
//    private View.OnClickListener mOnClickLinstener = v -> {
//        int id = v.getId();
//        switch (id){
//            case R.id.btn_scroll_method:{
//                startActivity(new Intent(this,ScrollMethodActivity.class));
//                break;
//            }
//            case R.id.btn_scroll_layout:{
//                startActivity(new Intent(this, ScrollLayoutActivity.class));
//                break;
//            }
//            case R.id.btn_scroll_pager:{
//                startActivity(new Intent(this,ScrollPagerActivity.class));
//                break;
//            }
//        }
//    };

    private View.OnClickListener mOnClickLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.btn_scroll_method: {
                    startActivity(new Intent(MainActivity.this, ScrollMethodActivity.class));
                    break;
                }
                case R.id.btn_scroll_layout: {
                    startActivity(new Intent(MainActivity.this, ScrollLayoutActivity.class));
                    break;
                }
                case R.id.btn_scroll_pager: {
                    startActivity(new Intent(MainActivity.this, ScrollPagerActivity.class));
                    break;
                }
            }
        }
    };
}
