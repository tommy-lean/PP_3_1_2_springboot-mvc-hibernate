package com.tommylean.SpringBootMvcHibernate.dao;

import com.tommylean.SpringBootMvcHibernate.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(findById(user.getId()));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
