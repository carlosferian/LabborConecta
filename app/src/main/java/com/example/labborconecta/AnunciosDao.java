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

}