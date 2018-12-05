package com.mdevesa.activitats.activitat5_persistencia_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    EditText user;
    EditText email;
    EditText nom;
    EditText cognom;
    CheckBox newsletter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("FitxerPreferences", MODE_PRIVATE);

        //Associacio dels elements
        user = (EditText) findViewById(R.id.et_user);
        email = (EditText) findViewById(R.id.et_email);
        nom = (EditText) findViewById(R.id.et_nom);
        cognom = (EditText) findViewById(R.id.et_cognom);
        newsletter = (CheckBox) findViewById(R.id.checkBox);


        //Carregar les dades guardades
        user.setText(prefs.getString("user",""));
        email.setText(prefs.getString("email",""));
        nom.setText(prefs.getString("nom",""));
        cognom.setText(prefs.getString("cognom",""));
        if(prefs.getBoolean("newsletter", false) == true){
            newsletter.setChecked(true);
        }
        else if(prefs.getBoolean("newsletter",false) == false){
            newsletter.setChecked(false);
        }

    }
    @Override
    protected void onStop(){
        super.onStop();

        //Guardar els valors
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("user",user.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("nom",nom.getText().toString());
        editor.putString("cognom",cognom.getText().toString());
        if(newsletter.isChecked()) {
            editor.putBoolean("newsletter",true);
        }
        else{
            editor.putBoolean("newsletter",false);
        }
        editor.commit();

    }
}
