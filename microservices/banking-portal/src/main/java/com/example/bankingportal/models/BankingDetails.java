package com.example.bankingportal.models;

public class BankingDetails {
    private String accountNumber;
    private String accountBalance;
    private String bankName;

    public BankingDetails() {
    }

    public BankingDetails(String accountNumber, String accountBalance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
