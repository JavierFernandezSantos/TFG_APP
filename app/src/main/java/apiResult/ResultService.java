package apiResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultService {
    @GET("/v2/competitions/PD/matches/?matchday=14")
    Call<List<Result>> listResult();
}
