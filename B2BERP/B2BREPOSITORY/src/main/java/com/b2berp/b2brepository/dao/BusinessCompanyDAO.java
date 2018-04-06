package com.b2berp.b2brepository.dao;

import com.b2berp.b2bmodel.core.BusinessCompany;

public interface BusinessCompanyDAO extends GenericDao<BusinessCompany, Long> {

    public BusinessCompany getSubModules(BusinessCompany businessCompany);

}
