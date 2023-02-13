/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class OcupacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NHABITACION")
    private String nhabitacion;
    @Basic(optional = false)
    @Column(name = "FECHAE")
    private String fechae;

    public OcupacionPK() {
    }

    public OcupacionPK(String nhabitacion, String fechae) {
        this.nhabitacion = nhabitacion;
        this.fechae = fechae;
    }

    public String getNhabitacion() {
        return nhabitacion;
    }

    public void setNhabitacion(String nhabitacion) {
        this.nhabitacion = nhabitacion;
    }

    public String getFechae() {
        return fechae;
    }

    public void setFechae(String fechae) {
        this.fechae = fechae;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nhabitacion != null ? nhabitacion.hashCode() : 0);
        hash += (fechae != null ? fechae.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OcupacionPK)) {
            return false;
        }
        OcupacionPK other = (OcupacionPK) object;
        if ((this.nhabitacion == null && other.nhabitacion != null) || (this.nhabitacion != null && !this.nhabitacion.equals(other.nhabitacion))) {
            return false;
        }
        if ((this.fechae == null && other.fechae != null) || (this.fechae != null && !this.fechae.equals(other.fechae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.OcupacionPK[ nhabitacion=" + nhabitacion + ", fechae=" + fechae + " ]";
    }
    
}
