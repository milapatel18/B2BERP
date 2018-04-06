package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.UserDAO;
import com.b2berp.b2bmodel.core.User;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl extends GenericDaoImpl<User, Long> implements UserDAO {

    public static UserDAOImpl userDAOImpl = new UserDAOImpl();

    private UserDAOImpl() {
    }

    public static UserDAOImpl getInstance() {
        return userDAOImpl;
    }

    @Override
    public User findUserByUserName(String username, boolean getRoles) {
        User user = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Criteria c = currentSession().createCriteria(daoType);
            //c.add(Restrictions.eq("LOGINID", username));
            //List<User> users = c.list();
            //user = users.get(0);

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root).where(builder.equal(root.get("loginid"), username));
            Query<User> q = session.createQuery(query);
            List<User> users = q.list();
            user = users.get(0);

            if (getRoles) {
                Hibernate.initialize(user.getRoles());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

}
