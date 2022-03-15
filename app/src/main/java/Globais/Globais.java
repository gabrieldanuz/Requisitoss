package Globais;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;

public class Globais {
    public static boolean isCampoVazio (String valor) {

        //return true se estiver vazio
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return  resultado;
    }
    public static void exibirMensagem(Context context, String titulo, String mensagem){
        try{

            AlertDialog.Builder dialogo = new AlertDialog.Builder(context);
            dialogo.setTitle(titulo);
            dialogo.setMessage(mensagem);
            dialogo.setNeutralButton("OK", null);

            dialogo.show();

        }catch (Exception ex){

        }
    }
}
