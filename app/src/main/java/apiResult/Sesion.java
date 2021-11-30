package apiResult;

public class Sesion {
    private String email;
    private String pass;
    private String tipo;

    public Sesion(String email, String pass, String tipo) {
        super();
        this.email = email;
        this.pass = pass;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
