package com.example.requisitos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.requisitos.databinding.ActivityListaRequisitosBinding;

public class ListaRequisitosactivity extends AppCompatActivity {

    ListView rcvLista;
    FloatingActionButton btnAdd;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_requisitos);

        context = ListaRequisitosactivity.this;
        rcvLista = findViewById(R.id.ltvRequisitos);
        btnAdd = findViewById(R.id.btnAddRequisitos);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(context, CadastroRequisitosActivity.class);
                startActivity(it);

            }

        });
    }
}