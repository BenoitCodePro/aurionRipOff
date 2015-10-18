package com.crysteo.Persons;

import java.io.Serializable;

/**
 * Created by plesur on 10/17/15.
 * Abstract class that represents a person.
 * Attributes are first name and surname (as of now)
 */
abstract public class Person implements Serializable {

    String surName;
    String firstName;

    /**
     * Basic constructor that children can super()
     * @param surName_ surname of the person
     * @param firstName_ first name of the person
     */
    Person(String firstName_, String surName_) {
        surName = surName_;
        firstName = firstName_;
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
    abstract public void display();


}
