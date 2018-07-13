/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.facades;


import com.b2berp.b2bfacade.data.beans.ModulesData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import com.b2berp.b2bmodel.core.Modules;
import java.util.List;


/**
 *
 * @author Milap Patel
 */
public interface ModulesFacades {


    public List<ModulesData> getAllModulesData(int page, int rows, int parentId);

    public List<TreeComboBox> getAllModulesData();

    public List<TreeComboBox> getAllChildrenModulesData(List<Modules> moduleses, Modules module);
}
