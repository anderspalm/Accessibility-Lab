package com.example.ander.shoppingcart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by ander on 7/25/2016.
 */
public class ItemFragment extends Fragment{

    private ViewPager mviewPager;
    private TabLayout mTabLayout;

    private PlaceholderFragment.OnListItemClickListener onListItemClickListener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.primary_item_fragment, parent, false);

        mviewPager = (ViewPager) rootView.findViewById(R.id.container);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        return rootView;
    }

    public static Fragment newInstance(PlaceholderFragment.OnListItemClickListener listener) {
        ItemFragment fragment = new ItemFragment();
        fragment.onListItemClickListener = listener;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onListItemClickListener
    }
}
