package com.cmayorga.spring.test.oauth.service;

import com.cmayorga.common.models.library.entity.User;

public interface IUserLoginService {
    
    public User findByUsername(String name);

}
