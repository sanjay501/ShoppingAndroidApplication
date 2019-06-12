package com.example.sanjayprajapati.smsu;

/**
 * Created by sanjayprajapati on 4/11/18.
 */

public class Items {
    int recieptid;
    int upc;
    int quantity;

    public Items(int recieptid,int upc,
                 int quantity){
        this.recieptid=recieptid;
        this.upc=upc;
        this.quantity=quantity;
    }

    public int getRecieptid() {
        return recieptid;
    }

    public void setRecieptid(int recieptid) {
        this.recieptid = recieptid;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
