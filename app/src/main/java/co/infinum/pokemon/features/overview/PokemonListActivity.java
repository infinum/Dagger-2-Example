package co.infinum.pokemon.features.overview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.features.shared.adapters.PokemonAdapter;
import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.features.shared.PokemonDetailsActivity;
import co.infinum.pokemon.features.shared.BaseActivity;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;

public class PokemonListActivity extends BaseActivity implements MvpPokemonList.View, PokemonAdapter.PokemonClickListener {

    @InjectView(R.id.recycler_pokemon_list)
    protected RecyclerView pokemonListRecycler;

    @Inject
    protected MvpPokemonList.Presenter pokemonListPresenter;

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
        pokemonListPresenter.cancel();
        super.onDestroy();
    }
}
