package bo.upb.programacion3.codelabpokedex.ui.login;


import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import bo.upb.programacion3.codelabpokedex.Constants;
import bo.upb.programacion3.codelabpokedex.MainActivity;
import bo.upb.programacion3.codelabpokedex.R;
import bo.upb.programacion3.codelabpokedex.model.User;
import bo.upb.programacion3.codelabpokedex.utils.UserUtils;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG = LoginActivity.class.getSimpleName();


    private Context context;

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button sendButton;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Log.e(LOG, "onCreate");
        //viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        this.context = this;
        initUI();
        initEvents();

        //emailEditText.setText("cualquiera@pumatiti.com");
        //passwordEditText.setText("noImporta");

    }

    private void initUI() {
        this.emailEditText = findViewById(R.id.emailEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.sendButton = findViewById(R.id.sendButton);
    }

    private void initEvents() {
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User user = null;
                if (!email.isEmpty() && !password.isEmpty()) {
                    final List<User> usersList = UserUtils.getUsers();
                    for(User u: usersList) {
                        if(u.getName().equals(email)) {
                            user = u;
                        }
                    }
                    if(user != null) {
                        if(user.getPassword().equals(password)){
                            UserLogged userLogged = new UserLogged(user.getName(),user.getFavoritos(),user.getPokemons(),user.getImg());
                            String json = new Gson().toJson(userLogged);

                            Intent intent = new Intent(context, MainActivity.class);
                            intent.putExtra(Constants.INTENT_KEY_USER_LOGGED, json);
                            startActivity(intent);

                        } else {
                            Toast.makeText(context,
                                    R.string.error_login_failed,
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    } else {
                        emailEditText.setError(getString(R.string.error_invalid_email));
                    }
                } else {
                    Toast.makeText(context,
                            R.string.error_empty,
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

}
