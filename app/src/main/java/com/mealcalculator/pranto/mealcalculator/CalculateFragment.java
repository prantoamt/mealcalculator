package com.mealcalculator.pranto.mealcalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CalculateFragment extends Fragment {

    TextInputLayout name_input, bazar_input, meal_input;
    EditText name, bazar, meal;
    Button submit, calculate;
    Double total_meal = 0.0;
    Double total_bazar = 0.0;

    public CalculateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        name_input = view.findViewById(R.id.name_text_input);
        bazar_input = view.findViewById(R.id.bazar_text_input);
        meal_input = view.findViewById(R.id.meal_text_input);
        name = view.findViewById(R.id.name);
        bazar = view.findViewById(R.id.bazar);
        meal = view.findViewById(R.id.meal);
        submit = view.findViewById(R.id.submit_btn);
        calculate = view.findViewById(R.id.calculate_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeInput();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutput();
            }
        });

        return view;

    }

    private void setOutput()
    {
        if(((MainActivity)getActivity()).list.size() == 0)
        {
            Toast.makeText(((MainActivity)getActivity()).getApplicationContext(), "No member found", Toast.LENGTH_LONG).show();
        }
        else
        {
            ((MainActivity)getActivity()).meal_rate = findMealRate(total_bazar, total_meal);
            for(int i = 0; i < ((MainActivity)getActivity()).list.size(); i++)
            {
                ((MainActivity)getActivity()).list.get(i).setMeal_rate(((MainActivity)getActivity()).meal_rate);
                ((MainActivity)getActivity()).list.get(i).calculation();
            }

            ((MainActivity)getActivity()).setScreen(2);
        }
    }

    private void takeInput()
    {
        if(checkName() && checkBazar() && checkMeal())
        {
            String person_name = name.getText().toString();
            Double person_bazar = Double.parseDouble(bazar.getText().toString());
            Double person_meal = Double.parseDouble(meal.getText().toString());

            PersonInfo info = new PersonInfo(person_name, person_bazar, person_meal);
            ((MainActivity)getActivity()).list.add(info);
            total_bazar = total_bazar + person_bazar;
            total_meal = total_meal + person_meal;
            name.setText("");
            bazar.setText("");
            meal.setText("");

        }
    }

    private boolean checkName()
    {
        boolean isValid = false;
        if(name.getText().toString().isEmpty())
        {
            name_input.setErrorEnabled(true);
            name_input.setError("Name Can not be empty");
            isValid = false;
        }
        else if(name.getText().toString().isEmpty() == false)
        {
            name_input.setErrorEnabled(false);
            isValid = true;
        }

        return isValid;
    }

    private boolean checkBazar()
    {
        boolean isValid = false;
        if(bazar.getText().toString().isEmpty())
        {
            bazar_input.setErrorEnabled(true);
            bazar_input.setError("Bazar Can not be empty");
            isValid = false;
        }
        else if(bazar.getText().toString().isEmpty() == false)
        {
            bazar_input.setErrorEnabled(false);
            isValid = true;
        }

        return isValid;
    }

    private boolean checkMeal()
    {
        boolean isValid = false;
        if(meal.getText().toString().isEmpty())
        {
            meal_input.setErrorEnabled(true);
            meal_input.setError("Meal Can not be empty");
            isValid = false;
        }
        else if(meal.getText().toString().isEmpty() == false)
        {
            meal_input.setErrorEnabled(false);
            isValid = true;
        }

        return isValid;
    }

    private double findMealRate(double total_bazar, double total_meal)
    {
        double mealRate = total_bazar / total_meal;

        return mealRate;
    }

}
