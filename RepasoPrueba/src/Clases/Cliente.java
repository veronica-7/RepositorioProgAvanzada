
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente extends Persona implements Serializable{
    @Basic
    private String celular;

    @OneToMany(mappedBy = "direccion")
    private List<Direccion> direccion;
    
    @OneToMany(mappedBy = "entrega")
    private List<Entrega> entrega;
    
    public Cliente() {
        this.direccion = new ArrayList<>();
    }

    public Cliente(String celular, ArrayList<Direccion> direccion) {
        this.celular = celular;
        this.direccion = direccion;
    }

    public Cliente(String celular, ArrayList<Direccion> direccion, String cedula, String apellidos, String nombres, String mail) {
        super(cedula, apellidos, nombres, mail);
        this.celular = celular;
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", direccion=" + direccion + '}';
    }
}
