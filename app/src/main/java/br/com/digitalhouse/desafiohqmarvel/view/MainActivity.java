package br.com.digitalhouse.desafiohqmarvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import br.com.digitalhouse.desafiohqmarvel.Adapter.RecyclerViewHqAdapter;
import br.com.digitalhouse.desafiohqmarvel.R;
import br.com.digitalhouse.desafiohqmarvel.viewmodel.HqsViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hqRecyclerView;
    private HqsViewModel viewModel;
    private RecyclerViewHqAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        viewModel.getComics();
        // Atualiza a lista com os quadriho buscados na API
        viewModel.getResults().observe(this, results -> adapter.update(results));
    }

    private void initViews() {
        viewModel = ViewModelProviders.of(this).get(HqsViewModel.class);
        hqRecyclerView = findViewById(R.id.hqRecyclerView);
        adapter = new RecyclerViewHqAdapter(new ArrayList<>());
        hqRecyclerView.setAdapter(adapter);
        hqRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}