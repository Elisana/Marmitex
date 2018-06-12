package com.efavarin.marmitex.repository;

import com.efavarin.marmitex.model.EntityId;
import com.mysema.query.FilteredClause;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.JPQLTemplates;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.jpa.impl.JPAProvider;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.PathBuilder;
import com.mysema.query.types.path.PathBuilderFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
/*paramtetro: classe e tipo da chave PK*/
public abstract class AbstractRepository<T extends EntityId, PK> {

    @Inject
    protected EntityManager em;

    private JPQLTemplates jpqlTemplate;

    protected Class<T> type;
    protected PathBuilder<T> entityPath;

    private PathBuilderFactory pathBuilderFactory = new PathBuilderFactory();

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void init() {
        this.jpqlTemplate = JPAProvider.getTemplates(em);
        this.type = getMappedSuperclass(getClass());
        this.entityPath = getPathBuilderFactory().create(this.type);
    }

    public static Class getMappedSuperclass(final Class<?> clazz) {
        return getMappedSuperclass(clazz, 0);
    }

    public static Class getMappedSuperclass(final Class<?> clazz, int arg) {
        if (clazz.getGenericSuperclass() instanceof ParameterizedType) {
            ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
            return (Class) genericSuperclass.getActualTypeArguments()[arg];
        }
        return null;
    }

    public List<T> findAll(final Predicate... where) {
        return applyPredicate(from(entityPath), where).list(entityPath);
    }
    
    public T findBy(PK pk) {
        return em.find(type, pk);
    }
    
    public JPQLQuery from(final EntityPath<?>... paths) {
        return new HibernateQuery(em.unwrap(Session.class), jpqlTemplate).from(paths);
    }

    public <Q extends FilteredClause> Q applyPredicate(Q query, Predicate... predicate) {
        if (predicate.length > 0) {
            query.where(predicate);
        }
        return query;
    }

    public PathBuilderFactory getPathBuilderFactory() {
        return pathBuilderFactory;
    }
}
