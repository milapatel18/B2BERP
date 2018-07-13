package com.b2berp.b2bfacade.data.beans;
// Generated Feb 4, 2018 10:28:18 PM by Hibernate Tools 4.3.1

import com.b2berp.b2bmodel.core.Addresses;
import com.b2berp.b2bmodel.core.AttributeTypes;
import com.b2berp.b2bmodel.core.Clients;
import com.b2berp.b2bmodel.core.Modules;
import com.b2berp.b2bmodel.core.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BusinessCompanyData implements java.io.Serializable {

    private Long id;
    private User user;
    private String businessName;
    private String businessId;
    private String category;
    private int active;
    private Date createdAt;
    private Date updatedAt;
    private String state;

    private Set<Addresses> addresseses = new HashSet<Addresses>(0);
    private Set<Modules> moduleses = new HashSet<Modules>(0);
    private Set<Clients> clientses = new HashSet<Clients>(0);
    private Set<AttributeTypes> attributeTypeses = new HashSet<AttributeTypes>(0);
    private Set<User> users = new HashSet<User>(0);

    public BusinessCompanyData() {
    }

    public BusinessCompanyData(String businessName, String businessId, int active, Date createdAt, Date updatedAt) {
        this.businessName = businessName;
        this.businessId = businessId;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BusinessCompanyData(User user, String businessName, String businessId, String category, int active, Date createdAt, Date updatedAt, String state, Set<Addresses> addresseses, Set<Modules> moduleses, Set<Clients> clientses, Set<AttributeTypes> attributeTypeses, Set<User> users) {
        this.user = user;
        this.businessName = businessName;
        this.businessId = businessId;
        this.category = category;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.state = state;
        this.addresseses = addresseses;
        this.moduleses = moduleses;
        this.clientses = clientses;
        this.attributeTypeses = attributeTypeses;
        this.users = users;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getActive() {
        return this.active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public Set<Addresses> getAddresseses() {
        return this.addresseses;
    }

    public void setAddresseses(Set<Addresses> addresseses) {
        this.addresseses = addresseses;
    }

    public Set<Modules> getModuleses() {
        return this.moduleses;
    }

    public void setModuleses(Set<Modules> moduleses) {
        this.moduleses = moduleses;
    }

    public Set<Clients> getClientses() {
        return this.clientses;
    }

    public void setClientses(Set<Clients> clientses) {
        this.clientses = clientses;
    }

    public Set<AttributeTypes> getAttributeTypeses() {
        return this.attributeTypeses;
    }

    public void setAttributeTypeses(Set<AttributeTypes> attributeTypeses) {
        this.attributeTypeses = attributeTypeses;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
