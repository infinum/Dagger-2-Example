package co.infinum.pokemon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.pokemon.R;
import co.infinum.pokemon.dagger.components.AppComponent;

/**
 * Created by Ivan on 16/05/16.
 */
public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    protected void injectDependencies(AppComponent appComponent) {

    }

    @OnClick({R.id.pokedex, R.id.hacked_pokedex})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pokedex:
                break;
            case R.id.hacked_pokedex:
                startActivity(new Intent(this, PokemonListActivity.class));
                break;
        }
    }
}
