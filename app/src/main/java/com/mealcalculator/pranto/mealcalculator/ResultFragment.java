package com.mealcalculator.pranto.mealcalculator;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    TextView meal_rate;
    TextView name_field;
    TextView bazar_field;
    TextView meal_field;
    TextView will_get_field;
    TextView will_pay_field;
    TableLayout t1;
    TableRow tr;
    Context context;

    public ResultFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        context = ((MainActivity)getActivity()).getApplicationContext();
        meal_rate = (TextView) view.findViewById(R.id.mealratetxt);
        meal_rate.setText("Meal Rate: " + String.format("%.2f", ((MainActivity)getActivity()).meal_rate));
        int members = ((MainActivity)getActivity()).list.size();
        t1 = (TableLayout) view.findViewById(R.id.table1);
        t1.setColumnStretchable(0,true);
        t1.setColumnStretchable(1,true);
        t1.setColumnStretchable(2,true);
        t1.setColumnStretchable(3,true);
        t1.setColumnStretchable(4,true);

        for(int i = 0; i < members; i++)
        {
            tr = new TableRow(context);
            name_field = new TextView(context);
            name_field.setBackgroundColor(Color.parseColor("#808080"));
            name_field.setTextColor(Color.BLACK);
            name_field.setText(((MainActivity)getActivity()).list.get(i).getName());
            name_field.setGravity(Gravity.CENTER);
            name_field.setPadding(5,5,5,5);
            meal_field = new TextView(context);
            meal_field.setText(String.format("%.2f", ((MainActivity)getActivity()).list.get(i).getMeal()));
            meal_field.setGravity(Gravity.CENTER);
            meal_field.setBackgroundColor(Color.parseColor("#A9A9A9"));
            meal_field.setTextColor(Color.BLACK);
            meal_field.setPadding(5,5,5,5);
            bazar_field = new TextView(context);
            bazar_field.setText(String.format("%.2f", ((MainActivity)getActivity()).list.get(i).getBazar()));
            bazar_field.setGravity(Gravity.CENTER);
            bazar_field.setBackgroundColor(Color.parseColor("#808080"));
            bazar_field.setTextColor(Color.BLACK);
            bazar_field.setPadding(5,5,5,5);
            will_get_field = new TextView(context);
            will_get_field.setText(String.format("%.2f", ((MainActivity)getActivity()).list.get(i).getWill_get()));
            will_get_field.setGravity(Gravity.CENTER);
            will_get_field.setBackgroundColor(Color.parseColor("#A9A9A9"));
            will_get_field.setTextColor(Color.BLACK);
            will_get_field.setPadding(5,5,5,5);
            will_pay_field = new TextView(context);
            will_pay_field.setText(String.format("%.2f", ((MainActivity)getActivity()).list.get(i).getWill_pay()));
            will_pay_field.setGravity(Gravity.CENTER);
            will_pay_field.setBackgroundColor(Color.parseColor("#808080"));
            will_pay_field.setTextColor(Color.BLACK);
            will_pay_field.setPadding(5,5,5,5);
            tr.addView(name_field);
            tr.addView(meal_field);
            tr.addView(bazar_field);
            tr.addView(will_get_field);
            tr.addView(will_pay_field);
            t1.addView(tr);
        }

        return view;
    }

}
