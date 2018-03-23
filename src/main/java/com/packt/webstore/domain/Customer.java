package com.packt.webstore.domain;

public class Customer {
    private long customerId;
    private String name;
    private String address;
    private int noOfOrdersMade;

    public Customer(long customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return (int) (customerId ^ (customerId >>> 32));
    }

    @Override
    public String toString() {
        return "Klient [customerId= " + customerId + ", name= " + name + ", noOfOrdersMade= " + noOfOrdersMade + "]";
    }
}
