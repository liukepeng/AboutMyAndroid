package com.lkp.mysuspensionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SuspensionBarActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RelativeLayout mSuspensionBar;
    private TextView mSuspensionTv;
    private ImageView mSuspensionIv;
    private int mCurrentPosition = 0;

    private int mSuspensionHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspension_bar);

        mSuspensionBar = (RelativeLayout) findViewById(R.id.suspension_bar);
        mSuspensionTv = (TextView) findViewById(R.id.tv_nickname);
        mSuspensionIv = (ImageView) findViewById(R.id.iv_avatar);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final RecyclerAdapter adapter = new RecyclerAdapter();

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view == null )return;
                if (view.getTop() <= mSuspensionHeight){
                    mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                }else {
                    mSuspensionBar.setY(0);
                }
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()){
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    mSuspensionBar.setY(0);

                    updateSuspensionBar();
                }
            }
        });
    }
    private void updateSuspensionBar(){
        Picasso.with(SuspensionBarActivity.this)
                .load(getAvatarResId(mCurrentPosition))
                .centerInside()
                .fit()
                .into(mSuspensionIv);
        mSuspensionTv.setText("star " + mCurrentPosition);
    }
    private int getAvatarResId(int position) {

                return R.drawable.earth;

        }

    }
