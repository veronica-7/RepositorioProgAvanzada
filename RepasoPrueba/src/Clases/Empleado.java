
package Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado extends Persona implements Serializable {
    private String ciudad;
    
    @OneToOne(mappedBy = "entrega")
    private Entrega entrega;
    
    public Empleado() {
    }

    public Empleado(String ciudad) {
        this.ciudad = ciudad;
    }

    public Empleado(String ciudad, String cedula, String apellidos, String nombres, String mail) {
        super(cedula, apellidos, nombres, mail);
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ciudad=" + ciudad + '}';
    }
}
