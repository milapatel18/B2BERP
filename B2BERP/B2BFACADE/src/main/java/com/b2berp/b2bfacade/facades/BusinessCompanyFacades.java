/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.facades;

import com.b2berp.b2bfacade.data.beans.BusinessCompanyData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import java.util.List;

/**
 *
 * @author Milap Patel
 */
public interface BusinessCompanyFacades {

    /**
     * for list
     *
     * @param page
     * @param rows
     * @param parentId
     * @return
     */
    public List<BusinessCompanyData> getAllBusinessCompanyData(int page, int rows, int parentId);

    /**
     * forms usage
     *
     * @return
     */
    public List<TreeComboBox> getAllBusinessCompanyData();
}
