package com.example.shopapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.shopapp.R;
import com.example.shopapp.adapter.HomeSliderAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    private ImageSlider imageSlider;
    View view;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Timer timer;
    int page_position = 0;
    private int dotscount;
    private ImageView[] dots;
    private Integer[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4, R.drawable.slider5};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container,false);
        imageSlider = view.findViewById(R.id.imgSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://bizweb.dktcdn.net/100/376/467/themes/790294/assets/slider_1.jpg?1638519508746", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://bizweb.dktcdn.net/100/376/467/themes/790294/assets/slider_3.jpg?1638519508746", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://bizweb.dktcdn.net/100/376/467/themes/790294/assets/slider_2.jpg?1638519508746", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://aodabong.net/wp-content/uploads/2022/08/bo%CC%81ng-gia%CC%80y-99k.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://aodabong.net/wp-content/uploads/2022/08/c91b2f25bbc1739f2ad01.jpeg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        return  view;
    }
    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == dotscount) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                viewPager.setCurrentItem(page_position, true);
            }
        };

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 4000);
    }

}
