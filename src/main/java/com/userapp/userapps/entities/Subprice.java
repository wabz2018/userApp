/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maelo
 */
@Entity
@Table(name = "subprice", catalog = "userapp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subprice.findAll", query = "SELECT s FROM Subprice s")
    , @NamedQuery(name = "Subprice.findById", query = "SELECT s FROM Subprice s WHERE s.id = :id")
    , @NamedQuery(name = "Subprice.findBySubcode", query = "SELECT s FROM Subprice s WHERE s.subcode = :subcode")
    , @NamedQuery(name = "Subprice.findByIsactive", query = "SELECT s FROM Subprice s WHERE s.isactive = :isactive")
    , @NamedQuery(name = "Subprice.findByPrice", query = "SELECT s FROM Subprice s WHERE s.price = :price")})
public class Subprice implements Serializable {

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
    @Column(name = "Isactive")
    private Character isactive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;

    public Subprice() {
    }

    public Subprice(Integer id) {
        this.id = id;
    }

    public Subprice(Integer id, String subcode) {
        this.id = id;
        this.subcode = subcode;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        if (!(object instanceof Subprice)) {
            return false;
        }
        Subprice other = (Subprice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.userapp.userapps.entities.Subprice[ id=" + id + " ]";
    }
    
}
