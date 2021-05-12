package com.example.smallapp;

public class Model {

    String year, princple, interest, total;

    public Model(String year, String princple, String interest, String total) {
        this.year = year;
        this.princple = princple;
        this.interest = interest;
        this.total = total;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrincple() {
        return princple;
    }

    public void setPrincple(String princple) {
        this.princple = princple;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


}
