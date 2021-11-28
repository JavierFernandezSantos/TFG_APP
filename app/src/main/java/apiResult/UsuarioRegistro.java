package apiResult;

import java.time.LocalDate;

public class UsuarioRegistro {

    private String email;
    private String contraseña;
    private LocalDate fecha;
    private String nombre;
    private String apellidos;

    public UsuarioRegistro( String email, String contraseña, LocalDate fecha, String nombre, String apellidos) {
        this.email = email;
        this.contraseña = contraseña;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
