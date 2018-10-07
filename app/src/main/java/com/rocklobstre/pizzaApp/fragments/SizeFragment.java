package com.rocklobstre.pizzaApp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.model.Order;

public class SizeFragment extends Fragment {
    private ImageView pizza;
    private Order order;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment SizeFragment.
     */
    public static SizeFragment newInstance() {
        SizeFragment fragment = new SizeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_size, container, false);

        pizza = (ImageView)view.findViewById(R.id.imageView2);

        Bundle bundle = getArguments();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();

        final RadioGroup group= (RadioGroup) view.findViewById(R.id.rg);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.rb1:
                        order.setSize(0);
                        pizza.setPadding(convertDpToPx(50),convertDpToPx(50),convertDpToPx(50),convertDpToPx(50));
                        break;
                    case R.id.rb2:
                        order.setSize(1);
                        pizza.setPadding(convertDpToPx(40),convertDpToPx(40),convertDpToPx(40),convertDpToPx(40));
                        break;
                    case R.id.rb3:
                        order.setSize(2);
                        pizza.setPadding(convertDpToPx(30),convertDpToPx(30),convertDpToPx(30),convertDpToPx(30));
                        break;
                    case R.id.rb4:
                        order.setSize(3);
                        pizza.setPadding(convertDpToPx(20),convertDpToPx(20),convertDpToPx(20),convertDpToPx(20));
                        break;
                }
                getActivity().getIntent().putExtra("order", order);
            }
        });
        return view;
    }

    private int convertDpToPx(int dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }

}
