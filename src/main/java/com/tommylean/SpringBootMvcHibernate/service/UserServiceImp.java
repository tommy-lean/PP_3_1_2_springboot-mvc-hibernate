package com.tommylean.SpringBootMvcHibernate.service;

import com.tommylean.SpringBootMvcHibernate.dao.UserDao;
import com.tommylean.SpringBootMvcHibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService{


    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    public User findById(Long id){
        return userDao.findById(id);
    }


    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
