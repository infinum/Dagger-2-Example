package co.infinum.pokemon.activities;

import com.zplesac.connectifty.Connectify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.adapters.PokemonAdapter;
import co.infinum.pokemon.dagger.components.DaggerPokemonListComponent;
import co.infinum.pokemon.dagger.components.PokemonListComponent;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import co.infinum.pokemon.mvp.views.PokemonListView;

public class PokemonListActivity extends BaseActivity implements PokemonListView, PokemonAdapter.PokemonClickListener {

    private static final int SNACKBAR_DURATION = 2000;

    @InjectView(R.id.recycler_pokemon_list)
    protected RecyclerView pokemonListRecycler;

    @Inject
    protected PokemonListPresenter pokemonListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ButterKnife.inject(this);

        initUI();

        injectDependencies();

        pokemonListPresenter.loadPokemonList();
    }

    private void injectDependencies() {

        boolean hasNetworkConnection = Connectify.getInstance().hasNetworkConnection();

        PokemonListComponent component = DaggerPokemonListComponent.builder()
                .pokemonListModule(new PokemonListModule(this, hasNetworkConnection))
                .build();
        component.inject(this);
    }

    private void initUI() {
        pokemonListRecycler.setHasFixedSize(true);
        pokemonListRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons, String fetchedFrom) {
        PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemons);
        pokemonAdapter.setPokemonClickListener(this);
        pokemonListRecycler.setAdapter(pokemonAdapter);
        Snackbar.make(pokemonListRecycler, fetchedFrom, SNACKBAR_DURATION).show();

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
