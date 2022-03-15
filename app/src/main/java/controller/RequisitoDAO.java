package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import Modelo.Requisito;
import database.DadosOpenHelper;
import database.tabelas;

public class RequisitoDAO {
    private SQLiteDatabase conexao;
    private Context context;

    public RequisitoDAO(Context context) {
        DadosOpenHelper banco = new DadosOpenHelper(context);
        this.conexao = banco.getWritableDatabase();
        this.context = context;
    }
    public boolean inserir(Requisito requisito) {
        try{

            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", requisito.descricao);
            contentValues.put("dataRegistro", requisito.dataRegistro );
            contentValues.put("nivel", requisito.nivel);
            contentValues.put("dataFim", requisito.duracao);


            long result = conexao.insertOrThrow(tabelas.TB_REQUISITOS, null, contentValues);
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



    public boolean alterar (Requisito requisito) {

        try {


            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", requisito.descricao);
            contentValues.put("dataInicio", requisito.dataRegistro);
            contentValues.put("dataFim", requisito.duracao);
            contentValues.put("nivel", requisito.nivel);

            String[] parametros = new String[1];
            parametros[0] = String.valueOf(requisito.id);

            int ret = conexao.update("requisitos", contentValues, "id = ?", parametros);
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
    public Requisito buscar(int id){
        try{

            Requisito objeto = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(tabelas.TB_REQUISITOS);
            sql.append(" WHERE id = '"+ id +"'");

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if(resultado.moveToNext()){
                objeto = new Requisito();
                objeto.setId(resultado.getInt(resultado.getColumnIndexOrThrow("id")));
                objeto.setDescricao(resultado.getString(resultado.getColumnIndexOrThrow("descricao")));
                objeto.setdataRegistro(resultado.getString(resultado.getColumnIndexOrThrow("dataRegistro")));
                objeto.setDuracao(resultado.getString(resultado.getColumnIndexOrThrow("duracao")));
                objeto.setNivel(resultado.getString(resultado.getColumnIndexOrThrow("nivel")));
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

            conexao.delete(tabelas.TB_REQUISITOS, "id = ?", parametros);

            return true;

        }catch (Exception ex){
            return false;
        }
    }


    public ArrayList<Requisito> lista(){

        ArrayList<Requisito> listagem = new ArrayList<>();
        try{

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ");
            sql.append(tabelas.TB_REQUISITOS);

            Cursor resultado = conexao.rawQuery(sql.toString(), null);
            if(resultado.moveToFirst()){

                Requisito objeto;
                do{
                    objeto = new Requisito();
                    objeto.setId(resultado.getInt(resultado.getColumnIndexOrThrow("id")));
                    objeto.setDescricao(resultado.getString(resultado.getColumnIndexOrThrow("descricao")));
                    objeto.setdataRegistro(resultado.getString(resultado.getColumnIndexOrThrow("dataRegistro")));
                    objeto.setDuracao(resultado.getString(resultado.getColumnIndexOrThrow("duracao")));
                    objeto.setNivel(resultado.getString(resultado.getColumnIndexOrThrow("nivel")));

                    listagem.add(objeto);

                }while (resultado.moveToNext());

            }

            return listagem;

        }catch (Exception ex){
            return listagem;
        }
    }
}
