package com.cmayorga.account.service.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cmayorga.account.service.model.Account;
import com.cmayorga.account.service.model.rest_client.ISavingAccountRestClient;
import com.cmayorga.common.models.library.entity.*;;

@Service("serviceFeign")
@Primary
public class AccountServiceFeign implements IAccountService {

    @Autowired
    private ISavingAccountRestClient iSavingAccountRestClient;
    
    @Override
    public List<Account> findAll() {
        return iSavingAccountRestClient.getSavingAccountList()
        		.stream()
                .map(saving -> new Account(saving, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Account findById(Long id, Integer amount) {
        return new Account(iSavingAccountRestClient.getSavingAccountDetail(id), amount);
    }

    @Override
    public SavingAccount create(SavingAccount savingAccount) {
        return iSavingAccountRestClient.createSavingAccount(savingAccount);
    }

    @Override
    public SavingAccount update(SavingAccount savingAccount, Long id) {
        return iSavingAccountRestClient.updateSavingAccount(savingAccount, id);
    }

    @Override
    public void delete(Long id) {
    	iSavingAccountRestClient.deleteSavingAccount(id);
        
    }
}
