package com.jonycse.dynamic.jasper.example;

public class Account {
    float balance = 10.75f;

    public Account(float balance) {
        this.balance = balance;
    }
    public Account() {
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
