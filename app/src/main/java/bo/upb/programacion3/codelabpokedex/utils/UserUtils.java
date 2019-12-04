package bo.upb.programacion3.codelabpokedex.utils;

import java.util.ArrayList;
import java.util.List;

import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.model.User;

public class UserUtils {

    /**
     * Get list of users
     *
     * @return List of user in the pokedex
     */
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        int[] arrFavAsh = {1,2,3,4,5,6};
        int[] arrAsh = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] arrFavJames = {7,8,9,13,15,22};
        int[] arrJames = {5,6,7,8,10,11,13,15,16,22};
        int[] arrFavJessie = {12,13,15,19,20};
        int[] arrJessie = {10,11,12,13,15,18,19,20,21};
        int[] arrFavBrock = {2,3,7,8,9,16,17};
        int[] arrBrock = {2,3,6,7,8,9,10,11,12,17,18,19,20,21};

        users.add(new User("Ash","ash123",arrFavAsh,arrAsh,R.drawable.ash_ketchum));
        users.add(new User("James","james123",arrFavJames,arrJames,R.drawable.james));
        users.add(new User("Jessie","jessie123",arrFavJessie,arrJessie,R.drawable.jessie));
        users.add(new User("Brock","brock123",arrFavBrock,arrBrock,R.drawable.brock));
        return users;
    }
}
