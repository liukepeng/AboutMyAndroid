package lkp.com.swipedelete;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<String> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);

    }

    private void initData() {
        mListData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mListData.add("item" + i);
        }
        mMyAdapter.addData(mListData);
        mMyAdapter.notifyDataSetChanged();
    }

    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private List<String> mData;
        public void addData(List<String> data){
            mData = data;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_swipe_delete, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.mTextView.setText(mData.get(i));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.content_tv);
            }
        }
    }


}
