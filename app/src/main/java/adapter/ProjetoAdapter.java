package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.requisitos.CadastroProjetoActivity;
import com.example.requisitos.R;

import java.util.ArrayList;

import Modelo.Projeto;

public class ProjetoAdapter extends ArrayAdapter <Projeto> {
    private final Context context;
    private final ArrayList<Projeto> elementos;

    public ProjetoAdapter(Context context, ArrayList<Projeto> elementos){
        super(context, R.layout.projeto_lista, elementos);
        this.context = context;
        this.elementos = elementos;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        try{
            final Projeto objeto = elementos.get(position);

            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //toda vez que passa por um item da lista, os elementos são associados
            View rowView = inflater.inflate(R.layout.projeto_lista, parent, false);

            TextView lblnome = rowView.findViewById(R.id.lblNome_Projeto);

            lblnome.setText(String.valueOf(objeto.getNome()));



            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent tela = new Intent(context, CadastroProjetoActivity.class);
                    tela.putExtra("id", objeto.getId());
                    context.startActivity(tela);
                }
            });

            return rowView;

        }catch (Exception ex){
            return null;
        }

    }
}
