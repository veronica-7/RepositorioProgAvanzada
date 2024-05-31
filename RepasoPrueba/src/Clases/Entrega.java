/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.OneToOne;


@Entity
public class Entrega implements Serializable {
    @Id
    private String codigoEntrega;
    @Basic
    private Date fecha;
    private String observacion;

    @OneToOne
    @JoinColumn(name = "paquete_idPaquete")
    private Paquete idPaquete;
    
    @OneToMany
    @JoinColumn(name = "cliente_idCliente")
    private Cliente idCliente;
    
    @OneToMany
    @JoinColumn(name = "empleado_idEmpleado")
    private Empleado idEmpleado;

    public Entrega() {
    }

    public Entrega(String codigoEntrega, Date fecha, String observacion, Cliente idCliente, Empleado idEmpleado, Paquete idPaquete) {
        this.codigoEntrega = codigoEntrega;
        this.fecha = fecha;
        this.observacion = observacion;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idPaquete = idPaquete;
    }

    public String getCodigoEntrega() {
        return codigoEntrega;
    }

    public void setCodigoEntrega(String codigoEntrega) {
        this.codigoEntrega = codigoEntrega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public String toString() {
        return "Entrega{" + "codigoEntrega=" + codigoEntrega + ", fecha=" + fecha + ", observacion=" + observacion + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + ", idPaquete=" + idPaquete + '}';
    }         
}
