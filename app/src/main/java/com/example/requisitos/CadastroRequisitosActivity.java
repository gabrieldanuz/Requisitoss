package com.example.requisitos;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class CadastroRequisitosActivity extends AppCompatActivity {

    EditText edtDescricaoRequisitos, edtDataRegistroRequisitos, edtDuracaoRequisitos;
    Spinner spnNivelRequisitos;
    Button btnEnviarRequisitos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrorequisitos_activity);

        edtDescricaoRequisitos = findViewById(R.id.edtDescricaoRequisitos);
        edtDataRegistroRequisitos = findViewById(R.id.edtDataRegistroRequisitos);
        edtDuracaoRequisitos = findViewById(R.id.edtDuracaoRequisitos);

        btnEnviarRequisitos = findViewById(R.id.btnEnviarRequisitos);

        spnNivelRequisitos = findViewById(R.id.spnNivelRequisitos);


    }
}