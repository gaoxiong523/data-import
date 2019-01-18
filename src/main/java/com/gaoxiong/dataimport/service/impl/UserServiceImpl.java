package com.gaoxiong.dataimport.service.impl;

import com.gaoxiong.dataimport.model.User;
import com.gaoxiong.dataimport.repository.UserRepository;
import com.gaoxiong.dataimport.service.UserParse;
import com.gaoxiong.dataimport.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author gaoxiong
 * @ClassName UserServiceImpl
 * @Description TODO
 * @date 2019/1/18 10:24
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save ( User user ) {
        userRepository.save(user);
    }

    @Override
    public void save ( Collection<User> users ) {
        userRepository.saveAll(users);
    }
}
