package com.example.sanjayprajapati.smsu;

/**
 * Created by sanjayprajapati on 4/11/18.
 */

public class Customer {
    String eid;
    String fname;
    String lname;
    String password;
    public Customer(String eid,String fname,String lname,String password){
        this.eid=eid;
        this.fname=fname;
        this.lname=lname;
        this.password=password;

    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
