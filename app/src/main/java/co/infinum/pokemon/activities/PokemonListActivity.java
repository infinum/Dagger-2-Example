package co.infinum.pokemon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.adapters.PokemonAdapter;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.impl.PokemonListInteractorImpl;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import co.infinum.pokemon.mvp.presenters.impl.PokemonListPresenterImpl;
import co.infinum.pokemon.mvp.views.PokemonListView;

public class PokemonListActivity extends BaseActivity implements PokemonListView, PokemonAdapter.PokemonClickListener {

    @InjectView(R.id.recycler_pokemon_list)
    protected RecyclerView pokemonListRecycler;

    protected PokemonListPresenter pokemonListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ButterKnife.inject(this);

        pokemonListRecycler.setHasFixedSize(true);
        pokemonListRecycler.setLayoutManager(new LinearLayoutManager(this));

        pokemonListPresenter = new PokemonListPresenterImpl(this, new PokemonListInteractorImpl());
        pokemonListPresenter.loadPokemonList();
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemons);
        pokemonAdapter.setPokemonClickListener(this);
        pokemonListRecycler.setAdapter(pokemonAdapter);
    }

    @Override
    public void onPokemonClicked(Pokemon pokemon) {
        pokemonListPresenter.onPokemonSelected(pokemon);
    }

    @Override
    public void showPokemonDetails(Pokemon pokemon) {
        Intent intent = new Intent(this, PokemonDetailsActivity.class);
        intent.putExtra(PokemonDetailsActivity.EXTRA_POKEMON, pokemon);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pokemonListPresenter.cancel();
    }
}
