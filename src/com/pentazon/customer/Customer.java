package com.pentazon.customer;

import java.util.ArrayList;
import java.util.List;


/**
 * @@author USER
 */

public abstract  class Customer {
    private Integer id;
    private String firstName;
    private  String lastName;

    private List<Address> addresses = new ArrayList<> ();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
