package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import Modelo.Projeto;
import database.DadosOpenHelper;
import database.tabelas;
import Modelo.Projeto;

public class ProjetoDAO {

    private SQLiteDatabase conexao;
    private Context context;

    public ProjetoDAO(Context context) {
        DadosOpenHelper banco = new DadosOpenHelper(context);
        this.conexao = banco.getWritableDatabase();
        this.context = context;
    }
    public boolean inserir(Projeto projeto) {
        try{

            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", projeto.nome);
            contentValues.put("dataInicio", projeto.dataInicio);
            contentValues.put("dataFim", projeto.dataFim);


            long result = conexao.insertOrThrow(tabelas.TB_PROJETOS, null, contentValues);
            if(result > 0){
                return true;
            }else{
                return false;
            }

        }catch (SQLException ex){
            return false;
        }catch (Exception ex){
            return false;
        }
    }



    public boolean alterar (Projeto projeto) {

        try {


            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", projeto.nome);
            contentValues.put("dataInicio", projeto.dataInicio);
            contentValues.put("dataFim", projeto.dataFim);

            String[] parametros = new String[1];
            parametros[0] = String.valueOf(projeto.id);

            int ret = conexao.update("projetos", contentValues, "id = ?", parametros);
            if(ret > 0){
                return true;
            }else{
                return false;
            }

        } catch (Exception ex) {
            Log.e("ERRO", "Loucura mano");
            return false;
        }
    }
    public Projeto buscar(int id){
        try{

            Projeto objeto = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(tabelas.TB_PROJETOS);
            sql.append(" WHERE id = '"+ id +"'");

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if(resultado.moveToNext()){
                objeto = new Projeto();
                objeto.setId(resultado.getInt(resultado.getColumnIndexOrThrow("id")));
                objeto.setNome(resultado.getString(resultado.getColumnIndexOrThrow("nome")));
                objeto.setDataInicio(resultado.getString(resultado.getColumnIndexOrThrow("dataInicio")));
                objeto.setDataFim(resultado.getString(resultado.getColumnIndexOrThrow("dataFim")));
            }

            return objeto;


        }catch (Exception ex){
            return null;
        }
    }

    public boolean excluir(int id){
        try{

            String[] parametros = new String[1];
            parametros[0] = String.valueOf(id);

            conexao.delete(tabelas.TB_PROJETOS, "id = ?", parametros);

            return true;

        }catch (Exception ex){
            return false;
        }
    }


    public ArrayList<Projeto> lista(){

        ArrayList<Projeto> listagem = new ArrayList<>();
        try{

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(tabelas.TB_PROJETOS);

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if(resultado.moveToFirst()){

                Projeto objeto;
                do{
                    objeto = new Projeto();
                    objeto.setId(resultado.getInt(resultado.getColumnIndexOrThrow("id")));
                    objeto.setNome(resultado.getString(resultado.getColumnIndexOrThrow("nome")));
                    objeto.setDataInicio(resultado.getString(resultado.getColumnIndexOrThrow("dataInicio")));
                    objeto.setDataFim(resultado.getString(resultado.getColumnIndexOrThrow("dataFim")));

                    listagem.add(objeto);

                }while (resultado.moveToNext());

            }

            return listagem;

        }catch (Exception ex){
            return listagem;
        }
    }
}
