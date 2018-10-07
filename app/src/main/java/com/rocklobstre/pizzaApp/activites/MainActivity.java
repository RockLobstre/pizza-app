package com.rocklobstre.pizzaApp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;

import java.util.Objects;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.fragments.IngredientsFragment;
import com.rocklobstre.pizzaApp.fragments.SizeFragment;
import com.rocklobstre.pizzaApp.model.Order;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private SizeFragment sizeInstance;
    private IngredientsFragment ingredientsInstance;
    private Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        final Button next = (Button)findViewById(R.id.nextbt);
        final Button prev = (Button)findViewById(R.id.prevbt);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //disable manual paging
        ((View) mViewPager).setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(getItem(+1), true);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        next.setText(getResources().getString(R.string.next));
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mViewPager.setCurrentItem(getItem(+1), true);
                            }
                        });
                        prev.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                        break;
                    case 1:
                        next.setText(getResources().getString(R.string.checkout));
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                                intent.putExtra("order", Objects.requireNonNull(getIntent().getExtras()).getSerializable("order"));
                                startActivity(intent);
                            }
                        });
                        prev.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mViewPager.setCurrentItem(getItem(-1), true);
                            }
                        });
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("order", order);
            switch (position){
                case 0:
                    sizeInstance = SizeFragment.newInstance();
                    sizeInstance.setArguments(bundle);
                    return sizeInstance;
                case 1:
                    ingredientsInstance = IngredientsFragment.newInstance();
                    ingredientsInstance.setArguments(bundle);
                    return ingredientsInstance;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
            }
            return null;
        }
    }

    private int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }


}
