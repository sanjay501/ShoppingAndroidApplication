package com.example.sanjayprajapati.smsu;

import java.util.Date;

/**
 * Created by sanjayprajapati on 4/11/18.
 */

public class Reciept {
    int recieptid;
    String emailid;
    Date date;
    Double discount;
    Double shipping;

    public Reciept(int recieptid,String emailid,Date date,Double discount,Double shipping){
        this.recieptid=recieptid;
        this.emailid=emailid;
        this.date=date;
        this.discount=discount;
        this.shipping=shipping;
    }

    public int getRecieptid() {
        return recieptid;
    }

    public void setRecieptid(int recieptid) {
        this.recieptid = recieptid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }
}
