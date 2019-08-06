package br.com.digitalhouse.desafiohqmarvel.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.xml.transform.Result;

import br.com.digitalhouse.desafiohqmarvel.R;
import br.com.digitalhouse.desafiohqmarvel.view.DetailActivity;
import br.com.digitalhouse.hqmarvelchallengeapp.R;
import br.com.digitalhouse.hqmarvelchallengeapp.model.Result;
import br.com.digitalhouse.hqmarvelchallengeapp.view.HqDetailActivity;

public class RecyclerViewHqAdapter extends RecyclerView.Adapter<RecyclerViewHqAdapter.ViewHolder> {

    private List<Result> results;

    public RecyclerViewHqAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_hq_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Result result = results.get(position);
        viewHolder.bind(result);

        viewHolder.itemView.setOnClickListener(v -> {

            String transitionName = "image_" + position;
            Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("comic", result);
            intent.putExtra("transitionName", transitionName);

            viewHolder.imageViewHq.setTransitionName(transitionName);

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) viewHolder.itemView.getContext(),
                            viewHolder.imageViewHq  , transitionName);

            viewHolder.itemView.getContext().startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewHq;
        private TextView textViewHqNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHq = itemView.findViewById(R.id.imageViewHq);
            textViewHqNumber = itemView.findViewById(R.id.textViewHqNumber);
        }

        private void bind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + "/portrait_incredible." + result.getThumbnail().getExtension())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(imageViewHq);

            textViewHqNumber.setText("# " + result.getNumber());
        }
    }

    public void update(List<Result> resultList) {
        this.results = resultList;
        notifyDataSetChanged();
    }
}
