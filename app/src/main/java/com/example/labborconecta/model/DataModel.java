package com.example.labborconecta.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.labborconecta.Anuncios;
import com.example.labborconecta.AnunciosDao;
import com.example.labborconecta.banco.Conexao;

import java.util.ArrayList;

public class DataModel {




    private static DataModel instance = new DataModel();



    private DataModel(){

    }


    public static DataModel getInstance(){
        return instance;
    }
    private ArrayList<Anuncios> anuncios;
    private Conexao database;






}

