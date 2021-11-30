package apiResult;

import java.util.List;

public class UsuarioL {

    private int id;
    private String nombre;
    private String apellido;
    private Object fechaNac;
    private int puntos;
    private Sesion sesion;
    private List<Object> preguntasResueltas = null;


    public UsuarioL() {
    }

    public UsuarioL(int id, String nombre, String apellido, Object fechaNac, int puntos, Sesion sesion, List<Object> preguntasResueltas) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.puntos = puntos;
        this.sesion = sesion;
        this.preguntasResueltas = preguntasResueltas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Object fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public List<Object> getPreguntasResueltas() {
        return preguntasResueltas;
    }

    public void setPreguntasResueltas(List<Object> preguntasResueltas) {
        this.preguntasResueltas = preguntasResueltas;
    }
}
