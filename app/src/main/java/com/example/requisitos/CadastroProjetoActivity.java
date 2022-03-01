package com.example.requisitos;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.requisitos.databinding.CadastroprojetoActivityBinding;

public class CadastroProjetoActivity extends AppCompatActivity {

    EditText edtNomeProjeto, edtDataInicio, edtDataFim;
    Button btnEnviarProjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastroprojeto_activity);

        edtNomeProjeto = findViewById(R.id.edtNomeProjeto);
        edtDataInicio = findViewById(R.id.edtDataInicio);
        edtDataFim = findViewById(R.id.edtDataFIm);
        btnEnviarProjeto = findViewById(R.id.btnEnviarProjeto);

    }
}