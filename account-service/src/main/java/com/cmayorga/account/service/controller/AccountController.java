package com.cmayorga.account.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cmayorga.account.service.model.Account;
import com.cmayorga.account.service.model.service.IAccountService;
import com.cmayorga.common.models.library.entity.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AccountController {
    
    @Autowired
    @Qualifier("serviceFeign")
    private IAccountService iAccountService;
    
    
    @GetMapping("/list")
    public List<Account> getAccounts() {
        return iAccountService.findAll();
    }
    
    @HystrixCommand(fallbackMethod = "AlternativeMethod")
    @GetMapping("/saving/{id}/amount/{amount}")
    public Account getSavingAccountDetail(@PathVariable Long id, @PathVariable Integer amount) {
        return iAccountService.findById(id, amount);
    }
    public Account AlternativeMethod(Long id, Integer amount){
        System.out.println("---### ALTERNATIVE METHOD");
        System.out.println("---### ...YENDO A CONTINGENCIA A BUSCAR LA INFORMACION");
    	Account account = new Account();
        SavingAccount savingAccount = new SavingAccount();
        
        account.setAmount(amount);
        savingAccount.setId(id);
        savingAccount.setName("Carlos Mayorga -desde contingencia");
        savingAccount.setBalance(800.00);
        account.setSavingAccount(savingAccount);
        
        return account;
    }
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingAccount createSavingAccount(@RequestBody SavingAccount savingAccount) {
        return iAccountService.create(savingAccount);
    }
    
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingAccount updateProduct(@RequestBody SavingAccount savingAccount, @PathVariable Long id) {
        
        return iAccountService.update(savingAccount, id);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
    	iAccountService.delete(id);
    }

}
