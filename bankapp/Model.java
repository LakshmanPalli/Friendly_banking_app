package com.example.bankapp;

public class Model {
    String phoneno, name, balance, name1, name2, date, transactionstatus;

    public Model(String phoneno, String name, String balance) {
        this.phoneno = phoneno;
        this.name = name;
        this.balance = balance;
    }

    public Model(String name1, String name2, String balance, String date, String transactionstatus) {
        this.name1 = name1;
        this.name2 = name2;
        this.balance = balance;
        this.date = date;
        this.transactionstatus = transactionstatus;
    }
// Model class provides setters and getters of transaction items....
    public String getPhoneno() {
        return phoneno;
    }

   // public void setPhoneno(String phoneno) { this.phoneno = phoneno; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

   // public void setBalance(String balance) { this.balance = balance; }

    public String getName1() {
        return name1;
    }

   // public void setName1(String name1) { this.name1 = name1; }

    public String getName2() {
        return name2;
    }

  // public void setName2(String name2) { this.name2 = name2; }

    public String getDate() {
        return date;
    }

   // public void setDate(String date) { this.date = date; }

    public String getTransactionstatus() {
        return transactionstatus;
    }

    // public void setTransactionstatus(String transactionstatus) { this.transactionstatus = transactionstatus; }

}
