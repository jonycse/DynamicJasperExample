package com.jonycse.dynamic.jasper.example;

public class Contact {

    private String mobile;
    private String address;

    public Contact(){
        this.mobile = "12546";
        this.address = "145, dhaka";
    }

    public Contact(String mobile){
        this.mobile = mobile;
        this.address = "145, dhaka";
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
