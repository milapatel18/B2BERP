package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.ClientsDAO;
import com.b2berp.b2bmodel.core.Clients;

public class ClientsDAOImpl extends GenericDaoImpl<Clients, Long> implements ClientsDAO {

    public static ClientsDAOImpl clientsDAOImpl = new ClientsDAOImpl();

    private ClientsDAOImpl() {
    }

    public static ClientsDAOImpl getInstance() {
        return clientsDAOImpl;
    }
}
