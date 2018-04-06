package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.CountryDAO;
import com.b2berp.b2bmodel.core.Country;

public class CountryDAOImpl extends GenericDaoImpl<Country, Long> implements CountryDAO {

    public static CountryDAOImpl countryDAOImpl = new CountryDAOImpl();

    private CountryDAOImpl() {
    }

    public static CountryDAOImpl getInstance() {
        return countryDAOImpl;
    }
}
