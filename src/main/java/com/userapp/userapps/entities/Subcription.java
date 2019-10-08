/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maelo
 */
@Entity
@Table(name = "subcription", catalog = "userapp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcription.findAll", query = "SELECT s FROM Subcription s")
    , @NamedQuery(name = "Subcription.findById", query = "SELECT s FROM Subcription s WHERE s.id = :id")
    , @NamedQuery(name = "Subcription.findBySubcode", query = "SELECT s FROM Subcription s WHERE s.subcode = :subcode")
    , @NamedQuery(name = "Subcription.findBySubplan", query = "SELECT s FROM Subcription s WHERE s.subplan = :subplan")
    , @NamedQuery(name = "Subcription.findByCustId", query = "SELECT s FROM Subcription s WHERE s.custId = :custId")
    , @NamedQuery(name = "Subcription.findByStartDate", query = "SELECT s FROM Subcription s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Subcription.findByDuration", query = "SELECT s FROM Subcription s WHERE s.duration = :duration")
    , @NamedQuery(name = "Subcription.findByExpirydate", query = "SELECT s FROM Subcription s WHERE s.expirydate = :expirydate")})
public class Subcription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "subcode")
    private String subcode;
    @Size(max = 30)
    @Column(name = "subplan")
    private String subplan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "custId")
    private String custId;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "expirydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;

    public Subcription() {
    }

    public Subcription(Integer id) {
        this.id = id;
    }

    public Subcription(Integer id, String subcode, String custId) {
        this.id = id;
        this.subcode = subcode;
        this.custId = custId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getSubplan() {
        return subplan;
    }

    public void setSubplan(String subplan) {
        this.subplan = subplan;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcription)) {
            return false;
        }
        Subcription other = (Subcription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.userapp.userapps.entities.Subcription[ id=" + id + " ]";
    }
    
}
