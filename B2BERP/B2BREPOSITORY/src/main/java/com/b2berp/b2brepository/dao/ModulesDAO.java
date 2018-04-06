package com.b2berp.b2brepository.dao;

import com.b2berp.b2bmodel.core.Modules;

public interface ModulesDAO extends GenericDao<Modules, Long> {

    public boolean isModuleExistByName(Modules modules);

    public Modules getSubModules(Modules modules);

    public void adds(Modules modules);

    public void updateHasChildren(Long oldParentId, Long newParentId);
}
