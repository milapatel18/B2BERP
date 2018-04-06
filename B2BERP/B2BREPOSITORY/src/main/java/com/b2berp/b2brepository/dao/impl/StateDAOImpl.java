package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.StateDAO;
import com.b2berp.b2bmodel.core.State;

public class StateDAOImpl extends GenericDaoImpl<State, Long> implements StateDAO {

    public static StateDAOImpl stateDAOImpl = new StateDAOImpl();

    private StateDAOImpl() {
    }

    public static StateDAOImpl getInstance() {
        return stateDAOImpl;
    }
}
