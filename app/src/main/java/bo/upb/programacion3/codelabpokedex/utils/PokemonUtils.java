package bo.upb.programacion3.codelabpokedex.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.model.Pokemon;

public class PokemonUtils {

    /**
     * Get list of pokemons
     *
     * @return List of pokemons in the pokedex
     */
    public List<Pokemon> getPokemons(int[] ids) {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, "Electric"));
        pokemons.add(new Pokemon(2, "Bulbasaur", R.drawable.bulbasaur, "Grass"));
        pokemons.add(new Pokemon(3, "Charmander", R.drawable.charmander, "Fire"));
        pokemons.add(new Pokemon(4, "Squirtle", R.drawable.squirtle, "Water"));
        pokemons.add(new Pokemon(5, "Snorlax", R.drawable.snorlax, "Normal"));
        pokemons.add(new Pokemon(6, "ButterFree", R.drawable.butterfree, "Bug"));
        pokemons.add(new Pokemon(7, "Ekans", R.drawable.ekans, "Poison"));
        pokemons.add(new Pokemon(8, "Pidgey", R.drawable.pidgey, "Normal"));
        pokemons.add(new Pokemon(9, "Rattata", R.drawable.rattata, "Normal"));
        pokemons.add(new Pokemon(10, "Sandshrew", R.drawable.sandshrew, "Ground"));
        pokemons.add(new Pokemon(11, "Venonat", R.drawable.venonat, "Bug"));
        pokemons.add(new Pokemon(12, "Zubat", R.drawable.zubat, "Poison"));
        pokemons.add(new Pokemon(13, "Cubone", R.drawable.cubone, "Ground"));
        pokemons.add(new Pokemon(14, "Jigglypuff", R.drawable.jigglypuff, "Fairy"));
        pokemons.add(new Pokemon(15, "Meowth", R.drawable.meowth, "Normal"));
        pokemons.add(new Pokemon(16, "Lapras", R.drawable.lapras, "Water"));
        pokemons.add(new Pokemon(17, "Onix", R.drawable.onix, "Ground"));
        pokemons.add(new Pokemon(18, "Psyduck", R.drawable.psyduck, "Water"));
        pokemons.add(new Pokemon(19, "Togepi", R.drawable.togepi, "Fairy"));
        pokemons.add(new Pokemon(20, "Magikarp", R.drawable.magikarp, "Water"));
        pokemons.add(new Pokemon(21, "Arcanine", R.drawable.arcanine, "Fire"));
        pokemons.add(new Pokemon(22, "Geodude", R.drawable.geodude, "Ground"));

        List<Pokemon> pokemonsRes = new ArrayList<>();
        for(int i: ids) {
            pokemonsRes.add(pokemons.get(i-1));
        }
        return pokemonsRes;
    }
}
