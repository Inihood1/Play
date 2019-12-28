package com.inihood.grandmusic.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.inihood.grandmusic.R;
import com.inihood.grandmusic.ui.activities.base.AbsSlidingMusicPanelActivity;


public class Intro extends AppCompatActivity {
//    private static final String TAG = "Intro";
//    private static final int MAX_STEP = 2;
//
//    private ViewPager viewPager;
//    private MyViewPagerAdapter myViewPagerAdapter;
//    private Button btn_got_it;
//    private String title_array[] = {
//            "Hello",
//            "Welcome to play"
//    };
//    private String description_array[] = {
//            "Thank you installing",
//            "Play is a lightweight music player with you in mind. Design by Ini Hood",
//
//    };
//    private int about_images_array[] = {
//            R.drawable.img_wizard_1,
//            R.drawable.img_wizard_2,
//
//    };
//    private int color_array[] = {
//            R.color.purple_600,
//            R.color.deep_orange_600
//    };

//    public static void start(Context context) {
//        Intent intent = new Intent(context, Intro.class);
//        context.startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button button = findViewById(R.id.bt_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });

       // initComponent();
    }

//    private void initComponent() {
//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        btn_got_it = (Button) findViewById(R.id.btn_got_it);
//
//        // adding bottom dots
//        bottomProgressDots(0);
//
//        myViewPagerAdapter = new MyViewPagerAdapter();
//        viewPager.setAdapter(myViewPagerAdapter);
//        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
//
//        btn_got_it.setVisibility(View.GONE);
//        btn_got_it.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               goNext();
//            }
//        });
//
//        findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // finish();
//            }
//        });
//    }

    private void goNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

//    private void bottomProgressDots(int current_index) {
//        LinearLayout dotsLayout = findViewById(R.id.layoutDots);
//        ImageView[] dots = new ImageView[MAX_STEP];
//
//        dotsLayout.removeAllViews();
//        for (int i = 0; i < dots.length; i++) {
//            dots[i] = new ImageView(this);
//            int width_height = 15;
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
//            params.setMargins(10, 10, 10, 10);
//            dots[i].setLayoutParams(params);
//            dots[i].setImageResource(R.drawable.shape_circle);
//            dots[i].setColorFilter(getResources().getColor(R.color.overlay_dark_30), PorterDuff.Mode.SRC_IN);
//            dotsLayout.addView(dots[i]);
//        }
//
//        if (dots.length > 0) {
//            dots[current_index].setImageResource(R.drawable.shape_circle);
//            dots[current_index].setColorFilter(getResources().getColor(R.color.grey_10), PorterDuff.Mode.SRC_IN);
//        }
//    }
//
//    //  viewpager change listener
//    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
//
//        @Override
//        public void onPageSelected(final int position) {
//            bottomProgressDots(position);
//            if (position == title_array.length - 1) {
//                btn_got_it.setVisibility(View.VISIBLE);
//            } else {
//                btn_got_it.setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onPageScrolled(int arg0, float arg1, int arg2) {
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int arg0) {
//
//        }
//    };
//
//    /**
//     * View pager adapter
//     */
//    public class MyViewPagerAdapter extends PagerAdapter {
//        private LayoutInflater layoutInflater;
//
//        public MyViewPagerAdapter() {
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            View view = layoutInflater.inflate(R.layout.item_stepper_wizard_color, container, false);
//            ((TextView) view.findViewById(R.id.title)).setText(title_array[position]);
//            ((TextView) view.findViewById(R.id.description)).setText(description_array[position]);
//            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
//            ((RelativeLayout) view.findViewById(R.id.lyt_parent)).setBackgroundColor(getResources().getColor(color_array[position]));
//            container.addView(view);
//
//            return view;
//        }
//
//        @Override
//        public int getCount() {
//            return title_array.length;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object obj) {
//            return view == obj;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            View view = (View) object;
//            container.removeView(view);
//        }
//    }
}
