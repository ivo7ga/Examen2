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

public class MiAdapter extends ArrayAdapter {

    Context contexto;
    int itemlayout;
    ArrayList<String> departamentos;
    ArrayList<Trabajador> trabajadorsObj;


    public MiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects, ArrayList<Trabajador> trabajadores) {
        super (context, resource, objects);

        this.contexto = context;
        this.itemlayout = resource;
        this.departamentos = objects;
        this.trabajadorsObj = trabajadores;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from (contexto);
        View view = layoutInflater.inflate (itemlayout, parent, false);
        TextView text = view.findViewById (R.id.nombreEnemigo);
        ImageButton borrar = view.findViewById (R.id.borrar);
        text.setText (departamentos.get(position));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                Intent intent = new Intent (contexto, DepartamentoActivity.class);

                intent.putExtra ("trabajadores", prueba(trabajadorsObj));
                intent.putExtra ("departamento", departamentos.get(position));
//                intent.putExtra ("Ofensa", trabajadors.get (position).departamento);
                contexto.startActivity (intent);
                notifyDataSetChanged ();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v != null){
                    departamentos.remove(position);
                    notifyDataSetChanged();
                }
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
