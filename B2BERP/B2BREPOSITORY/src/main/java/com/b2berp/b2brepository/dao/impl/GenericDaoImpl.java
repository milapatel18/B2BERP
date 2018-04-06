package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.GenericDao;
import com.b2berp.b2brepository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Basic DAO operations dependent with Hibernate's specific classes
 *
 * @param <E>
 * @see SessionFactory
 */
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    protected Class<? extends E> daoType;

    /**
     * By defining this class as abstract, we prevent Spring from creating
     * instance of this class If not defined abstract
     * getClass().getGenericSuperClass() would return Object. There would be
     * exception because Object class does not hava constructor with parameters.
     */
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void add(E entity) {
        K key = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            key = (K) session.save(entity);
            System.out.println("ENTITY UPDATED : " + key);
            System.out.println("ENTITY UPDATED : " + daoType.getName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveOrUpdate(E entity) {
        K key = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            System.out.println("ENTITY UPDATED : " + key);
            System.out.println("ENTITY UPDATED : " + daoType.getName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public E merge(E entity) {
        E obj = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = (E) session.merge(entity);
            System.out.println("ENTITY UPDATED : " + daoType.getName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    @Override
    public void update(E entity) {
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            System.out.println("ENTITY UPDATED : " + daoType.getName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(E entity) {
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            System.out.println("ENTITY DELETED : " + daoType.getName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public E find(K key) {
        E obj = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = (E) session.get(daoType, key);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    @Override
    public List<E> getAll() {
        List<E> list = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(daoType);
            list = cr.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<E> getAll(Map<String, Object> map, int startFrom, int maxResult) {
        List<E> list = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria c = currentSession().createCriteria(daoType);
            if (map != null) {
                c.add(Restrictions.allEq(map));
            }
            c.setFirstResult(startFrom);
            if (maxResult > 0) {
                c.setMaxResults(maxResult);
            }
            list = c.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Integer getAllSize(Map<String, Object> map) {
        Integer size = 0;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria c = currentSession().createCriteria(daoType);
            if (map != null) {
                c.add(Restrictions.allEq(map));
            }
            size = Integer.parseInt(c.setProjection(Projections.rowCount()).uniqueResult().toString());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return size;
    }

    public List<E> getAllBySql(String sql) {
        List<E> list = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery sqlQuery = currentSession().createSQLQuery(sql);
            sqlQuery.addEntity(daoType);
            list = (List<E>) sqlQuery.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List getResultSetBySql(String sql) {
        List list = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery sqlQuery = currentSession().createSQLQuery(sql);
            sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            list = sqlQuery.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
