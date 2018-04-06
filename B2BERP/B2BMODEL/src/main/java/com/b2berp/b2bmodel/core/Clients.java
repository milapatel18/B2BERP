package com.b2berp.b2bmodel.core;
// Generated Feb 22, 2018 3:58:00 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clients generated by hbm2java
 */
@Entity
@Table(name = "clients",
         catalog = "erpcommerce"
)
public class Clients implements java.io.Serializable {

    private Long id;
    private BusinessCompany businessCompany;
    private User user;
    private Date createdAt;
    private Date updatedAt;
    private Integer active;
    private String clientName;
    private String clientCompany;
    private String clientPhone;
    private String clientEmail;
    private String clientType;
    private BigDecimal creditLimit;
    private BigDecimal debitLimit;
    private Long parent;
    private Integer checklimit;
    private Set<Addresses> addresseses = new HashSet<Addresses>(0);

    public Clients() {
    }

    public Clients(Date createdAt, Date updatedAt, String clientCompany) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.clientCompany = clientCompany;
    }

    public Clients(BusinessCompany businessCompany, User user, Date createdAt, Date updatedAt, Integer active, String clientName, String clientCompany, String clientPhone, String clientEmail, String clientType, BigDecimal creditLimit, BigDecimal debitLimit, Long parent, Integer checklimit, Set<Addresses> addresseses) {
        this.businessCompany = businessCompany;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.clientName = clientName;
        this.clientCompany = clientCompany;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.clientType = clientType;
        this.creditLimit = creditLimit;
        this.debitLimit = debitLimit;
        this.parent = parent;
        this.checklimit = checklimit;
        this.addresseses = addresseses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    public BusinessCompany getBusinessCompany() {
        return this.businessCompany;
    }

    public void setBusinessCompany(BusinessCompany businessCompany) {
        this.businessCompany = businessCompany;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 19)
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, length = 19)
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "active")
    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Column(name = "client_name")
    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name = "client_company", nullable = false)
    public String getClientCompany() {
        return this.clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    @Column(name = "client_phone")
    public String getClientPhone() {
        return this.clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Column(name = "client_email")
    public String getClientEmail() {
        return this.clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Column(name = "client_type")
    public String getClientType() {
        return this.clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Column(name = "credit_limit", precision = 10)
    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Column(name = "debit_limit", precision = 10)
    public BigDecimal getDebitLimit() {
        return this.debitLimit;
    }

    public void setDebitLimit(BigDecimal debitLimit) {
        this.debitLimit = debitLimit;
    }

    @Column(name = "parent")
    public Long getParent() {
        return this.parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Column(name = "checklimit")
    public Integer getChecklimit() {
        return this.checklimit;
    }

    public void setChecklimit(Integer checklimit) {
        this.checklimit = checklimit;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients")
    public Set<Addresses> getAddresseses() {
        return this.addresseses;
    }

    public void setAddresseses(Set<Addresses> addresseses) {
        this.addresseses = addresseses;
    }

}