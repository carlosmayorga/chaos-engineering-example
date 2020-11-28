package com.cmayorga.saving.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.cmayorga.common.models.library.entity.SavingAccount;
import com.cmayorga.saving.service.model.service.ISavingAccountService;


@RestController
public class SavingAccountController {
	
	
	@Autowired
    private ISavingAccountService iSavingAccountService;
    
    @GetMapping("/list")
    public List<SavingAccount> getSavingAccountList() {
         return iSavingAccountService.findAll();
    }
    
    @GetMapping("/{id}")
    public SavingAccount getSavingAccountDetail(@PathVariable long id) {
    	
        SavingAccount savingAccount = iSavingAccountService.findById(id);
        
        return savingAccount;
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingAccount createSavingAccount(@RequestBody SavingAccount savingAccount) {        
        return iSavingAccountService.save(savingAccount);
    }
    
    @PutMapping("/update/{id}")
    public SavingAccount updateSavingAccount(@RequestBody SavingAccount savingAccount, @PathVariable Long id) {        
        
    	SavingAccount aToUpdate = iSavingAccountService.findById(id);
        
    	aToUpdate.setName(savingAccount.getName());
    	aToUpdate.setBalance(savingAccount.getBalance());
        
        return iSavingAccountService.save(aToUpdate);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavingAccount(@PathVariable Long id) {
        iSavingAccountService.deleteById(id);
    }

}
