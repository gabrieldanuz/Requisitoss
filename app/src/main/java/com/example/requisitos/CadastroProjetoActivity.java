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

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.requisitos.databinding.CadastroprojetoActivityBinding;

import Globais.Globais;
import Modelo.Projeto;
import adapter.ProjetoAdapter;
import controller.ProjetoDAO;

public class CadastroProjetoActivity extends AppCompatActivity {

    EditText edtNomeProjeto, edtDataInicio, edtDataFim;
    Button btnExcluirProjeto;
    private ProjetoDAO projetoDAO;
    private int codigo;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastroprojeto_activity);

        edtNomeProjeto = findViewById(R.id.edtNomeProjeto);
        edtDataInicio = findViewById(R.id.edtDataInicio);
        edtDataFim = findViewById(R.id.edtDataFIm);
        btnExcluirProjeto = findViewById(R.id.btnEnviarProjeto);

        codigo = 0;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("id")) {

            codigo = bundle.getInt("id");
            projetoDAO = new ProjetoDAO(context);
            Projeto objeto = projetoDAO.buscar(codigo);
            preencheCampos(objeto);

        } else {
            btnExcluirProjeto.setVisibility(View.INVISIBLE);
        }

        btnExcluirProjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projetoDAO = new ProjetoDAO(context);
                boolean retorno = projetoDAO.excluir(codigo);
                if (retorno) {
                    Globais.exibirMensagem(context, "Excluir!", "Item excluido!");
                    finish();

                }


            }
        });


    }

    public boolean validaDados() {

        boolean retorno = true;
        String nome = edtNomeProjeto.getText().toString();

        if (Globais.isCampoVazio(nome)) {
            edtNomeProjeto.requestFocus();
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
    public boolean onOptionsItemSelected(MenuItem projeto) {

        int id = projeto.getItemId();
        switch (id) {

            case R.id.action_salvar:

                if (validaDados()) {

                    Projeto objeto = new Projeto();
                    objeto.setNome(edtNomeProjeto.getText().toString());
                    objeto.setDataInicio(edtDataInicio.getText().toString());
                    objeto.setDataFim(edtDataFim.getText().toString());


                    ProjetoDAO controller = new ProjetoDAO(context);

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


        return super.onOptionsItemSelected(projeto);
    }

    public void preencheCampos(Projeto objeto) {
        try {

            edtNomeProjeto.setText(String.valueOf(objeto.getNome()));
            edtDataInicio.setText(String.valueOf(objeto.getDataInicio()));
            edtDataFim.setText(String.valueOf(objeto.getDataFim()));

        } catch (Exception ex) {

            Globais.exibirMensagem(context, "ERRO", "FALHOU");
        }
    }
}