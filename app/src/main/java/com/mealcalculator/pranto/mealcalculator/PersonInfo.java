package com.mealcalculator.pranto.mealcalculator;

/**
 * Created by pranto on 1/2/18.
 */

public class PersonInfo {
    private String name;
    private double bazar;
    private double meal;
    private double meal_rate;
    private double will_pay, will_get;


    PersonInfo(String name, double bazar, double meal)
    {
        this.name = name;
        this.bazar = bazar;
        this.meal = meal;
    }


    public void calculation()
    {
        double amount = meal_rate * meal;
        if(amount > bazar)
        {
            double pay = amount - bazar;
            setWill_pay(pay);
        }
        else if(bazar > amount)
        {
            double get = bazar - amount;
            setWill_get(get);
        }
    }

    public double getMeal_rate() {
        return meal_rate;
    }

    public double getWill_get() {
        return will_get;
    }

    public double getWill_pay() {
        return will_pay;
    }

    public void setMeal_rate(double meal_rate) {
        this.meal_rate = meal_rate;
    }

    public void setWill_get(double will_get) {
        this.will_get = will_get;
    }

    public void setWill_pay(double will_pay) {
        this.will_pay = will_pay;
    }

    public String getName() {
        return name;
    }

    public double getBazar()
    {
        return this.bazar;
    }

    public double getMeal()
    {
        return this.meal;
    }

    public void setBazar(double bazar) {
        this.bazar = bazar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeal(double meal) {
        this.meal = meal;
    }
}
