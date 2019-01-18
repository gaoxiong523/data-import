package com.gaoxiong.dataimport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaoxiong.dataimport.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}