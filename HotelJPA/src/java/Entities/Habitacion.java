/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h")
    , @NamedQuery(name = "Habitacion.findByNhabitacion", query = "SELECT h FROM Habitacion h WHERE h.nhabitacion = :nhabitacion")
    , @NamedQuery(name = "Habitacion.findByNpersonas", query = "SELECT h FROM Habitacion h WHERE h.npersonas = :npersonas")
    , @NamedQuery(name = "Habitacion.findByPrecio", query = "SELECT h FROM Habitacion h WHERE h.precio = :precio")
    , @NamedQuery(name = "Habitacion.findByOcupada", query = "SELECT h FROM Habitacion h WHERE h.ocupada = :ocupada")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NHABITACION")
    private String nhabitacion;
    @Basic(optional = false)
    @Column(name = "NPERSONAS")
    private short npersonas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "OCUPADA")
    private short ocupada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitacion")
    private List<Ocupacion> ocupacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhabitacion")
    private List<Reserva> reservaList;

    public Habitacion() {
    }

    public Habitacion(String nhabitacion) {
        this.nhabitacion = nhabitacion;
    }

    public Habitacion(String nhabitacion, short npersonas, BigDecimal precio, short ocupada) {
        this.nhabitacion = nhabitacion;
        this.npersonas = npersonas;
        this.precio = precio;
        this.ocupada = ocupada;
    }

    public String getNhabitacion() {
        return nhabitacion;
    }

    public void setNhabitacion(String nhabitacion) {
        this.nhabitacion = nhabitacion;
    }

    public short getNpersonas() {
        return npersonas;
    }

    public void setNpersonas(short npersonas) {
        this.npersonas = npersonas;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public short getOcupada() {
        return ocupada;
    }

    public void setOcupada(short ocupada) {
        this.ocupada = ocupada;
    }

    @XmlTransient
    public List<Ocupacion> getOcupacionList() {
        return ocupacionList;
    }

    public void setOcupacionList(List<Ocupacion> ocupacionList) {
        this.ocupacionList = ocupacionList;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nhabitacion != null ? nhabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.nhabitacion == null && other.nhabitacion != null) || (this.nhabitacion != null && !this.nhabitacion.equals(other.nhabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Habitacion[ nhabitacion=" + nhabitacion + " ]";
    }
    
}
