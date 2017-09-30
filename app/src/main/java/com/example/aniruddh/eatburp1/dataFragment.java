package com.example.aniruddh.eatburp1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class dataFragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    final int[] ICONS = new int[]{
            R.drawable.icons8_restaurant_64,
            R.drawable.icons8_bread_64,
            R.drawable.icons8_wineglass_64,
            R.drawable.icons8_flower_64,
            R.drawable.icons8_happy_64,
    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sample, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                //setupTabIcons();
                tabLayout.getTabAt(0).setIcon(ICONS[0]);
                tabLayout.getTabAt(1).setIcon(ICONS[1]);
                tabLayout.getTabAt(2).setIcon(ICONS[2]);
                tabLayout.getTabAt(3).setIcon(ICONS[3]);
                tabLayout.getTabAt(4).setIcon(ICONS[4]);

            }
        });

        return view;
    }
   /* private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Dining");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons8_food_and_wine_64, 0, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Drinks");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons8_meal_64, 0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Cafes");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons8_restaurant_64, 0, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }*/

    private class sliderAdapter extends FragmentPagerAdapter {

        final  String tabs[]={"Dining Out","Cafes and More", "Night Life", "Authentic","Surprise Me" };
        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    return new contentFragment();

                case 1:

                    return new contentFragment1();

                case 2:
                    return new contentFragment2();

                case 3:

                    return new contentFragment3();

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 5;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
