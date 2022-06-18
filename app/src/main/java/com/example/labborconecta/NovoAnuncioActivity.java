package com.example.labborconecta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NovoAnuncioActivity extends AppCompatActivity {

    TextView nome, telefone, ramo, corpoDoAnuncio;
    Button anunciarBtn;
    private AnunciosDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_anuncio);
        nome = findViewById(R.id.nomeNovoAnuncioTextView);
        telefone= findViewById(R.id.telefoneNovoAnuncioTextView);
        ramo = findViewById(R.id.ramoAtividadeTextView);
        corpoDoAnuncio= findViewById(R.id.corpoAnuncioEditText);
        anunciarBtn = findViewById(R.id.anunciarNovoBtn);
        dao = new AnunciosDao(this);

    }

    public void inserirNovoAnuncio(View v){
        Anuncios anuncios = new Anuncios();
        anuncios.setNome(nome.getText().toString());
        anuncios.setTelefone(telefone.getText().toString());
        anuncios.setRamo(ramo.getText().toString());
        anuncios.setCorpo(corpoDoAnuncio.getText().toString());
        dao.inserirAnuncio(anuncios);
        Toast.makeText( getApplicationContext(), "Anunciado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnuncioActivity.class);
        startActivity(intent);

    }



}