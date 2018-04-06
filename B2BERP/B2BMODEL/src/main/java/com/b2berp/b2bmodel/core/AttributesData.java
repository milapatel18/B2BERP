package com.b2berp.b2bmodel.core;
// Generated Feb 22, 2018 3:58:00 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AttributesData generated by hbm2java
 */
@Entity
@Table(name = "attributes_data",
        catalog = "erpcommerce"
)
public class AttributesData implements java.io.Serializable {

    private Long id;
    private User user;
    private Date createdAt;
    private Date updatedAt;
    private Integer active;
    private long attributeTypesId;
    private String attributeName;
    private String attributeTitle;
    private String attributeValtype;

    public AttributesData() {
    }

    public AttributesData(Date createdAt, Date updatedAt, long attributeTypesId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.attributeTypesId = attributeTypesId;
    }

    public AttributesData(User user, Date createdAt, Date updatedAt, Integer active, long attributeTypesId, String attributeName, String attributeTitle, String attributeValtype) {
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.attributeTypesId = attributeTypesId;
        this.attributeName = attributeName;
        this.attributeTitle = attributeTitle;
        this.attributeValtype = attributeValtype;
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

    @Column(name = "attribute_types_id", nullable = false)
    public long getAttributeTypesId() {
        return this.attributeTypesId;
    }

    public void setAttributeTypesId(long attributeTypesId) {
        this.attributeTypesId = attributeTypesId;
    }

    @Column(name = "attribute_name")
    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Column(name = "attribute_title")
    public String getAttributeTitle() {
        return this.attributeTitle;
    }

    public void setAttributeTitle(String attributeTitle) {
        this.attributeTitle = attributeTitle;
    }

    @Column(name = "attribute_valtype")
    public String getAttributeValtype() {
        return this.attributeValtype;
    }

    public void setAttributeValtype(String attributeValtype) {
        this.attributeValtype = attributeValtype;
    }

}
