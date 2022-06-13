package com.example.labborconecta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labborconecta.banco.Conexao;

public class CadastroActivity extends AppCompatActivity {

    TextView usuarioCad, senhaCad;
    Button cadastraUser;

    private UsuarioDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioCad= findViewById(R.id.usuarioCadastro);
        senhaCad=findViewById(R.id.senhaCadastro);
        cadastraUser= findViewById(R.id.cadastrarUsuarioBtn);
        dao= new UsuarioDao(this);
    }
    public void cadastrarUsuarioBanco(View view){

        Usuario usuario= new Usuario();
        usuario.setUsuario(usuarioCad.getText().toString());
        usuario.setSenha(senhaCad.getText().toString());
        dao.inserirUsuario(usuario);
        Toast.makeText(this, "Usuário inserido" ,Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}