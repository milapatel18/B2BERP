/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bwebapp.platform;

import com.b2berp.b2bfacade.data.beans.BusinessCompanyData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import com.b2berp.b2bfacade.facades.BusinessCompanyFacades;
import com.b2berp.b2bfacade.facades.impl.BusinessCompanyFacadesImpl;
import com.b2berp.b2bmodel.core.BusinessCompany;
import com.b2berp.b2bmodel.core.User;
import com.b2berp.b2brepository.dao.BusinessCompanyDAO;
import com.b2berp.b2brepository.dao.UserDAO;
import com.b2berp.b2brepository.dao.impl.BusinessCompanyDAOImpl;
import com.b2berp.b2brepository.dao.impl.UserDAOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milap Patel
 */
@WebServlet(name = "BusinessCompanyController", value = "/domain/businesscompany/*")

public class BusinessCompanyController extends HttpServlet {

    UserDAO userDAO = UserDAOImpl.getInstance();
    BusinessCompanyDAO businessCompanyDAO = BusinessCompanyDAOImpl.getInstance();
    BusinessCompanyFacades businessCompanyFacades = BusinessCompanyFacadesImpl.getInstance();

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String MODULE_NAME = "business";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURL().toString().contains("domain/businesscompany/businesscompanytreecombo")) {
            resp.setContentType("application/json");
            List<TreeComboBox> treeComboBox = businessCompanyFacades.getAllBusinessCompanyData();
            if (treeComboBox.isEmpty()) {
                System.out.println("\n\n\nHttpStatus.NO_CONTENT\n\n\n");
            } else {
                resp.getWriter().println(objectMapper.writeValueAsString(treeComboBox));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (req.getRequestURL().toString().contains("domain/businesscompany/list")) {
            Map<String, Object> map = new HashMap<>();

            int page = Integer.parseInt(req.getParameter("page"));
            int rows = Integer.parseInt(req.getParameter("rows"));
            int id = Integer.parseInt(req.getParameter("id"));

            List<BusinessCompanyData> businessCompanyDatas = businessCompanyFacades.getAllBusinessCompanyData(page, rows, id);
            if (businessCompanyDatas.isEmpty()) {
            }
            map.clear();
            map.put("total", businessCompanyDatas.size());
            map.put("rows", businessCompanyDatas);
            String response = "";
            resp.setContentType("application/json");
            if (id > 0) {
                try {
                    response = objectMapper.writeValueAsString(businessCompanyDatas);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModulesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    response = objectMapper.writeValueAsString(map);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModulesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            resp.getWriter().println(response);
        }
        if (req.getRequestURL().toString().contains("domain/businesscompany/create")) {
            if (!session.isNew() && session.getAttribute("user") != null) {
                BusinessCompany businessCompany = new BusinessCompany();
                businessCompany.setActive(Integer.parseInt(req.getParameter("active")));
                businessCompany.setBusinessName(req.getParameter("businessName"));
                businessCompany.setBusinessId(req.getParameter("businessId"));
                businessCompany.setCategory(req.getParameter("category"));
                businessCompany.setBusinessCompany(businessCompanyDAO.find(Long.parseLong(req.getParameter("parent"))));
                businessCompany.setCreatedAt(new Date());
                businessCompany.setUpdatedAt(new Date());
                businessCompany.setUser((User) session.getAttribute("user"));
                businessCompanyDAO.add(businessCompany);
            }

        }
        if (req.getRequestURL().toString().contains("domain/businesscompany/update")) {
            BusinessCompany businessCompany = businessCompanyDAO.find(Long.parseLong(req.getParameter("id")));
            if (businessCompany != null && businessCompany.getId() > 0) {
                businessCompany.setActive(Integer.parseInt(req.getParameter("active")));
                businessCompany.setBusinessName(req.getParameter("businessName"));
                businessCompany.setBusinessId(req.getParameter("businessId"));
                businessCompany.setCategory(req.getParameter("category"));
                businessCompany.setUpdatedAt(new Date());
                if (!req.getParameter("parent").toString().equals("") && !req.getParameter("parentOld").toString().equals("") && Long.parseLong(req.getParameter("parent")) != Long.parseLong(req.getParameter("parentOld"))) {
                    businessCompany.setBusinessCompany(businessCompanyDAO.find(Long.parseLong(req.getParameter("parent"))));
                    System.out.println("_________________________________________________PARENT IS UPDATED");
                }
                businessCompanyDAO.update(businessCompany);
            }

        }
        if (req.getRequestURL().toString().contains("domain/businesscompany/edit")) {
            Long BusinessCompanyId = Long.parseLong(req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/") + 1));
            RequestDispatcher rd = req.getRequestDispatcher("/view/layouts/modules/" + MODULE_NAME + "/edit.jsp");
            BusinessCompany businessCompany = businessCompanyDAO.find(BusinessCompanyId);
            BusinessCompany parentBusinessCompany = businessCompanyDAO.getSubModules(businessCompany).getBusinessCompany();
            req.setAttribute("businessCompany", businessCompany);
            req.setAttribute("parentBusinessCompany", parentBusinessCompany);
            rd.forward(req, resp);
        }
        if (req.getRequestURL().toString().contains("domain/businesscompany/delete")) {
            // there must be an option for remove all childs
            // 
            Long BusinessCompanyId = Long.parseLong(req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/") + 1));
            if (BusinessCompanyId > 1) {
                BusinessCompany businessCompany = businessCompanyDAO.find(BusinessCompanyId);
                if (businessCompany != null && businessCompany.getId() > 0) {
                    //if parent is there, then and then only check for both to reset hasChildren
                    businessCompanyDAO.remove(businessCompany);
                }
            }

        }
    }
}
