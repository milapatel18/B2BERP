package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.BusinessCompanyDAO;
import com.b2berp.b2bmodel.core.BusinessCompany;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessCompanyDAOImpl extends GenericDaoImpl<BusinessCompany, Long> implements BusinessCompanyDAO {

    public static BusinessCompanyDAOImpl businessCompanyDAOImpl = new BusinessCompanyDAOImpl();

    private BusinessCompanyDAOImpl() {
    }

    public static BusinessCompanyDAOImpl getInstance() {
        return businessCompanyDAOImpl;
    }

    @Override
    public BusinessCompany getSubModules(BusinessCompany businessCompany) {
        BusinessCompany businessCompany1 = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (businessCompany.getId() != null) {
                businessCompany1 = (BusinessCompany) session.find(BusinessCompany.class, businessCompany.getId());
                Hibernate.initialize(businessCompany1.getBusinessCompanies());
                Hibernate.initialize(businessCompany1.getBusinessCompany());
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
        return businessCompany1;
    }
}
