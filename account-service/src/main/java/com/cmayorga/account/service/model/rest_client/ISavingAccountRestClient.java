package com.cmayorga.account.service.model.rest_client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cmayorga.common.models.library.entity.*;

@FeignClient(value = "saving-service")
public interface ISavingAccountRestClient {
    
    @GetMapping("/list")
    public List<SavingAccount> getSavingAccountList();
    
    @GetMapping("/{id}")
    public SavingAccount getSavingAccountDetail(@PathVariable long id);
    
    @PostMapping("/create")
    public SavingAccount createSavingAccount(@RequestBody SavingAccount savingAccount);
    
    @PutMapping("/update/{id}")
    public SavingAccount updateSavingAccount(@RequestBody SavingAccount savingAccount, @PathVariable Long id);
    
    @DeleteMapping("/delete/{id}")
    public SavingAccount deleteSavingAccount(@PathVariable Long id);
}
