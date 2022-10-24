package com.maktab.base.repository.impl;/*
package maktab74.base.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import maktab74.base.domain.BaseEntity;
import maktab74.base.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

@Repository
@AllArgsConstructor
public abstract class BaseRepositoryImple<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {
    @Autowired
    protected EntityManagerFactory getEntityManagerFactory;


    protected Class<E> entityClass;


    @Override
    public E save(E e) {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (e.getId() == null) {
            entityManager.persist(e);
        } else {
            e = entityManager.merge(e);
        }
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public E findById(ID id) {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();

        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();

//        User -> getSimpleName -> User
        return entityManager.createQuery(
                "select e from " + entityClass.getSimpleName() + " e",
                entityClass
        ).getResultList();
    }

    @Override
    public void deleteById(ID id) {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();

//        1
        */
/*E e = findById(id);
        if (e != null) {
            entityManager.remove(e);
        }*//*


//        2
        */
/*entityManager.createQuery(
                        "delete from " + entityClass.getSimpleName() + " e where e.id = " + id)
                .executeUpdate();*//*


//        3
        entityManager.createQuery(
                        "delete from " + entityClass.getSimpleName() + " e where e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public long countAll() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();

        return entityManager.createQuery(
                "select count(e) from " + entityClass.getSimpleName() + " e",
                Long.class
        ).getSingleResult();
    }

    public void beginTransaction() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    void commitTransaction() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();
        entityManager.getTransaction().commit();
    }

    void rollbackTransaction() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();
        entityManager.getTransaction().rollback();
    }

    EntityTransaction getTransaction() {
        EntityManager entityManager = getEntityManagerFactory.createEntityManager();
        return entityManager.getTransaction();
    }
}
*/
