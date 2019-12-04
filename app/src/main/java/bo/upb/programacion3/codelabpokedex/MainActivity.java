package bo.upb.programacion3.codelabpokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import bo.upb.programacion3.codelabpokedex.model.User;
import bo.upb.programacion3.codelabpokedex.ui.login.UserLogged;

public class MainActivity extends AppCompatActivity {

    // Elementos de la pantalla
    private Toolbar toolbar; // Usaremos un toolbar personalizado, para agregar el icono del Drawer a la izquierda
    private ActionBarDrawerToggle drawerToggle; // El objeto del botón del drawer
    private DrawerLayout drawerLayout; // Nuestro DrawerLayout

    private ImageView imgUser; // imagen de Usuario
    private TextView nameUser; // nombre de Usuario


    private Gson gson = new Gson();
    private String json = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if (this.toolbar != null) {
            // Aqui configuramos nuestro Toolbar, con el ícono del Drawer a la izquierda
            this.toolbar.setTitle(R.string.main_activity_title);
            this.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
            drawerToggle.setDrawerIndicatorEnabled(false);
            drawerToggle.setHomeAsUpIndicator(R.drawable.icon_hamburger);
            drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START); // Podemos abrir y cerrar nuestro drawer programáticamente!!
                }
            });

            UserLogged userLogged = this.gson.fromJson(getIntent().getStringExtra(Constants.INTENT_KEY_USER_LOGGED), UserLogged.class);
            json = new Gson().toJson(userLogged);

            fillUserData(userLogged);
        }
    }

    // Esto ya saben!
    private void initViews() {
        this.toolbar = findViewById(R.id.toolbar);
        this.drawerLayout = findViewById(R.id.navigationDrawer);
        this.imgUser = findViewById(R.id.imgUser);
        this.nameUser = findViewById(R.id.nameUser);
    }



    private void fillUserData(UserLogged user) {
        this.imgUser.setImageResource(user.getImg());
        this.nameUser.setText(user.getUsername());
    }

    public void goToMyPokemons(View view) {
        Intent intent = new Intent(this, PokemonRecyclerActivity.class);
        intent.putExtra(Constants.INTENT_KEY_USER_LOGGED, json);
        startActivity(intent);
    }

    public void goToMyFavoritePokemons(View view) {
        Intent intent = new Intent(this, PokemonListActivity.class);
        intent.putExtra(Constants.INTENT_KEY_USER_LOGGED, json);
        startActivity(intent);
    }
}
