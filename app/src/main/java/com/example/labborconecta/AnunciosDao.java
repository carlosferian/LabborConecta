package com.example.labborconecta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        int count = (int) banco.insert("anuncios", null, values);
        banco.close();
        return count;

    }

    public int removerAnuncio(long id){
        String idAnuncio = String.valueOf(id);
        Log.d("teste", idAnuncio);
        int count = banco.delete("anuncios", "id=?", new String[]{idAnuncio});
        banco.close();
        return count;
    }
}