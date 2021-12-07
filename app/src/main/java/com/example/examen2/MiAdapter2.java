package com.example.examen2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MiAdapter2 extends ArrayAdapter {

    Context contexto;
    int itemlayout;
    ArrayList<Trabajador> trabajadorsObj;


    public MiAdapter2(@NonNull Context context, int resource, ArrayList<Trabajador> trabajadores) {
        super (context, resource, trabajadores);

        this.contexto = context;
        this.itemlayout = resource;
        this.trabajadorsObj = trabajadores;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from (contexto);
        View view = layoutInflater.inflate (itemlayout, parent, false);
        TextView text = view.findViewById (R.id.nombreEnemigo);
        TextView text2 = view.findViewById (R.id.puestoEnemigo);
        ImageButton borrar = view.findViewById (R.id.borrar);
        text.setText (trabajadorsObj.get(position).nombre);
        text2.setText (trabajadorsObj.get(position).puesto);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private String prueba(ArrayList<Trabajador> objectToJson){
        Gson gson = new Gson();
        String json = gson.toJson(objectToJson);
        return json;
    }

}
