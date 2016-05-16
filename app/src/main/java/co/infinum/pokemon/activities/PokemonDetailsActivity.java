package co.infinum.pokemon.activities;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.pokemon.R;
import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails;

public class PokemonDetailsActivity extends BaseActivity implements MvpPokemonDetails.View {

    public static final String EXTRA_POKEMON = "pokemon";

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

    @Inject
    protected MvpPokemonDetails.Presenter pokemonDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        ButterKnife.inject(this);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra(EXTRA_POKEMON);
        pokemonDetailsPresenter.loadDetails(pokemon);
    }

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new PokemonDetailsModule(this)).inject(this);
    }


    @Override
    protected void onDestroy() {
        pokemonDetailsPresenter.cancel();
        super.onDestroy();
    }

    @Override
    public void showName(String name) {
        nameText.setText(name);
    }

    @Override
    public void showHp(String hp) {
        hpText.setText(hp);
    }

    @Override
    public void showWeight(String weight) {
        weightText.setText(weight);
    }

    @Override
    public void showHeight(String height) {
        heightText.setText(height);
    }

    @Override
    public void showAttack(String attack) {
        attackText.setText(attack);
    }

    @Override
    public void showDefense(String defense) {
        defenseText.setText(defense);
    }
}
