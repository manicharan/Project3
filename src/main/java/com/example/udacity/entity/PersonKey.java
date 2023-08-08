package com.example.udacity.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonKey implements Serializable {
    private int height;
    private String color;
    @Override
    public int hashCode() {
        return Objects.hash(height,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;
        PersonKey pk = (PersonKey) obj;
        return pk.height==height && color.equals(pk.color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

