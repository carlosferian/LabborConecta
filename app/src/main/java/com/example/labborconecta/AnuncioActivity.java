package com.example.labborconecta;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labborconecta.banco.Conexao;

import java.util.ArrayList;

//view courses
public class AnuncioActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private AnunciosAdapter adapter;
    private ArrayList <Anuncios> anuncia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio);
        recyclerView = findViewById(R.id.anunciosRecyclerView);

        adapter= new AnunciosAdapter(AnuncioActivity.this, atualizaAnuncios());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(
            AnuncioActivity.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void adicionarAnuncio(View v){
        Intent intent = new Intent(this, NovoAnuncioActivity.class);
        startActivity(intent);

    }
    public ArrayList<Anuncios> atualizaAnuncios(){
        anuncia = new ArrayList<Anuncios>();
        Conexao conexao = new Conexao(AnuncioActivity.this);
        SQLiteDatabase database = conexao.getReadableDatabase();
        Cursor cursor = database.query("anuncios", null, null,
                 null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String nome= cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String telefone= cursor.getString(cursor.getColumnIndexOrThrow("telefone"));
                String ramo= cursor.getString(cursor.getColumnIndexOrThrow("ramo"));
                String corpo= cursor.getString(cursor.getColumnIndexOrThrow("corpo"));
                anuncia.add(new Anuncios(id, nome, telefone, ramo, corpo));

            }while(cursor.moveToNext());
        }

        return anuncia;
    }

}