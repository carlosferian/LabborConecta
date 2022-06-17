package com.example.labborconecta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnunciosAdapter extends RecyclerView.Adapter<AnunciosAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Anuncios> listaAnuncios;


    public AnunciosAdapter(Context context, ArrayList<Anuncios> listaAnuncios){
        this.context= context;
        this.listaAnuncios=listaAnuncios;

    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeRTextView, telefoneRTextview, ramoRTextView, corpoRTextView;
        Anuncios anuncio;

        public ViewHolder(View itemView){            
            super(itemView);
            nomeRTextView= itemView.findViewById(R.id.nomeRTextView);
            telefoneRTextview= itemView.findViewById(R.id.telefoneRTextView);
            ramoRTextView=itemView.findViewById(R.id.ramoRTextView);
            corpoRTextView= itemView.findViewById(R.id.corpoREditTextMulti);
            itemView.findViewById(R.id.deletar).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Log.d("demo", "onClick: item cliked " + anuncio.getID());
                    AnunciosDao dao = new AnunciosDao();
                    dao.removerAnuncio(anuncio.getID());
                }
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.anuncio_recycle_view,
                    parent, false);
            ViewHolder viewHolder= new ViewHolder(view);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Anuncios anuncios= listaAnuncios.get(position);
        holder.nomeRTextView.setText(anuncios.getNome());
        holder.telefoneRTextview.setText(anuncios.getTelefone());
        holder.ramoRTextView.setText(anuncios.getRamo());
        holder.corpoRTextView.setText(anuncios.getCorpo());
        holder.anuncio = anuncios;
    }

    @Override
    public int getItemCount() {
        return listaAnuncios.size();
    }
}


