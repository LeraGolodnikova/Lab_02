package com.example.lab_03;

public class Object {
    public String toString(){
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
