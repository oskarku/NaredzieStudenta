package programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.API;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Konwerter.CategoryConwert.RETOFIT.RateList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers({"Accept: application/json"})
    @GET("api/exchangerates/rates/a/eur/")
    Call<RateList> getMyJSONeur();

    @Headers({"Accept: application/json"})
    @GET("api/exchangerates/rates/a/usd/")
    Call<RateList> getMyJSONusd();

    @Headers({"Accept: application/json"})
    @GET("api/exchangerates/rates/a/chf/")
    Call<RateList> getMyJSONchf();





}
