package com.example.ejercicio3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejercicio3.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class Adaptador extends BaseAdapter implements Serializable {
    Context contexto ;
    ArrayList<Pokemon> datos;
    private static LayoutInflater inflater= null;

    public Adaptador(Context contexto, ArrayList<Pokemon> datos) {
        this.contexto = contexto;
        this.datos = datos;
        inflater =(LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        //return null;
        return datos.get(i); }

    @Override
    public long getItemId(int i) {
        return datos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView tvNombre = vista.findViewById(R.id.tvNombre);
        TextView tvNumero = vista.findViewById(R.id.tvNumero);



        tvNombre.setText(datos.get(i).getName());
        tvNumero.setText(datos.get(i).getNumero());





        return vista;

    }
}
