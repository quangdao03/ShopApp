package com.example.shopapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.example.shopapp.R;

public class AccountFragment extends Fragment {
    View view;
    LinearLayout orderContainer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_account, container,false);

        orderContainer = view.findViewById(R.id.orderContainer);
        orderContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderContainer.setClickable(true);
                Toast.makeText(getContext(), "Đây là acount", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
