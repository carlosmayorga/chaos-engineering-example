package com.cmayorga.account.service.model.service;

import java.util.List;

import com.cmayorga.account.service.model.Account;
import com.cmayorga.common.models.library.entity.*;;

public interface IAccountService {
    
    public List<Account> findAll();
    public Account findById(Long id, Integer amount);
    
    public SavingAccount create(SavingAccount savingAccount);
    public SavingAccount update(SavingAccount savingAccount, Long id);
    public void delete(Long id);

}
