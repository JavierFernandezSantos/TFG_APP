package apiResult;

import java.time.LocalDate;

public class UsuarioRegistro {

    private String email;
    private String pass;
    private String fechaNac;
    private String nombre;
    private String apellido;

    public UsuarioRegistro( String email, String pass, String fechaNac, String nombre, String apellido) {
        this.email = email;
        this.pass = pass;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
