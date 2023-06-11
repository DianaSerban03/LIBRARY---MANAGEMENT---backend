package com.mylibrary.repository;

import com.mylibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, String>{
    User findByUsername(String username);

}
