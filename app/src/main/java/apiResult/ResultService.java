package apiResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResultService {
    @GET("/v2/competitions/PD/matches/")
    Call<Result> listResult(@Header("X-Auth-Token") String a, @Query("matchday") String j);

    @GET("iniciarsesion1/{email}/{pass}")
    Call<Usuario> iniciarSesion(@Path("email") String email,@Path("pass") String pass);

    @POST("/insertarusuario")
    Call<UsuarioRegistro> insertarUsuario(UsuarioRegistro user);
}
