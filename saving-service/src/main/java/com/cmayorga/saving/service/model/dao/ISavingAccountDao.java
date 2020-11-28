package com.cmayorga.saving.service.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cmayorga.common.models.library.entity.SavingAccount;

public interface ISavingAccountDao extends CrudRepository<SavingAccount, Long> {


}
