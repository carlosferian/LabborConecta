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

}
