package com.b2berp.b2brepository.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<E, K> {

    public void add(E entity);

    public void saveOrUpdate(E entity);

    public void update(E entity);

    public void remove(E entity);

    public E merge(E entity);

    public E find(K key);

    public List<E> getAll();

    public List<E> getAll(Map<String, Object> map, int startFrom, int maxResult);

    public Integer getAllSize(Map<String, Object> map);

    public List<E> getAllBySql(String sql);

    public List getResultSetBySql(String sql);
}
