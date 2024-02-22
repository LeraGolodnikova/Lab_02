package com.example.lab_03;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Unit {

    public String name;
    public double coeff;

    public Unit(String name, double coeff)
    {
        this.name = name;
        this.coeff = coeff;
    }
    @NonNull
    @Override
    public  String toString()
    {
        return name;
    }
}
