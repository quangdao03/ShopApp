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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.shopapp.R;
import com.example.shopapp.adapter.HomeSliderAdapter;
import com.example.shopapp.adapter.ListDanhMucAdapter;
import com.example.shopapp.adapter.ListSP;
import com.example.shopapp.model.DanhMuc;
import com.example.shopapp.model.SanPham;

import java.util.ArrayList;
import java.util.List;
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
    RecyclerView rcyDanhMuc;
    ListDanhMucAdapter listDanhMucAdapter;
    List<DanhMuc> danhMucList = new ArrayList<>();

    RecyclerView rcySp;
    ListSP sp;
    List<SanPham> sanPhamList = new ArrayList<>();

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
        mapping();
        Danhmuc();
        SP();
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



    public void Danhmuc(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        rcyDanhMuc.setLayoutManager (linearLayoutManager);
        rcyDanhMuc.setHasFixedSize(true);

        listDanhMucAdapter = new ListDanhMucAdapter(getActivity(),danhMucList);
        rcyDanhMuc.setAdapter(listDanhMucAdapter);

        danhMucList.add(new DanhMuc(R.drawable.dress,"Dress"));
        danhMucList.add(new DanhMuc(R.drawable.shirt,"Shirt"));
        danhMucList.add(new DanhMuc(R.drawable.pants,"Pants"));
        danhMucList.add(new DanhMuc(R.drawable.dm1,"Tshirt"));
        danhMucList.add(new DanhMuc(R.drawable.dress,"Dress"));
        danhMucList.add(new DanhMuc(R.drawable.shirt,"Shirt"));


    }
    public void SP(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        rcySp.setLayoutManager (linearLayoutManager);
        rcySp.setHasFixedSize(true);

        sp = new ListSP(getActivity(),sanPhamList);
        rcySp.setAdapter(sp);

        sanPhamList.add(new SanPham(R.drawable.product_0,"Long Sleeve","420.000 đ"));
        sanPhamList.add(new SanPham(R.drawable.product_0,"Long Sleeve","420.000 đ"));
        sanPhamList.add(new SanPham(R.drawable.product_0,"Long Sleeve","420.000 đ"));
        sanPhamList.add(new SanPham(R.drawable.product_0,"Long Sleeve","420.000 đ"));
        sanPhamList.add(new SanPham(R.drawable.product_0,"Long Sleeve","420.000 đ"));


    }

    public void mapping(){
        rcyDanhMuc = view.findViewById(R.id.rcyDanhMuc);
        rcySp = view.findViewById(R.id.rcySp);
    }
}
