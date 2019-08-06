package br.com.digitalhouse.desafiohqmarvel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import br.com.digitalhouse.desafiohqmarvel.R;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageHq;
    private ImageView imageClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image);

        // Inicializa as views que serão utilizadas na activity
        imageHq = findViewById(R.id.imageHq);
        imageClose = findViewById(R.id.imageClose);

        // Pegamos o quadrinho que que foi clicado na imagem anterior
        String image = getIntent().getStringExtra("image");

        // Carregamos a imagem
        Picasso.get().load(image)
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(imageHq);

        // Adidionamos o evento de click para fechar-mos a tela
        imageClose.setOnClickListener(v -> finish());
    }
}