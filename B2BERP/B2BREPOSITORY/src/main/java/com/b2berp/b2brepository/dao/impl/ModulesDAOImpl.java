package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.ModulesDAO;
import com.b2berp.b2bmodel.core.Modules;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModulesDAOImpl extends GenericDaoImpl<Modules, Long> implements ModulesDAO {

    public static ModulesDAOImpl modulesDAOImpl = new ModulesDAOImpl();

    private ModulesDAOImpl() {
    }

    public static ModulesDAOImpl getInstance() {
        return modulesDAOImpl;
    }

    @Override
    public boolean isModuleExistByName(Modules modules) {
        Map<String, Object> map = new HashMap<>();
        map.put("moduleName", modules.getModuleName());
        List<Modules> list = this.getAll(map, 0, 100);
        System.out.println("list " + list.size());
        return list.size() > 0;
    }

    @Override
    public Modules getSubModules(Modules modules) {
        Modules modules1 = null;
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (modules.getId() != null) {
                modules1 = (Modules) session.find(Modules.class, modules.getId());
                Hibernate.initialize(modules1.getModules());
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
        return modules1;

    }

    @Override
    public void adds(Modules modules) {
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(modules);
            Modules p = (Modules) session.find(Modules.class, modules.getModules().getId());
            p.setHasChildren(1);
            session.merge(p);
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
    public void updateHasChildren(Long oldParentId, Long newParentId) {
        Session session = currentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            if (oldParentId != newParentId) {
                //update to old parent if it has no children

                //update to new parent
                Modules newp = (Modules) session.find(Modules.class, newParentId);
                newp.setHasChildren(1);
                session.merge(newp);
                System.out.println("newpModules set to 1" + newp.getModuleName());

                //updatee modules
                Modules oldp = (Modules) session.find(Modules.class, oldParentId);
                try {
                    Hibernate.initialize(oldp.getModuleses());
                } catch (HibernateException e) {

                    System.out.println("oldp.getModuleses() Not found");
                }
                System.out.println("oldp.getModuleses() Size " + oldp.getModuleses().size());
                if (oldp.getModuleses().isEmpty() || oldp.getModuleses().size() == 0) {
                    System.out.println("No Childred Set to zero" + oldp.getModuleName());
                    oldp.setHasChildren(0);
                    session.merge(oldp);
                }
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
    }

}
