package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DepartamentoActivity extends AppCompatActivity {

    MiAdapter2 adapter;
    ListView lista;
    Button atras;
    TextView titulo;
    ArrayList<Trabajador> listado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemigos_datos);
        Intent intent = getIntent();
        String departamento = intent.getStringExtra("departamento");
        lista = findViewById(R.id.lista);
        atras = findViewById(R.id.atras);
        titulo = findViewById(R.id.titulo);
        titulo.setText(departamento);

        final int size = pruebas(intent.getStringExtra("trabajadores")).length;
        for (int i = 0; i < size; i++) {
            if (pruebas(intent.getStringExtra("trabajadores"))[i].departamento.toLowerCase().equals(departamento.toLowerCase())) {
                listado.add(pruebas(intent.getStringExtra("trabajadores"))[i]);
                adapter = new MiAdapter2(this, R.layout.enemigo_lista_layout_2, listado);
                lista.setAdapter(adapter);
            }
        Log.d("TAG", "onCreate: " + pruebas(intent.getStringExtra("trabajadores"))[i].departamento);
        }


        Log.d("TAG", "onCreate: " + pruebas(intent.getStringExtra("trabajadores"))[0].departamento);


        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private Trabajador[] pruebas(String json) {
        return new Gson().fromJson(json, Trabajador[].class);
    }
}