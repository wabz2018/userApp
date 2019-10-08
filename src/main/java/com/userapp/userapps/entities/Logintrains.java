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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maelo
 */
@Entity
@Table(name = "logintrains", catalog = "userapp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logintrains.findAll", query = "SELECT l FROM Logintrains l")
    , @NamedQuery(name = "Logintrains.findById", query = "SELECT l FROM Logintrains l WHERE l.id = :id")
    , @NamedQuery(name = "Logintrains.findByToken", query = "SELECT l FROM Logintrains l WHERE l.token = :token")
    , @NamedQuery(name = "Logintrains.findByUsername", query = "SELECT l FROM Logintrains l WHERE l.username = :username")
    , @NamedQuery(name = "Logintrains.findByTimelogged", query = "SELECT l FROM Logintrains l WHERE l.timelogged = :timelogged")})
public class Logintrains implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "token")
    private String token;
    @Size(max = 30)
    @Column(name = "username")
    private String username;
    @Column(name = "timelogged")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timelogged;

    public Logintrains() {
    }

    public Logintrains(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimelogged() {
        return timelogged;
    }

    public void setTimelogged(Date timelogged) {
        this.timelogged = timelogged;
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
        if (!(object instanceof Logintrains)) {
            return false;
        }
        Logintrains other = (Logintrains) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.userapp.userapps.entities.Logintrains[ id=" + id + " ]";
    }
    
}
