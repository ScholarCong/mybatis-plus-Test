package com.jt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jt.pojo.User;

public interface UserService {
	List<User> findAll();
}
