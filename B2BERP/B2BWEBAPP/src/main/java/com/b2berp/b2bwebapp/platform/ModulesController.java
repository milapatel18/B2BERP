/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bwebapp.platform;

import com.b2berp.b2bfacade.data.beans.ModulesData;
import com.b2berp.b2bfacade.easyui.beans.TreeComboBox;
import com.b2berp.b2bfacade.facades.ModulesFacades;
import com.b2berp.b2bfacade.facades.impl.ModulesFacadesImpl;
import com.b2berp.b2bmodel.core.Modules;
import com.b2berp.b2bmodel.core.User;
import com.b2berp.b2brepository.dao.ModulesDAO;
import com.b2berp.b2brepository.dao.UserDAO;
import com.b2berp.b2brepository.dao.impl.ModulesDAOImpl;
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
@WebServlet(name = "ModulesController", value = "/domain/modules/*")
public class ModulesController extends HttpServlet {

    UserDAO userDAO = UserDAOImpl.getInstance();
    ModulesDAO modulesDAO = ModulesDAOImpl.getInstance();
    ModulesFacades modulesFacades = ModulesFacadesImpl.getInstance();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURL().toString().contains("domain/modules/modulestreecombo")) {
            resp.setContentType("application/json");
            List<TreeComboBox> treeComboBox = modulesFacades.getAllModulesData();
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
        if (req.getRequestURL().toString().contains("domain/modules/list")) {
            Map<String, Object> map = new HashMap<>();

            int page = Integer.parseInt(req.getParameter("page"));
            int rows = Integer.parseInt(req.getParameter("rows"));
            int id = Integer.parseInt(req.getParameter("id"));

            List<ModulesData> modulesDatas = modulesFacades.getAllModulesData(page, rows, id);
            if (modulesDatas.isEmpty()) {
            }
            map.clear();
            map.put("total", modulesDatas.size());
            map.put("rows", modulesDatas);
            String response = "";
            resp.setContentType("application/json");
            if (id > 0) {
                try {
                    response = objectMapper.writeValueAsString(modulesDatas);
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
        if (req.getRequestURL().toString().contains("domain/modules/create")) {
            if (!session.isNew() && session.getAttribute("user") != null) {
                Modules newModule = new Modules();
                newModule.setActive(Integer.parseInt(req.getParameter("active")));
                newModule.setHasChildren(Integer.parseInt(req.getParameter("hasChildren")));
                newModule.setModuleCss((req.getParameter("moduleCss")));
                newModule.setModuleDesc((req.getParameter("moduleDesc")));
                newModule.setModuleIconClass((req.getParameter("moduleIconClass")));
                newModule.setModuleImage((req.getParameter("moduleImage")));
                newModule.setModuleName((req.getParameter("moduleName")));
                newModule.setModuleTitle((req.getParameter("moduleTitle")));
                newModule.setModuleType((req.getParameter("moduleType")));
                newModule.setModuleUrl((req.getParameter("moduleUrl")));
                newModule.setModules(modulesDAO.find(Long.parseLong(req.getParameter("parent"))));
                newModule.setPriorityIndex(Integer.parseInt(req.getParameter("priorityIndex")));
                newModule.setCreatedAt(new Date());
                newModule.setUpdatedAt(new Date());
                newModule.setUser((User) session.getAttribute("user"));
                modulesDAO.adds(newModule);
            }

        }
        if (req.getRequestURL().toString().contains("domain/modules/update")) {
            Modules module = modulesDAO.find(Long.parseLong(req.getParameter("id")));
            if (module != null && module.getId() > 0) {
                module.setActive(Integer.parseInt(req.getParameter("active")));
                module.setHasChildren(Integer.parseInt(req.getParameter("hasChildren")));
                module.setModuleCss((req.getParameter("moduleCss")));
                module.setModuleIconClass((req.getParameter("moduleIconClass")));
                module.setModuleDesc((req.getParameter("moduleDesc")));
                module.setModuleImage((req.getParameter("moduleImage")));
                module.setModuleName((req.getParameter("moduleName")));
                module.setModuleTitle((req.getParameter("moduleTitle")));
                module.setModuleType((req.getParameter("moduleType")));
                module.setModuleUrl((req.getParameter("moduleUrl")));
                //if parent is update then and then only this one is required.
                if (Long.parseLong(req.getParameter("parent")) != Long.parseLong(req.getParameter("parentOld"))) {
                    module.setModules(modulesDAO.find(Long.parseLong(req.getParameter("parent"))));
                    System.out.println("_________________________________________________PARENT IS UPDATED");

                    //if parent is updated, then and then only check for both to reset hasChildren
                }
                //====================================================end
                module.setPriorityIndex(Integer.parseInt(req.getParameter("priorityIndex")));
                module.setUpdatedAt(new Date());
                modulesDAO.update(module);
                if (Long.parseLong(req.getParameter("parent")) != Long.parseLong(req.getParameter("parentOld"))) {
                    modulesDAO.updateHasChildren(Long.parseLong(req.getParameter("parentOld")), Long.parseLong(req.getParameter("parent")));
                }
            }

        }
        if (req.getRequestURL().toString().contains("domain/modules/edit")) {
            Long modulesId = Long.parseLong(req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/") + 1));
            RequestDispatcher rd = req.getRequestDispatcher("/view/layouts/modules/modules/edit.jsp");
            Modules modules = modulesDAO.find(modulesId);
            Modules parentModule = modulesDAO.getSubModules(modules).getModules();
            req.setAttribute("modules", modules);
            req.setAttribute("parentModule", parentModule);
            rd.forward(req, resp);
        }
        if (req.getRequestURL().toString().contains("domain/modules/delete")) {
            // there must be an option for remove all childs
            // 
            Long modulesId = Long.parseLong(req.getRequestURL().toString().substring(req.getRequestURL().toString().lastIndexOf("/") + 1));
            if (modulesId > 1) {
                Modules module = modulesDAO.find(modulesId);
                if (module != null && module.getId() > 0) {
                    //if parent is there, then and then only check for both to reset hasChildren
                    modulesDAO.remove(module);
                }
            }

        }
    }

}
