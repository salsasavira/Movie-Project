package id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.rest;


import id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie.model.ResultsRespone;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by asus on 14-May-17.
 */

public class ApiInterface {
    @GET("movie/top_rated")
    Call<ResultsRespone> getTopRatedMovies(@Query("api_key") String apiKey) {
        return null;
    }

    @GET("movie/{id}")
    Call<ResultsRespone> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey) {
        return null;
    }
}
