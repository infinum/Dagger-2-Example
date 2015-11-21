package co.infinum.pokemon.models;

import com.google.gson.annotations.SerializedName;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import android.text.TextUtils;

import java.io.Serializable;

import co.infinum.pokemon.database.PokemonDatabase;

/**
 * Created by dino on 20/03/15.
 */
@Table(databaseName = PokemonDatabase.NAME)
public class Pokemon extends BaseModel implements Serializable {

    public static final String NAME = "name";

    public static final String RESOURCE_URI = "resource_uri";

    public static final String HP = "hp";

    public static final String ATTACK = "attack";

    public static final String DEFENSE = "defense";

    public static final String HEIGHT = "height";

    public static final String WEIGHT = "weight";

    @Column
    @PrimaryKey(autoincrement = true)
    private long databaseId;

    @Column
    @SerializedName(NAME)
    private String name;

    @Column
    @SerializedName(RESOURCE_URI)
    private String resourceUri;

    @Column
    @SerializedName(HP)
    private int hp;

    @Column
    @SerializedName(ATTACK)
    private int attack;

    @Column
    @SerializedName(DEFENSE)
    private int defense;

    @Column
    @SerializedName(HEIGHT)
    private String height;

    @Column
    @SerializedName(WEIGHT)
    private String weight;

    public int getId() {
        try {
            String[] tokens = TextUtils.split(resourceUri, "/");
            String id = TextUtils.isEmpty(tokens[tokens.length - 1]) ? tokens[tokens.length - 2] : tokens[tokens.length - 1];
            return Integer.parseInt(id);
        } catch (Exception e) {
            return 0;
        }
    }

    public void setDatabaseId(long databaseId) {
        this.databaseId = databaseId;
    }

    public long getDatabaseId() {
        return databaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getHeight() {
        String heightStr = height;
        try {
            double centimeters;
            if (height.contains("'")) {
                String[] parts = height.split("'");
                centimeters = Double.parseDouble(parts[0]) / 0.032808;
                centimeters += Double.parseDouble(parts[1]) * 2.54;
            } else {
                centimeters = Double.parseDouble(height) / 0.032808;
            }
            heightStr = String.valueOf((int) centimeters) + " cm";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return heightStr;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        String weightStr = weight;
        try {
            double lbs;
            if (weight.contains("lbs")) {
                lbs = Double.parseDouble(weight.substring(0, weight.indexOf('l') - 1));
            } else {
                lbs = Double.parseDouble(weight);
            }
            int kg = (int) (lbs * 0.45359237);
            weightStr = String.valueOf(kg) + " kg";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return weightStr;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
