package com.crysteo.Persons;

/**
 * Created by plesur on 10/17/15.
 */
public class Student extends Person {

    int promotion;

    public Student(String firstName,String surName,int promotion_) {
        super(firstName,surName);
        promotion = promotion_;
    }

    @Override
    public void display() {
        System.out.print("\nFirst name: " + firstName +
                        "\nSurname: " + surName +
                        "\nPromotion: " + promotion + "\n");
    }
}
