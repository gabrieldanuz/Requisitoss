package com.example.requisitos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    CardView cardViewCadastroProjeto, cardViewCadastroRequisitos;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        cardViewCadastroProjeto = findViewById(R.id.cardViewCadastroProjeto);
        cardViewCadastroRequisitos = findViewById(R.id.cardViewCadastroRequisitos);

        context = MenuActivity.this;

        cardViewCadastroProjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(context, ListaProjetosactivity.class);
                startActivity(it);
            }
        });

        cardViewCadastroRequisitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(context, ListaRequisitosactivity.class);
                startActivity(it);
            }
        });
    }
}
