package com.maktab.base.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue
    private ID id;

    public BaseEntity() {
    }

    public BaseEntity(ID id) {

        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
