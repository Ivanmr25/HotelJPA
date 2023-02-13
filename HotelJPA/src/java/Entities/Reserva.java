/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByNreserva", query = "SELECT r FROM Reserva r WHERE r.nreserva = :nreserva")
    , @NamedQuery(name = "Reserva.findByFechae", query = "SELECT r FROM Reserva r WHERE r.fechae = :fechae")
    , @NamedQuery(name = "Reserva.findByFechas", query = "SELECT r FROM Reserva r WHERE r.fechas = :fechas")
    , @NamedQuery(name = "Reserva.findByDni", query = "SELECT r FROM Reserva r WHERE r.dni = :dni")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NRESERVA")
    private Short nreserva;
    @Basic(optional = false)
    @Column(name = "FECHAE")
    private String fechae;
    @Basic(optional = false)
    @Column(name = "FECHAS")
    private String fechas;
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @JoinColumn(name = "NHABITACION", referencedColumnName = "NHABITACION")
    @ManyToOne(optional = false)
    private Habitacion nhabitacion;

    public Reserva() {
    }

    public Reserva(Short nreserva) {
        this.nreserva = nreserva;
    }

    public Reserva(Short nreserva, String fechae, String fechas, String dni) {
        this.nreserva = nreserva;
        this.fechae = fechae;
        this.fechas = fechas;
        this.dni = dni;
    }

    public Short getNreserva() {
        return nreserva;
    }

    public void setNreserva(Short nreserva) {
        this.nreserva = nreserva;
    }

    public String getFechae() {
        return fechae;
    }

    public void setFechae(String fechae) {
        this.fechae = fechae;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Habitacion getNhabitacion() {
        return nhabitacion;
    }

    public void setNhabitacion(Habitacion nhabitacion) {
        this.nhabitacion = nhabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nreserva != null ? nreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.nreserva == null && other.nreserva != null) || (this.nreserva != null && !this.nreserva.equals(other.nreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reserva[ nreserva=" + nreserva + " ]";
    }
    
}
