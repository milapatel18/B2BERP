/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.facades.impl;

import com.b2berp.b2bfacade.data.beans.ModulesData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import com.b2berp.b2bfacade.facades.ModulesFacades;
import com.b2berp.b2bmodel.core.Modules;
import com.b2berp.b2brepository.dao.ModulesDAO;
import com.b2berp.b2brepository.dao.impl.ModulesDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Milap Patel
 */
public class ModulesFacadesImpl implements ModulesFacades {

    public static ModulesFacadesImpl modulesFacadesImpl = new ModulesFacadesImpl();

    private ModulesFacadesImpl() {
    }

    public static ModulesFacadesImpl getInstance() {
        return modulesFacadesImpl;
    }

    ModulesDAO modulesDAO = ModulesDAOImpl.getInstance();

    @Override
    public List<ModulesData> getAllModulesData(int page, int rows, int parentId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (parentId == 0) {
            map.put("moduleName", "root");
        } else if (parentId > 0) {
            map.put("modules", modulesDAO.find(Long.parseLong("" + parentId)));
        }
        List<Modules> moduleses = modulesDAO.getAll(map, (page * rows) - rows, rows);
        List<ModulesData> modulesDatas = new ArrayList<ModulesData>();
        if (!moduleses.isEmpty()) {
            for (Modules modules : moduleses) {
                ModulesData modulesData = new ModulesData();
                modulesData.setActive(modules.getActive());
                modulesData.setId(modules.getId());
                modulesData.setModuleName(modules.getModuleName());
                modulesData.setModuleTitle(modules.getModuleTitle());
                modulesData.setModuleType(modules.getModuleType());
                modulesData.setModuleUrl(modules.getModuleUrl());
                modulesData.setParentId(Long.parseLong("" + parentId));
                modulesData.setState("open");
                modulesData.setModuleCss(modules.getModuleCss());
                modulesData.setModuleIconClass(modules.getModuleIconClass());
                modulesData.setHasChildren(modules.getHasChildren());
                if (modules.getHasChildren() == 1) {
                    modulesData.setState("closed");
                }
                modulesDatas.add(modulesData);
            }
        }
        return modulesDatas;

    }

    @Override
    public List<TreeComboBox> getAllModulesData() {
        List<Modules> moduleses = modulesDAO.getAll();
        List<TreeComboBox> treeComboBoxs = new ArrayList<>();
        if (!moduleses.isEmpty()) {
            System.out.println("Module is not empty : " + moduleses.size());
            for (Modules modules : moduleses) {
                modules = modulesDAO.getSubModules(modules);
                if (modules.getModules() == null) {
                    TreeComboBox treeComboBox = new TreeComboBox();
                    treeComboBox.setId(modules.getId().intValue());
                    treeComboBox.setText(modules.getModuleName());
                    treeComboBox.setChildren(getAllChildrenModulesData(moduleses, modules));
                    treeComboBoxs.add(treeComboBox);
                    System.out.println("Added One");
                }
            }
        }
        return treeComboBoxs;
    }

    @Override
    public List<TreeComboBox> getAllChildrenModulesData(List<Modules> moduleses, Modules module) {
        List<TreeComboBox> treeComboBoxs = new ArrayList<>();
        if (!moduleses.isEmpty()) {
            for (Modules modules : moduleses) {
                modules = modulesDAO.getSubModules(modules);
                if (modules.getModules() != null && modules.getModules().getId() == module.getId()) {
                    TreeComboBox treeComboBox = new TreeComboBox();
                    treeComboBox.setId(modules.getId().intValue());
                    treeComboBox.setText(modules.getModuleName());
                    treeComboBox.setChildren(getAllChildrenModulesData(moduleses, modules));
                    treeComboBoxs.add(treeComboBox);
                    System.out.println("Added 3 One");
                }
            }
        }
        return treeComboBoxs;
    }
}
