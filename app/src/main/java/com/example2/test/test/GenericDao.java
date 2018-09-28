package com.example2.test.test;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by zwj on 6/14/18.
 */

public interface GenericDao<T, ID extends Serializable> {

    public abstract void saveOrUpdate(T t) ;

    public abstract T get(ID id) ;

    public abstract List<T> query(String queryString) ;

    public abstract Serializable save(T t) ;

    public abstract void saveOrUpdateAll(Collection<T> entities) ;

    public abstract List<T> loadAll() ;

    public abstract void merge(T t) ;



}