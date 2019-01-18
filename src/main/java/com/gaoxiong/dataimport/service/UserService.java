package com.gaoxiong.dataimport.service;

import com.gaoxiong.dataimport.model.User;

import java.util.Collection;

/**
 * @author gaoxiong
 * @ClassName UserService
 * @Description TODO
 * @date 2019/1/18 10:23
 */
public interface UserService {

    void  save ( User user );

    void save ( Collection<User> users );
}
