package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.AttributesDataDAO;
import com.b2berp.b2bmodel.core.AttributesData;

public class AttributesDataDAOImpl extends GenericDaoImpl<AttributesData, Long> implements AttributesDataDAO {

    public static AttributesDataDAOImpl attributesDataDAOImpl = new AttributesDataDAOImpl();

    private AttributesDataDAOImpl() {
    }

    public static AttributesDataDAOImpl getInstance() {
        return attributesDataDAOImpl;
    }
}
