/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.facades.impl;

import com.b2berp.b2bfacade.data.beans.BusinessCompanyData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import com.b2berp.b2bfacade.facades.BusinessCompanyFacades;
import com.b2berp.b2bmodel.core.BusinessCompany;
import com.b2berp.b2brepository.dao.BusinessCompanyDAO;
import com.b2berp.b2brepository.dao.impl.BusinessCompanyDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Milap Patel
 */
public class BusinessCompanyFacadesImpl implements BusinessCompanyFacades {

    public static BusinessCompanyFacadesImpl businessCompanyFacadesImpl = new BusinessCompanyFacadesImpl();

    private BusinessCompanyFacadesImpl() {
    }

    public static BusinessCompanyFacadesImpl getInstance() {
        return businessCompanyFacadesImpl;
    }

    BusinessCompanyDAO businessCompanyDAO = BusinessCompanyDAOImpl.getInstance();

    @Override
    public List<BusinessCompanyData> getAllBusinessCompanyData(int page, int rows, int parentId) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BusinessCompany> businessCompany=new ArrayList<>();
        if (parentId == 0) {
            businessCompany = businessCompanyDAO.getAllBySql("SELECT * FROM business_company WHERE parent IS NULL");
        } else if (parentId > 0) {
            map.put("businessCompany", businessCompanyDAO.find(Long.parseLong("" + parentId)));
            businessCompany = businessCompanyDAO.getAll(map, (page * rows) - rows, rows);
        }
        List<BusinessCompanyData> businessCompanyDatas = new ArrayList<BusinessCompanyData>();
        if (businessCompany != null && !businessCompany.isEmpty()) {
            for (BusinessCompany businessCompany1 : businessCompany) {
                BusinessCompanyData businessCompanyData = new BusinessCompanyData();
                businessCompanyData.setActive(businessCompany1.getActive());
                businessCompanyData.setId(businessCompany1.getId());
                businessCompanyData.setBusinessName(businessCompany1.getBusinessName());
                businessCompanyData.setBusinessId(businessCompany1.getBusinessId());
                businessCompanyData.setCategory(businessCompany1.getCategory());
                businessCompanyData.setState("closed");

                businessCompanyDatas.add(businessCompanyData);
            }
        }
        return businessCompanyDatas;
    }

    @Override
    public List<TreeComboBox> getAllBusinessCompanyData() {
        List<BusinessCompany> businessCompanys = businessCompanyDAO.getAll();
        List<TreeComboBox> treeComboBoxs = new ArrayList<>();
        if (!businessCompanys.isEmpty()) {
            System.out.println("Module is not empty : " + businessCompanys.size());
            for (BusinessCompany businessCompany : businessCompanys) {
                businessCompany = businessCompanyDAO.getSubModules(businessCompany);
                if (businessCompany.getBusinessCompany() == null) {
                    TreeComboBox treeComboBox = new TreeComboBox();
                    treeComboBox.setId(businessCompany.getId().intValue());
                    treeComboBox.setText(businessCompany.getBusinessName());
                    treeComboBox.setChildren(getAllChildBusinessCompanyData(businessCompanys, businessCompany));
                    treeComboBoxs.add(treeComboBox);
                    System.out.println("Added One");
                }
            }
        }
        return treeComboBoxs;
    }

    public List<TreeComboBox> getAllChildBusinessCompanyData(List<BusinessCompany> businessCompanys, BusinessCompany businessCompany) {
        List<TreeComboBox> treeComboBoxs = new ArrayList<>();
        if (!businessCompanys.isEmpty()) {
            for (BusinessCompany businessCompany1 : businessCompanys) {
                businessCompany1 = businessCompanyDAO.getSubModules(businessCompany1);
                if (businessCompany1.getBusinessCompany() != null && businessCompany1.getBusinessCompany().getId() == businessCompany.getId()) {
                    TreeComboBox treeComboBox = new TreeComboBox();
                    treeComboBox.setId(businessCompany1.getId().intValue());
                    treeComboBox.setText(businessCompany1.getBusinessName());
                    treeComboBox.setChildren(getAllChildBusinessCompanyData(businessCompanys, businessCompany1));
                    treeComboBoxs.add(treeComboBox);
                    System.out.println("Added 3 One");
                }
            }
        }
        return treeComboBoxs;
    }

}
