package br.com.digitalhouse.desafiohqmarvel.Data;

import br.com.digitalhouse.desafiohqmarvel.model.HqsResponse;

public interface Api {
    @GET("hqs")
    Single<HqsResponse> getComics(
            @Query("format") String format,
            @Query("formatType") String formatType,
            @Query("noVariants") boolean noVariants,
            @Query("orderBy") String orderBy,
            @Query("limit") String limit,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey);
}
