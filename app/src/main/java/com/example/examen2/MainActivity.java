package com.example.examen2;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, puesto, departamento;
    Button agregar;
    boolean oknombre = false;
    boolean oksexo = false;
    ListView lista;
    ArrayList<Trabajador> listado = new ArrayList<>();
    ArrayList<String> departamentos = new ArrayList<>();
    MiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = findViewById(R.id.nombreET);
        puesto = findViewById(R.id.puestoET);
        departamento = findViewById(R.id.departamentoET);
        agregar = findViewById(R.id.anadir);
        lista = findViewById(R.id.lista);

        agregar.setOnClickListener(this);
    }

    @Override
    protected void onResume() {

        resetearCampos();
        oknombre = false;
        oksexo = false;
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        //lo que debe hacer el botón cuando es pulsado

        //Validaciones, compruebo que no estén vacíos los tres campos, aunque en el enunciado solo se pide verificar nombre y sexo
        if (nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
        } else if (puesto.getText().toString().isEmpty()) {
            Toast.makeText(this, "El puesto no puede estar vacío", Toast.LENGTH_SHORT).show();

        } else if (departamento.getText().toString().isEmpty()) {
            Toast.makeText(this, "El departamento no puede estar vacío", Toast.LENGTH_SHORT).show();
        } else if (departamento.getText().toString().equalsIgnoreCase("marketing") || (departamento.getText().toString().equalsIgnoreCase("desarrollo") || departamento.getText().toString().equalsIgnoreCase("direccion") || departamento.getText().toString().equalsIgnoreCase("ventas"))){
            Toast.makeText(this, "Todo correcto", Toast.LENGTH_SHORT).show();
//Introduciendo el enemigo a la lista si se cumplen las condiciones
            //1 creo la instancia del enemigo
            Trabajador nuevoTrabajador = new Trabajador(nombre.getText().toString(), puesto.getText().toString(), departamento.getText().toString());

            //añadiendo a la lista con el adapter
            listado.add(nuevoTrabajador);
            adapter = new MiAdapter(this, R.layout.enemigo_lista_layout, departamentos, listado);
            resetearCampos();
            final int size = listado.size();
            for (int i = 0; i < size; i++) {
                if (listado.get(i).departamento.toLowerCase().equals("desarrollo")) {
                    Log.d("TAG", "onClick: hay un objeto desarrollo");
                    if (!departamentos.contains("Desarrollo")) departamentos.add("Desarrollo");
                }
                if (listado.get(i).departamento.toLowerCase().equals("ventas")) {
                    Log.d("TAG", "onClick: hay un objeto desarrollo");
                    if (!departamentos.contains("Ventas")) departamentos.add("Ventas");
                }
                if (listado.get(i).departamento.toLowerCase().equals("marketing")) {
                    Log.d("TAG", "onClick: hay un objeto desarrollo");
                    if (!departamentos.contains("Marketing")) departamentos.add("Marketing");
                }
                if (listado.get(i).departamento.toLowerCase().equals("direccion")) {
                    Log.d("TAG", "onClick: hay un objeto desarrollo");
                    if (!departamentos.contains("Direccion")) departamentos.add("Direccion");
                }
                Log.d("TAG", "onClick: " + listado.get(i).departamento);
            }
            lista.setAdapter(adapter);

            hideKeyboard(this);
        }

    }

    public void resetearCampos() {
        nombre.setText("");
        departamento.setText("");
        puesto.setText("");
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}