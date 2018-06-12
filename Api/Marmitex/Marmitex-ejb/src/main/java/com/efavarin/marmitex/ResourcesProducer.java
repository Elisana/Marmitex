package com.efavarin.marmitex;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
@SuppressWarnings("serial")
public class ResourcesProducer implements Serializable {

    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager em;
}
