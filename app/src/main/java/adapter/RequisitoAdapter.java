package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.requisitos.CadastroProjetoActivity;
import com.example.requisitos.CadastroRequisitosActivity;
import com.example.requisitos.R;

import java.util.ArrayList;

import Modelo.Requisito;

public class RequisitoAdapter extends ArrayAdapter <Requisito> {
    private final Context context;
    private final ArrayList<Requisito> elementos;

    public RequisitoAdapter(Context context, ArrayList<Requisito> elementos){
        super(context, R.layout.requisito_lista, elementos);
        this.context = context;
        this.elementos = elementos;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        try{
            final Requisito objeto = elementos.get(position);

            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //toda vez que passa por um item da lista, os elementos são associados
            View rowView = inflater.inflate(R.layout.requisito_lista, parent, false);

            TextView lblnome = rowView.findViewById(R.id.lblNome_Requisito);

            lblnome.setText(String.valueOf(objeto.getDescricao()));



            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent tela = new Intent(context, CadastroRequisitosActivity.class);
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
