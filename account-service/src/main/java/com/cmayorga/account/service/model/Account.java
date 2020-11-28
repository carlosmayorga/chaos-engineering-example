package com.cmayorga.account.service.model;
import com.cmayorga.common.models.library.entity.*;

public class Account {

    private SavingAccount savingAccount;
    private Integer amount;

    public Account() {
    }

    public Account(SavingAccount savingAccount, Integer amount) {
        this.savingAccount = savingAccount;
        this.amount = amount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public Double getTotal() {
        return savingAccount.getBalance() * amount.doubleValue();
    }

}
