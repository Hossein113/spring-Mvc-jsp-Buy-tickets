package com.maktab.base.repository;

import com.maktab.base.domain.BaseEntity;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {
    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);

    long countAll();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    EntityTransaction getTransaction();
}
