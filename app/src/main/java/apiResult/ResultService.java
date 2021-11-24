package apiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import retrofit2.http.Query;

public interface ResultService {
    @GET("/v2/competitions/PD/matches/")
    Call<Result> listResult(@Header("X-Auth-Token") String a, @Query("matchday") String j);

}
