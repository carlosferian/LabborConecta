package com.example.labborconecta;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.labborconecta.banco.Conexao;

public class UsuarioDao {

    private Conexao conexao;


    public UsuarioDao(Context context){
        conexao= new Conexao(context);

    }

    public long inserirUsuario(Usuario usuario){
        SQLiteDatabase db= conexao.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("usuario", usuario.getUsuario());
        values.put("senha", usuario.getSenha());
        return db.insert("usuario", null, values);
    }

    public boolean loginUsuario(String usuario, String password){
        SQLiteDatabase db= conexao.getReadableDatabase();
        String query = "Select usuario,senha FROM usuario WHERE usuario=? AND senha=?";
        String [] selection={usuario, password};
        try {
            Cursor cursor = db.rawQuery(query, selection);
            cursor.moveToFirst();

            if(cursor.getCount()>0){
                Log.i("Passou no if", "loginUsuario: paparara ");
                return true;
            }
            cursor.close();
            db.close();

            return false;
        }catch (Exception e){
            Log.d("Erro", "loginUsuario() returned: " + true);
            e.printStackTrace();
        }

        return true;
    }


}
