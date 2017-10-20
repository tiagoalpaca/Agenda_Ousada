package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tiago Avellar on 05/10/2017.
 */

public class BuscaContato extends AppCompatActivity {

    //variaveis dos campos em branco
    @BindView(R.id.txt_busca) EditText txt_busca;

    private String busca;

    BancoDados db;

    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button4) Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);
        this.db = new BancoDados(this);
    }



    @OnClick(R.id.button2)
    public void Busca(){
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

    @OnClick(R.id.button4)
    public void VoltaLogin(){
        Intent it = new Intent(BuscaContato.this, Login.class);
        startActivity(it);
    }

}
