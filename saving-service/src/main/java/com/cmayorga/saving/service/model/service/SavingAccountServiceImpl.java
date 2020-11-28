package com.cmayorga.saving.service.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmayorga.common.models.library.entity.SavingAccount;
import com.cmayorga.saving.service.model.dao.ISavingAccountDao;

@Service
public class SavingAccountServiceImpl implements ISavingAccountService {

	
	@Autowired
	ISavingAccountDao iSavingAccountDao;
	
	@Override
	public List<SavingAccount> findAll() {
		return (List<SavingAccount>) iSavingAccountDao.findAll();
	}

	@Override
	public SavingAccount findById(Long id) {
		return iSavingAccountDao.findById(id).orElse(null);
	}

	@Override
	public SavingAccount save(SavingAccount product) {
		return iSavingAccountDao.save(product);
	}

	@Override
	public void deleteById(Long id) {
		iSavingAccountDao.deleteById(id);
	}

}
