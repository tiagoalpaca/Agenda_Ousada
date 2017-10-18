package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tiago Avellar on 05/10/2017.
 */

public class BuscaContato extends AppCompatActivity {

    //variaveis dos campos em branco
    private EditText txt_busca;
    private String busca;

    BancoDados db;
    private Button button2, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        txt_busca = (EditText) findViewById(R.id.txt_busca);

        Button button2 = (Button) findViewById(R.id.button18);
        Button button4 = (Button) findViewById(R.id.button6);
        this.db = new BancoDados(this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                busca = txt_busca.getText().toString();



                if (txt_busca.length() != 0 && db.BuscaCliente(new Cliente(busca)) != "Nao encontrado") {


                    Toast.makeText(BuscaContato.this, "Cadastro Encontrado", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(BuscaContato.this, BuscaContato.class);
                    startActivity(it);

                } else {
                    Toast.makeText(BuscaContato.this, "Contato nao encontrado ", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(BuscaContato.this, BuscaContato.class);
                    startActivity(it);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(BuscaContato.this, Login.class);
                startActivity(it);

            }
        });
    }

}
