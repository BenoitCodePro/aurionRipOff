package com.crysteo.Data.Persons;

/**
 * Created by plesur on 10/17/15.
 * Inherits from Person
 * It has a promotion number.
 */
public class Student extends Person {

    private int promotion;

    public Student(String firstName, String surName, int promotion_, String rfidID_) {
        super(firstName, surName, rfidID_);
        promotion = promotion_;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print("Promotion: " + promotion + "\n");
    }
}
