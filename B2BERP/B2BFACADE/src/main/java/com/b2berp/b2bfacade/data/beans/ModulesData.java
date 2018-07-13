/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2berp.b2bfacade.data.beans;

import com.b2berp.b2bmodel.core.BusinessCompany;
import com.b2berp.b2bmodel.core.Mediaformat;
import com.b2berp.b2bmodel.core.Modules;
import com.b2berp.b2bmodel.core.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Milap Patel
 */
public class ModulesData {

    private Long id;
    private ModulesData modulesData;
    private User user;
    private Date createdAt;
    private Date updatedAt;
    private int active;
    private String moduleName;
    private String moduleTitle;
    private String moduleDesc;
    private String moduleImage;
    private String moduleType;
    private int priorityIndex;
    private int hasChildren;
    private String moduleUrl;
    private String moduleCss;
    private String moduleIconClass;
    private Long parentId;
    private String state;
    private Set<Mediaformat> mediaformats = new HashSet<Mediaformat>(0);
    private Set<Modules> moduleses = new HashSet<Modules>(0);
    private Set<BusinessCompany> businessCompanies = new HashSet<BusinessCompany>(0);

    public ModulesData() {
    }

    public ModulesData(Date createdAt, Date updatedAt, int active, String moduleName, String moduleTitle, String moduleType, int priorityIndex, int hasChildren) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.moduleName = moduleName;
        this.moduleTitle = moduleTitle;
        this.moduleType = moduleType;
        this.priorityIndex = priorityIndex;
        this.hasChildren = hasChildren;
    }

    public ModulesData(ModulesData modulesData, User user, Date createdAt, Date updatedAt, int active, String moduleName, String moduleTitle, String moduleDesc, String moduleImage, String moduleType, int priorityIndex, int hasChildren, String moduleUrl, String moduleCss, String moduleIconClass, Set<Mediaformat> mediaformats, Set<Modules> moduleses, Set<BusinessCompany> businessCompanies) {
        this.modulesData = modulesData;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.moduleName = moduleName;
        this.moduleTitle = moduleTitle;
        this.moduleDesc = moduleDesc;
        this.moduleImage = moduleImage;
        this.moduleType = moduleType;
        this.priorityIndex = priorityIndex;
        this.hasChildren = hasChildren;
        this.moduleUrl = moduleUrl;
        this.moduleCss = moduleCss;
        this.moduleIconClass = moduleIconClass;
        this.mediaformats = mediaformats;
        this.moduleses = moduleses;
        this.businessCompanies = businessCompanies;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModulesData getModulesData() {
        return this.modulesData;
    }

    public void setModulesData(ModulesData modulesData) {
        this.modulesData = modulesData;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getActive() {
        return this.active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleTitle() {
        return this.moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleDesc() {
        return this.moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleImage() {
        return this.moduleImage;
    }

    public void setModuleImage(String moduleImage) {
        this.moduleImage = moduleImage;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public int getPriorityIndex() {
        return this.priorityIndex;
    }

    public void setPriorityIndex(int priorityIndex) {
        this.priorityIndex = priorityIndex;
    }

    public String getModuleUrl() {
        return this.moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getModuleCss() {
        return this.moduleCss;
    }

    public void setModuleCss(String moduleCss) {
        this.moduleCss = moduleCss;
    }

    public String getModuleIconClass() {
        return this.moduleIconClass;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getState() {
        return state;
    }

    public void setModuleIconClass(String moduleIconClass) {
        this.moduleIconClass = moduleIconClass;
    }

    public Set<Mediaformat> getMediaformats() {
        return this.mediaformats;
    }

    public void setMediaformats(Set<Mediaformat> mediaformats) {
        this.mediaformats = mediaformats;
    }

    public Set<Modules> getModuleses() {
        return this.moduleses;
    }

    public void setModuleses(Set<Modules> moduleses) {
        this.moduleses = moduleses;
    }

    public Set<BusinessCompany> getBusinessCompanies() {
        return this.businessCompanies;
    }

    public void setBusinessCompanies(Set<BusinessCompany> businessCompanies) {
        this.businessCompanies = businessCompanies;
    }

    public int getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(int hasChildren) {
        this.hasChildren = hasChildren;
    }

}
