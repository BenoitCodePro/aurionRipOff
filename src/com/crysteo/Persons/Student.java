package com.crysteo.Persons;

/**
 * Created by plesur on 10/17/15.
 * Inherits from Person
 * It has a promotion number.
 */
public class Student extends Person {

    int promotion;

    public Student(String firstName, String surName, int promotion_, String rfidID_) {
        super(firstName, surName, rfidID_);
        promotion = promotion_;
    }

    @Override
    public void display() {
        super.display();
        System.out.print("Promotion: " + promotion + "\n");
    }
}
