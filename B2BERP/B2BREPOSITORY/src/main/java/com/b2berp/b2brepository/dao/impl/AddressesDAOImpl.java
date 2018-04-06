package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.AddressesDAO;
import com.b2berp.b2bmodel.core.Addresses;

public class AddressesDAOImpl extends GenericDaoImpl<Addresses, Long> implements AddressesDAO {

    public static AddressesDAOImpl addressesDAOImpl = new AddressesDAOImpl();

    private AddressesDAOImpl() {
    }

    public static AddressesDAOImpl getInstance() {
        return addressesDAOImpl;
    }
}
