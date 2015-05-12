package co.infinum.pokemon.activities;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.impl.PokemonDetailsInteractorImpl;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import co.infinum.pokemon.mvp.presenters.impl.PokemonDetailsPresenterImpl;
import co.infinum.pokemon.mvp.views.PokemonDetailsView;

public class PokemonDetailsActivity extends BaseActivity implements PokemonDetailsView {

    public static final String EXTRA_POKEMON = "pokemon";

    protected PokemonDetailsPresenter pokemonDetailsPresenter;

    @InjectView(R.id.name)
    protected TextView nameText;

    @InjectView(R.id.hp)
    protected TextView hpText;

    @InjectView(R.id.weight)
    protected TextView weightText;

    @InjectView(R.id.height)
    protected TextView heightText;

    @InjectView(R.id.attack)
    protected TextView attackText;

    @InjectView(R.id.defense)
    protected TextView defenseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        ButterKnife.inject(this);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra(EXTRA_POKEMON);
        pokemonDetailsPresenter = new PokemonDetailsPresenterImpl(this, new PokemonDetailsInteractorImpl());
        pokemonDetailsPresenter.loadDetails(pokemon);
    }

    @Override
    public void showDetails(Pokemon pokemon) {
        nameText.setText(pokemon.getName());
        hpText.setText(String.valueOf(pokemon.getHp()));
        heightText.setText(pokemon.getHeight());
        weightText.setText(pokemon.getWeight());
        attackText.setText(String.valueOf(pokemon.getAttack()));
        defenseText.setText(String.valueOf(pokemon.getDefense()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pokemonDetailsPresenter.cancel();
    }
}
