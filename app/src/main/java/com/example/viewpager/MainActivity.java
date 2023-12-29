package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 vp2;
    MyViewPagerAdapter myAdapter;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        myAdapter.addFragment(new Frag1());
        myAdapter.addFragment(new Frag2());
        myAdapter.addFragment(new Frag3());

        vp2 = findViewById(R.id.viewPager2);
        vp2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        vp2.setAdapter(myAdapter);

        new TabLayoutMediator(
                tl,
                vp2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0){
                            tab.setText("Sad");
                        } else if (position == 1) {
                            tab.setText("Meh");
                        } else if (position == 2) {
                            tab.setText("Yay");
                        } else {
                            tab.setText("What");
                        }

                    }
                }
        ).attach();

    }
}