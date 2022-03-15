package com.example.requisitos;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import Globais.Globais;
import Modelo.Projeto;
import Modelo.Requisito;
import controller.ProjetoDAO;
import controller.RequisitoDAO;

public class CadastroRequisitosActivity extends AppCompatActivity {

    EditText edtDescricaoRequisitos, edtDataRegistroRequisitos, edtDuracaoRequisitos, edtNivelRequisitos;
    Button btnExcluirRequisitos;
    private int codigo;
    Context context;
    private RequisitoDAO requisitoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrorequisitos_activity);

        edtDescricaoRequisitos = findViewById(R.id.edtDescricaoRequisitos);
        edtDataRegistroRequisitos = findViewById(R.id.edtDataRegistroRequisitos);
        edtDuracaoRequisitos = findViewById(R.id.edtDuracaoRequisitos);

        btnExcluirRequisitos = findViewById(R.id.btnEnviarRequisitos);

        edtNivelRequisitos = findViewById(R.id.edtNivel);

        codigo = 0;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("id")) {

            codigo = bundle.getInt("id");
            requisitoDAO = new RequisitoDAO(context);
            Requisito objeto = requisitoDAO.buscar(codigo);
            preencheCampos(objeto);

        } else {
            btnExcluirRequisitos.setVisibility(View.INVISIBLE);
        }

        btnExcluirRequisitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requisitoDAO = new RequisitoDAO(context);
                boolean retorno = requisitoDAO.excluir(codigo);
                if (retorno) {
                    Globais.exibirMensagem(context, "Excluir!", "Item excluido!");
                    finish();

                }


            }
        });


    }

    public boolean validaDados() {

        boolean retorno = true;
        String descricao = edtDescricaoRequisitos.getText().toString();

        if (Globais.isCampoVazio(descricao)) {
            edtDescricaoRequisitos.requestFocus();
            retorno = false;
        }


        if (!retorno) {
            Globais.exibirMensagem(context, "Aviso", "Há campos inválidos ou em branco");
            return retorno;
        }

        return retorno;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucad, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem requisito) {

        int id = requisito.getItemId();
        switch (id) {

            case R.id.action_salvar:

                if (validaDados()) {

                    Requisito objeto = new Requisito();
                    objeto.setDescricao(edtDescricaoRequisitos.getText().toString());
                    objeto.setdataRegistro(edtDataRegistroRequisitos.getText().toString());
                    objeto.setDuracao(edtDuracaoRequisitos.getText().toString());


                    RequisitoDAO controller = new RequisitoDAO(context);

                    boolean ret;

                    if (codigo == 0) {
                        ret = controller.inserir(objeto);

                    } else {
                        objeto.setId(codigo);
                        ret = controller.alterar(objeto);

                    }

                } else {

                    break;
                }

            case R.id.action_cancelar:
                finish();
        }


        return super.onOptionsItemSelected(requisito);
    }

    public void preencheCampos(Requisito objeto) {
        try {

            edtDescricaoRequisitos.setText(String.valueOf(objeto.getDescricao()));

        } catch (Exception ex) {

            Globais.exibirMensagem(context, "ERRO", "FALHOU");
        }
    }
}