package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.RoleDAO;
import com.b2berp.b2bmodel.core.Role;

public class RoleDAOImpl extends GenericDaoImpl<Role, Long> implements RoleDAO {

    public static RoleDAOImpl roleDAOImpl = new RoleDAOImpl();

    private RoleDAOImpl() {
    }

    public static RoleDAOImpl getInstance() {
        return roleDAOImpl;
    }
}
