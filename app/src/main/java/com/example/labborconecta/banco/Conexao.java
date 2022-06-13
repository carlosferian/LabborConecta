package com.example.labborconecta.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.labborconecta.Anuncios;
import com.example.labborconecta.AnunciosDao;

import java.util.ArrayList;

//contact database
public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version= 1;



    public Conexao(@Nullable Context context) {

        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists usuario (id integer not null primary key autoincrement," +
                "usuario varchar (50),senha varchar (50) )");

        db.execSQL("create table if not exists anuncios (id integer not null primary key autoincrement," +
                "nome varchar(50),telefone varchar (50), ramo varchar (50), corpo varchar (250) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long criarContatoNoBanco(Anuncios anuncios){
        ContentValues values= new ContentValues();
        values.put("nome", anuncios.getNome());
        values.put("telefone", anuncios.getTelefone());
        values.put("ramo", anuncios.getRamo());
        values.put("corpo", anuncios.getCorpo());
        SQLiteDatabase database= getWritableDatabase();
        long id= database.insert("anuncios", null, values);
        database.close();
        return id;
    }

    public ArrayList<Anuncios> obterAnuncios() {
        //SQLiteDatabase database = getReadableDatabase();
        //Cursor cursor = database.query("anuncios", null, null,
               // null, null, null, null);
        ArrayList<Anuncios> anuncios = new ArrayList<>();
        //if(cursor.moveToFirst()){
          //  do{
               // long id =cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                //String nome= cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                //String telefone= cursor.getString(cursor.getColumnIndexOrThrow("telefone"));
                //String ramo= cursor.getString(cursor.getColumnIndexOrThrow("ramo"));
                //String corpo= cursor.getString(cursor.getColumnIndexOrThrow("corpo"));
                long id= 1;
                String nome= "pedro";
                String telefone= "3325121";
                String ramo= "putaria";
                String corpo= " nasnsjdjds sdjsjds sjdsdjs ds ";

                Log.i("obtendo", "obterAnuncios:" + id);
                Log.i("obtendo", "obterAnuncios: " + nome);
                Log.i("obtendo", "obterAnuncios: " + telefone);
                Log.i("obtendo", "obterAnuncios: " + ramo);
                Log.i("obtendo", "obterAnuncios: " + corpo);

                anuncios.add(new Anuncios(id, nome, telefone,ramo,  corpo));


           // }while(cursor.moveToNext());
       // }
       // database.close();

        return anuncios;
    }
}
