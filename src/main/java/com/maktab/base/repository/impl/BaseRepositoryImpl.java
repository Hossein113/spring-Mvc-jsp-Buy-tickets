package com.maktab.base.repository.impl;

import com.maktab.base.domain.BaseEntity;
import com.maktab.base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {


    protected final Class<E> entityClass;

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManagerFactory managerFactory) {
        this.entityClass = getEntityClass();
        this.entityManager = managerFactory.createEntityManager();
    }


    // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceUtil.class);


    public abstract Class<E> getEntityClass();


    @Override
    public E save(E e) {
//        entityManager.getTransaction().begin();
        if (e.getId() == null) {
            entityManager.persist(e);
        } else {
            e = entityManager.merge(e);
        }
//        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public E findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
//        User -> getSimpleName -> User
        return entityManager.createQuery(
                "select e from " + entityClass.getSimpleName() + " e",
                entityClass
        ).getResultList();
    }

    @Override
    public void deleteById(ID id) {
//        1
        /*E e = findById(id);
        if (e != null) {
            entityManager.remove(e);
        }*/

//        2
        /*entityManager.createQuery(
                        "delete from " + entityClass.getSimpleName() + " e where e.id = " + id)
                .executeUpdate();*/

//        3
        entityManager.createQuery(
                        "delete from " + entityClass.getSimpleName() + " e where e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public long countAll() {
        return entityManager.createQuery(
                "select count(e) from " + entityClass.getSimpleName() + " e",
                Long.class
        ).getSingleResult();
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }

    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }
}
