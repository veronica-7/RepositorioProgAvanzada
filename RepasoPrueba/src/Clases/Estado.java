
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Estado implements Serializable {
    @Id
    private int tipo;
    @Basic
    private String estado;
    private Date fecha;
    private String observacion;
    // private int idPaquete;

    @ManyToOne
    @JoinColumn(name = "paquete_idPaquete")
    private Paquete idPaquete;
    
    public Estado() {
    }

    public Estado(int tipo, String estado, Date fecha, String observacion, Paquete idPaquete) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
        this.idPaquete = idPaquete;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public String toString() {
        return "Estado{" + "tipo=" + tipo + ", estado=" + estado + ", fecha=" + fecha + ", observacion=" + observacion + ", idPaquete=" + idPaquete + '}';
    }
}
