package apiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ResultService {
    @GET("/v2/competitions/PD/matches/?matchday=14")
    Call<Result> listResult(@Header("X-Auth-Token") String a);

}
