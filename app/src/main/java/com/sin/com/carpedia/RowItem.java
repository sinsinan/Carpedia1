package com.sin.com.carpedia;

/**
 * Created by sin on 12/9/16.
 */

public class RowItem {
    private int imageid;
    private String company;
    private String name;
    private String price;

    public RowItem(int imageid, String company, String name ,String price) {
        this.imageid = imageid;
        this.company = company;
        this.name = name;
        this.price = price;
    }
    public int getimageid() {
        return imageid;
    }
    public void setimageid(int imageid) {
        this.imageid = imageid;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getcompany() {
        return company;
    }
    public void setcompany(String company) {
        this.company = company;
    }
    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return company + "\n" + name;
    }
}
