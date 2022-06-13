package com.example.labborconecta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView usuario, password;
    Button login, cadastrar;
    UsuarioDao dao = new UsuarioDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario= findViewById(R.id.usuarioLogin);
        password=findViewById(R.id.passwordLogin);
        login=findViewById(R.id.loginBtn);
        cadastrar=findViewById(R.id.cadastraBtn);
    }

    public void loginOnClick(View view){
        boolean login=dao.loginUsuario(usuario.getText().toString(), password.getText().toString());
        if(login){
            Intent intent= new Intent(this, AnuncioActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuário não cadastrado", Toast.LENGTH_LONG).show();
        }

    }
    public void cadastrarOnClick(View view){

        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }
}