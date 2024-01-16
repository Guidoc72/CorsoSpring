//DI SEGUITO TROVIAMO QUELLA CHE E' L'IMPLEMENTAZIONE STANDARD DEI METODI DEL CRUD_REPOSITORY
/*
package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public <S extends User> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            entityManager.persist(entity);
        }
        return entities;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsById(Long id) {
        User user = entityManager.find(User.class, id);
        return user != null;
    }

    @Override
    public Iterable<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id IN :ids", User.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    @Override
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM User u", Long.class);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void delete(User entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        for (Long id : ids) {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        for (User entity : entities) {
            entityManager.remove(entity);
        }
    }

    @Override
    public void deleteAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        for (User user : users) {
            entityManager.remove(user);
        }
    }

	@Override
	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
*/