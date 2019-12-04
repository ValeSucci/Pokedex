package bo.upb.programacion3.codelabpokedex.ui.login;

public class UserLogged {
    private String username;

    private int[] favoritos;

    private int[] pokemons;

    private int img;


    public UserLogged(String username, int[] favoritos, int[] pokemons, int img) {
        this.username = username;
        this.favoritos = favoritos;
        this.pokemons = pokemons;
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public int[] getFavoritos() {
        return favoritos;
    }

    public int[] getPokemons() {
        return pokemons;
    }

    public int getImg() {
        return img;
    }
}
