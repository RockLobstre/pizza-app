package com.rocklobstre.pizzaApp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch;
import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import com.rocklobstre.pizzaApp.R;
import com.rocklobstre.pizzaApp.model.Order;

public class IngredientsFragment extends Fragment {
    private Order order;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment IngredientsFragment.
     */
    public static IngredientsFragment newInstance() {
        IngredientsFragment fragment = new IngredientsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        Bundle bundle = getArguments();
        if (bundle != null)
            order = (Order) bundle.getSerializable("order");
        else
            order = new Order();

        final ToggleSwitch toggleSwitch1 = (ToggleSwitch)view.findViewById(R.id.ing1);
        toggleSwitch1.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng1(toggleSwitch1.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });


        final ToggleSwitch toggleSwitch2 = (ToggleSwitch)view.findViewById(R.id.ing2);
        toggleSwitch2.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng2(toggleSwitch2.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });

        final ToggleSwitch toggleSwitch3 = (ToggleSwitch)view.findViewById(R.id.ing3);
        toggleSwitch3.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng3(toggleSwitch3.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });

        final ToggleSwitch toggleSwitch4 = (ToggleSwitch)view.findViewById(R.id.ing4);
        toggleSwitch4.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng4(toggleSwitch4.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });

        final ToggleSwitch toggleSwitch5 = (ToggleSwitch)view.findViewById(R.id.ing5);
        toggleSwitch5.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng5(toggleSwitch5.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });

        final ToggleSwitch toggleSwitch6 = (ToggleSwitch)view.findViewById(R.id.ing6);
        toggleSwitch6.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                order.setIng6(toggleSwitch6.getCheckedTogglePosition());
                getActivity().getIntent().putExtra("order", order);
            }
        });

        return view;
    }

}
