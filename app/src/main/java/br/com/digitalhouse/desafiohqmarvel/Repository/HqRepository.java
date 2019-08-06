package br.com.digitalhouse.desafiohqmarvel.Repository;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.digitalhouse.desafiohqmarvel.R;
import br.com.digitalhouse.desafiohqmarvel.model.HqsResponse;

import static br.com.digitalhouse.desafiohqmarvel.Util.AppUtils.md5;

public class HqRepository extends AppCompatActivity {

    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";

    public Single<HqsResponse> getHqs() {
        String ts = Long.toString(System.currentTimeMillis() / 1000);
        String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);
    }
}