package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.CityDAO;
import com.b2berp.b2bmodel.core.City;

public class CityDAOImpl extends GenericDaoImpl<City, Long> implements CityDAO {

    public static CityDAOImpl cityDAOImpl = new CityDAOImpl();

    private CityDAOImpl() {
    }

    public static CityDAOImpl getInstance() {
        return cityDAOImpl;
    }
}
