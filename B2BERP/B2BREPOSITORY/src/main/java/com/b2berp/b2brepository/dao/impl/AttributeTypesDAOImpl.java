package com.b2berp.b2brepository.dao.impl;

import com.b2berp.b2brepository.dao.AttributeTypesDAO;
import com.b2berp.b2bmodel.core.AttributeTypes;

public class AttributeTypesDAOImpl extends GenericDaoImpl<AttributeTypes, Long> implements AttributeTypesDAO {

    public static AttributeTypesDAOImpl attributeTypesDAOImpl = new AttributeTypesDAOImpl();

    private AttributeTypesDAOImpl() {
    }

    public static AttributeTypesDAOImpl getInstance() {
        return attributeTypesDAOImpl;
    }
}
