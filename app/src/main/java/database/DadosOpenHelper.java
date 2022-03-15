package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Globais.Globais;

import android.content.Context;

public class DadosOpenHelper extends SQLiteOpenHelper  {

    private static final int VERSION = 1;
    private static final String NM_BANCO = "banco";
    private Context context;

    public DadosOpenHelper(Context context) {
        super(context, NM_BANCO, null, VERSION);
        this.context = context;
    }
        @Override
        public void onCreate(SQLiteDatabase db) {

            try {

                StringBuilder sqlProjetos = new StringBuilder();
                sqlProjetos.append(" CREATE TABLE IF NOT EXISTS  ");
                sqlProjetos.append(tabelas.TB_PROJETOS);
                sqlProjetos.append("(");
                sqlProjetos.append(" id INTEGER PRIMARY KEY AUTOINCREMENT, ");
                sqlProjetos.append(" nome VARCHAR (30) NOT NULL, ");
                sqlProjetos.append(" dataInicio DATETIME, ");
                sqlProjetos.append(" dataFim DATETIME ");
                sqlProjetos.append(")");
                db.execSQL(sqlProjetos.toString());

                //StringBuilder sqlRequisitos = new StringBuilder();
                //sqlRequisitos.append(" CREATE TABLE IF NOT EXISTS  ");
                //sqlRequisitos.append(tabelas.TB_REQUISITOS);
                //sqlRequisitos.append("(");
                //sqlRequisitos.append(" id INTEGER PRIMARY KEY AUTOINCREMENT, ");
                //sqlRequisitos.append(" descricao VARCHAR (30) NOT NULL, ");
                //sqlRequisitos.append(" dataRegistro DATETIME, ");
                //sqlRequisitos.append(" nivel varchar(20), ");
               // sqlRequisitos.append(" duracao varchar (10) ");
               // sqlRequisitos.append(")");
                //db.execSQL(sqlRequisitos.toString());


            } catch (Exception ex) {
                Globais.exibirMensagem(context, "Error", "Erro");
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }