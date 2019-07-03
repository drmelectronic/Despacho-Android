package com.tcontur.despachotcontur.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.tcontur.despachotcontur.R;
import com.tcontur.despachotcontur.Utils.Util;


public class LoginActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    private EditText editUsername;
    private EditText editPassword;
    private EditText editClave;
    private CheckBox checkRecordar;
    private Button btnIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        bindUI();
        setCredentialsIfExist();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String clave = editClave.getText().toString();

                if (login(username, password, clave)) {
                    goToMain();
                    saveOnPreferences(username, password);
                }
            }
        });
    }

    private void setCredentialsIfExist() {
        String username = Util.getUsernamePrefs(prefs);
        String password = Util.getPasswordPrefs(prefs);
        String clave = Util.getClavePrefs(prefs);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            editUsername.setText(username);
            editPassword.setText(password);
        }
        if (!TextUtils.isEmpty(clave)) {
            editClave.setText(clave);
        }
    }

    private void bindUI() {
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editClave = findViewById(R.id.editClave);
        checkRecordar = findViewById(R.id.checkRecordar);
        btnIngresar = findViewById(R.id.btnIngresar);
    }

    private boolean login(String username, String password, String clave) {
        if (!isValidUsername(username)) {
            Toast.makeText(this, "Nombre de Usuario es inválido", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidPassword(password)) {
            Toast.makeText(this, "Password inválido", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidClave(clave)) {
            Toast.makeText(this, "Clave Personal inválida", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }

    }

    private void saveOnPreferences(String username, String password) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        if (checkRecordar.isChecked()) {
            editor.putString("clave", password);
        }
        editor.apply();
    }

    private boolean isValidUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    private boolean isValidPassword(String username) {
        return !TextUtils.isEmpty(username);
    }

    private boolean isValidClave(String username) {
        return !TextUtils.isEmpty(username);
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
