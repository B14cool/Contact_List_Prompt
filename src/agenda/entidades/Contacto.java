
package agenda.entidades;

public class Contacto {
   
    protected String nombre;    
    protected String telefono;
    protected String direccion;
    protected String edad;
    protected String correo;

    public void Contacto() {
    this.nombre= null;
    this.telefono= null;
    }
    
    public void Contacto(String nombre, String telefono, String direccion, String edad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
    }
   
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
   
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }     
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
