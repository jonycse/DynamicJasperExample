package com.jonycse.dynamic.jasper.example;

public class Contact {

    private String mobile = "12546";
    private String address ="145, dhaka";

    public Contact(){
    }

    public Contact(String mobile){
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
