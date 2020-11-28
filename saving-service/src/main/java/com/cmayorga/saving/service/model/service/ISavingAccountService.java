package com.cmayorga.saving.service.model.service;

import java.util.List;

import com.cmayorga.common.models.library.entity.SavingAccount;

public interface ISavingAccountService {
	
	public List<SavingAccount> findAll();
    public SavingAccount findById(Long id);
    public SavingAccount save(SavingAccount product);
    public void deleteById(Long id);

}
