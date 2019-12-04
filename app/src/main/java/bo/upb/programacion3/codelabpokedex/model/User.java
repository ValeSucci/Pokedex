package bo.upb.programacion3.codelabpokedex.model;

public class User {

    private String name;

    private String password;

    private int[] favoritos;

    private int[] pokemons;

    private int img;

    public User(String name, String password, int[] favoritos, int[] pokemons, int img) {
        this.name = name;
        this.password = password;
        this.favoritos = favoritos;
        this.pokemons = pokemons;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int[] favoritos) {
        this.favoritos = favoritos;
    }

    public int[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(int[] pokemons) {
        this.pokemons = pokemons;
    }
}
