package co.infinum.pokemon.features.shared.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private List<Pokemon> pokemonList;

    private PokemonClickListener pokemonClickListener;

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        Collections.sort(this.pokemonList, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon lhs, Pokemon rhs) {
                return lhs.getId() - rhs.getId();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pokemon, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Pokemon pokemon = pokemonList.get(i);
        viewHolder.pokemonId.setText("#" + pokemon.getId());
        viewHolder.pokemonName.setText(pokemon.getName());
        viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pokemonClickListener != null) {
                    pokemonClickListener.onPokemonClicked(pokemon);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void setPokemonClickListener(PokemonClickListener pokemonClickListener) {
        this.pokemonClickListener = pokemonClickListener;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.remove(pokemon.getId() - 1);
        pokemonList.add(pokemon.getId() - 1, pokemon);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View rootView;

        @InjectView(R.id.pokemon_id)
        TextView pokemonId;

        @InjectView(R.id.pokemon_name)
        TextView pokemonName;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;

            ButterKnife.inject(this, itemView);
        }
    }

    public interface PokemonClickListener {

        public void onPokemonClicked(Pokemon pokemon);
    }
}
