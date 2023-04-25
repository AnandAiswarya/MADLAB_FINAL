package com.example.madlab3tab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager pager = findViewById(R.id.viewPager);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public Fragment getItem(int position)
            {
                return new Fragment();
            }

            @Override
            public int getCount()
            {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position)
            {
                if(position==0)
                    return "TAB 1";
                else if(position==1)
                    return "TAB 2";
                else
                    return "TAB 3";
            }
        };

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }
}