package com.crysteo.Persons;

/**
 * Created by plesur on 10/19/15.
 * Inherits from Person
 * Contains a office room field (as a string)
 */
public class Teacher extends Person {

    String officeRoom;

    public Teacher(String firstName, String surName, String officeRoom_, String rfidID_) {
        super(firstName, surName, rfidID_);
        officeRoom = officeRoom_;
    }

    @Override
    public void display() {
        super.display();
        System.out.print("Office Room: " + officeRoom + "\n");
    }
}
