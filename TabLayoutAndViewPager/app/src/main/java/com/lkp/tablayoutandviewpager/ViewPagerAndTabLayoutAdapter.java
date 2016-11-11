package com.lkp.tablayoutandviewpager;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class ViewPagerAndTabLayoutAdapter extends FragmentStatePagerAdapter {


    private List<String> tabNames;
    private List<BaseFragment> fragments;
    private List<Integer> tabIcs;
    private SpannableString spannableString;
    private Context context;

    public ViewPagerAndTabLayoutAdapter(FragmentManager fm,Context context,List<String> tabNames, List<BaseFragment> fragments,List<Integer> tabIcs) {
        super(fm);
        this.context = context; //获取图片资源的时候需要Context参数
        this.fragments = fragments;
        this.tabNames = tabNames; //每个Tab上的文字、可以为null
        this.tabIcs = tabIcs; //每个Tab上的图标，可以为null

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (tabNames == null){
            spannableString = new SpannableString(" ");
        }else{
            spannableString = new SpannableString(" " + tabNames.get(position));
        }
        if (tabIcs != null ){
            spannableString.setSpan(new ImageSpan(context,tabIcs.get(position)),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }
}
