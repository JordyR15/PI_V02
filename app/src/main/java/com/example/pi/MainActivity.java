package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Adaptador.PersonaAdapter;
import Modelos.Persona;
import Utiles.ErrorLog;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailEditText = findViewById(R.id.email_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mLoginButton = findViewById(R.id.login_button);

        // Agregar el listener al botón de inicio de sesión
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }

    Persona persona;

    PersonaAdapter personaAdaptador;

    public void consulta(View view){
        TextView txtLista2=(TextView)findViewById(R.id.txtLista);
        txtLista2.setText("Hola");
        persona = new Persona();
        persona.setNombre((findViewById(R.id.nombreTextView)).toString());
        persona.setCorreoElectronico((findViewById(R.id.nombreTextView)).toString());


        personaAdaptador = new PersonaAdapter();

        //txtLista2.setText(personaAdaptador.Consulta(persona));

    }

    private void iniciarSesion() {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        // Validar si los campos están vacíos
        if (TextUtils.isEmpty(email)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.setError("Ingresa tu contraseña");
            return;
        }

        // Verificar si el correo electrónico y la contraseña son correctos
        if (email.equals("usuario@example.com") && password.equals("contraseña")) {
            // La autenticación es exitosa, redirigir al usuario a la actividad principal
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
