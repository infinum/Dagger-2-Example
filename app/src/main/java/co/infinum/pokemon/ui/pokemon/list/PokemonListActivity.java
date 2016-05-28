package co.infinum.pokemon.ui.pokemon.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.ui.BaseActivity;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsActivity;
import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.data.models.Pokemon;

public class PokemonListActivity extends BaseActivity implements PokemonListView, PokemonListAdapter.PokemonClickListener {

    @InjectView(R.id.recycler_pokemon_list)
    protected RecyclerView pokemonListRecycler;

    @Inject
    protected PokemonListPresenter pokemonListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ButterKnife.inject(this);

        pokemonListRecycler.setHasFixedSize(true);
        pokemonListRecycler.setLayoutManager(new LinearLayoutManager(this));

        pokemonListPresenter.loadPokemonList();
    }

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new PokemonListModule(this)).inject(this);
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        PokemonListAdapter pokemonListAdapter = new PokemonListAdapter(pokemons);
        pokemonListAdapter.setPokemonClickListener(this);
        pokemonListRecycler.setAdapter(pokemonListAdapter);
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
        pokemonListPresenter.cancel();
        super.onDestroy();
    }
}
