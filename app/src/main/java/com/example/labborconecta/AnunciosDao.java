package com.example.labborconecta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.labborconecta.banco.Conexao;

import java.util.ArrayList;

public class AnunciosDao {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AnunciosDao(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public AnunciosDao() {

    }

    public long inserirAnuncio(Anuncios anuncio) {
        ContentValues values = new ContentValues();
        values.put("nome", anuncio.getNome());
        values.put("telefone", anuncio.getTelefone());
        values.put("ramo", anuncio.getRamo());
        values.put("corpo", anuncio.getCorpo());
        return banco.insert("anuncios", null, values);
    }



    public ArrayList<Anuncios> obterAnuncios() {
        SQLiteDatabase database = conexao.getReadableDatabase();
        Cursor cursor = database.query("anuncios", null, null,
                null, null, null, null);
        ArrayList<Anuncios> anuncios = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                long id =cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String nome= cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String telefone= cursor.getString(cursor.getColumnIndexOrThrow("telefone"));
                String corpo= cursor.getString(cursor.getColumnIndexOrThrow("corpo"));
                anuncios.add(new Anuncios(id, nome, telefone, corpo));


            }while(cursor.moveToNext());
        }
        database.close();

        return anuncios;
    }
}