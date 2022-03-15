package com.example.requisitos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.requisitos.databinding.ActivityListaProjetosBinding;

import java.util.ArrayList;

import Modelo.Projeto;
import adapter.ProjetoAdapter;
import controller.ProjetoDAO;

public class ListaProjetosactivity extends AppCompatActivity {

    ListView rcvLista;
    FloatingActionButton btnAdd;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_projetos);

        context = ListaProjetosactivity.this;
        rcvLista = findViewById(R.id.ltvProjetos);
        btnAdd = findViewById(R.id.btnAddProjetos);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(context, CadastroProjetoActivity.class);
                startActivity(it);

            }

        });
    }@Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){

        try{

            //buscar todos os usuarios e preencher em um List
            ProjetoDAO controller = new ProjetoDAO(context);
            ArrayList<Projeto> lista = controller.lista();
            if(lista != null){


                ArrayAdapter adapter = new ProjetoAdapter(context, lista);

                rcvLista.setAdapter(adapter);

            }

        }catch (Exception ex){


        }
    }
}