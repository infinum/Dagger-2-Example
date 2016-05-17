package co.infinum.pokemon.features.pokedex;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.features.shared.adapters.PokemonAdapter;
import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.modules.PokedexModule;
import co.infinum.pokemon.features.shared.PokemonDetailsActivity;
import co.infinum.pokemon.features.shared.BaseActivity;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpPokedex;

/**
 * Created by Ivan on 16/05/16.
 */
public class PokedexActivity extends BaseActivity implements MvpPokedex.View, PokemonAdapter.PokemonClickListener {

    @InjectView(R.id.recycler_pokemon_list)
    protected RecyclerView pokemonListRecycler;

    @Inject
    protected MvpPokedex.Presenter pokedexPresenter;

    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ButterKnife.inject(this);

        pokemonListRecycler.setHasFixedSize(true);
        pokemonListRecycler.setLayoutManager(new LinearLayoutManager(this));

        pokedexPresenter.loadPokedex();

    }

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new PokedexModule(this)).inject(this);
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        pokemonAdapter = new PokemonAdapter(pokemons);
        pokemonAdapter.setPokemonClickListener(this);
        pokemonListRecycler.setAdapter(pokemonAdapter);
    }

    @Override
    public void onPokemonClicked(Pokemon pokemon) {
        pokedexPresenter.onPokemonSelected(pokemon);
    }

    @Override
    public void showPokemonDetails(Pokemon pokemon) {
        Intent intent = new Intent(this, PokemonDetailsActivity.class);
        intent.putExtra(PokemonDetailsActivity.EXTRA_POKEMON, pokemon);
        startActivity(intent);
    }

    @Override
    public void newPokemon(Pokemon pokemon) {
        pokemonAdapter.addPokemon(pokemon);
        pokemonListRecycler.scrollToPosition(pokemon.getId() - 1);
        showPokemonDetails(pokemon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pokedex, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.initiateScan();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            // handle scan result
            pokedexPresenter.addPokemon(scanResult.getContents());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
