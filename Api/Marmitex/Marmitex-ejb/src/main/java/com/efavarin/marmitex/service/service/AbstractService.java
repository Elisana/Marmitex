package com.efavarin.marmitex.service.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class AbstractService<T> {

    @Inject
    protected EntityManager em;

    public void persist(T t) {
        em.persist(t);
    }

    public T merge(T t) {
        return em.merge(t);
    }

    public void remove(T t) {
        em.remove(t);
    }
}
