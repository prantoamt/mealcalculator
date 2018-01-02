package com.mealcalculator.pranto.mealcalculator;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HomeFragment extends Fragment {


    LinearLayout lv;
    ImageView img1, img2, img3, img4, img5;
    TextView txt1, txt2, txt3, txt4;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lv = (LinearLayout) view.findViewById(R.id.lv1);
        txt1 = new TextView(((MainActivity)getActivity()).getApplicationContext());
        txt1.setText("Hello, Welcome to Pranto's Meal Calculator. This Documentation will " +
                "help you to use the Calculator properly. First of all, swipe the menu bar from " +
                "left side. Now you will be able to select some options. ");
        txt1.setPadding(25,30,25,25);
        txt1.setTextSize(20);

        img1 = new ImageView(((MainActivity)getActivity()).getApplicationContext());
        img1.setImageResource(R.drawable.menu);

        txt2 = new TextView(((MainActivity)getActivity()).getApplicationContext());
        txt2.setText("To Calculate meal, select Calculate Meal option. Then a new Page will appear. " +
                "Here You will write your member's Name, Total number of meals eaten by him and Total " +
                "amount of Bazar costed by him.  Then press Submit Button. Try to use short form of " +
                "names. Because mobile screens are too small to display lengthy names. Follow this " +
                "proccess to Submit all of your members info. As a demo, suppose the 1st picture below " +
                "represents your December 2017 month's meal info. So, write every member's name, bazar & " +
                "meal one by one and press submit");

        txt2.setPadding(25,20,25,25);
        txt2.setTextSize(20);

        img4 = new ImageView(((MainActivity)getActivity()).getApplicationContext());
        img4.setImageResource(R.drawable.mealsheet);

        img2 = new ImageView(((MainActivity)getActivity()).getApplicationContext());
        img2.setImageResource(R.drawable.calculator_with_input);

        txt4 = new TextView(((MainActivity)getActivity()).getApplicationContext());
        txt4.setText("Once you have Submitted all Informations " +
                "of members then press Calculate button. ");
        txt4.setPadding(25,20,25,25);
        txt4.setTextSize(20);

        img5 = new ImageView(((MainActivity)getActivity()).getApplicationContext());
        img5.setImageResource(R.drawable.calculator);

        txt3 = new TextView(((MainActivity)getActivity()).getApplicationContext());
        txt3.setText("Thats it. Now you will see the " +
                "result. You can take a Screenshot of that page and share with your members.");
        txt3.setPadding(25,20,25,25);
        txt3.setTextSize(20);

        img3 = new ImageView(((MainActivity)getActivity()).getApplicationContext());
        img3.setImageResource(R.drawable.result);

        txt1.setTextColor(Color.WHITE);
        txt2.setTextColor(Color.WHITE);
        txt3.setTextColor(Color.WHITE);
        txt4.setTextColor(Color.WHITE);
        lv.addView(txt1);
        lv.addView(img1);
        lv.addView(txt2);
        lv.addView(img4);
        lv.addView(img2);
        lv.addView(txt4);
        lv.addView(img5);
        lv.addView(txt3);
        lv.addView(img3);





        return view;
    }


}
