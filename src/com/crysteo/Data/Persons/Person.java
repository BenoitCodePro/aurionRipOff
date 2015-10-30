package com.crysteo.Data.Persons;

import com.crysteo.Data.Displayable;

import java.io.Serializable;

/**
 * Created by plesur on 10/17/15.
 * Abstract class that represents a person.
 * Attributes are first name and surname (as of now)
 */
abstract public class Person implements Serializable, Displayable {

    private String surname;
    private String firstName;
    private String rfidID;

    /**
     * Basic constructor that children can super()
     * @param surname_ surname of the person
     * @param firstName_ first name of the person
     */
    Person(String firstName_, String surname_, String rfidID_) {
        surname = surname_;
        firstName = firstName_;
        rfidID = rfidID_;
    }


    /**
     * Returns true if the person is supposed to go at the given class
     * @param class_ the class the person might attend to
     * @return if the person is expected to be at the class
     */
    /*boolean attends(Class class_) {
        //return class_.expects(this);
        return true;
    }*/

    /**
     * Simply display the basic information about a person.
     * It is abstract because those information depend on the type of person.
     */
    public void displayInfo() {
        System.out.print("\nFirst name: " + firstName +
                "\nSurname: " + surname +
                "\nRFID ID: " + rfidID + "\n");
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }
}
