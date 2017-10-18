package com.example.tiagoavellar.agenda;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText.*;
import android.widget.Spinner;
import android.widget.*;

public class Cadastro extends AppCompatActivity {

    //variaveis dos campos em branco
    private EditText txt_endereco;
    private EditText txt_email;
    private EditText txt_nome;
    private EditText txt_telefone;
    private EditText txt_obs;
    private String Nome, Email,Endereco,Telefone,Observacao;

    BancoDados db;
    private Button button18, button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txt_nome = (EditText) findViewById(R.id.txt_nome);
        txt_endereco = (EditText) findViewById(R.id.txt_endereco);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_telefone = (EditText) findViewById(R.id.txt_telefone);
        txt_obs = (EditText) findViewById(R.id.txt_obs);

        Button button18 = (Button) findViewById(R.id.button18);
        Button button6 = (Button) findViewById(R.id.button6);
        this.db = new BancoDados(this);

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Nome = txt_nome.getText().toString();
                Endereco = txt_endereco.getText().toString();
                Email = txt_email.getText().toString();
                Telefone = txt_telefone.getText().toString();
                Observacao = txt_obs.getText().toString();


                if (txt_nome.length() != 0 && txt_endereco.length() != 0 && txt_email.length() != 0 && txt_telefone.length() != 0 ) {
                    db.CadastraCliente(new Cliente(Nome, Endereco, Email, Telefone,Observacao));

                    Toast.makeText(Cadastro.this, "Cadastro Salvo", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(Cadastro.this, Login.class);
                    startActivity(it);

                } else {
                    Toast.makeText(Cadastro.this, "Falta Dados para o Cadastro ", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(Cadastro.this, Cadastro.class);
                    startActivity(it);
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Cadastro.this, Login.class);
                startActivity(it);

            }
        });
    }

}
    /*



    //Teste do Crud
        //adicionando
        db.addCliente(new Cliente("Tiago","551910", "tiagoalpaca@gmail.com"));
        db.addCliente(new Cliente("Alessandra", "552038", "alesouza.camargo@gmail.com"));
        db.addCliente(new Cliente("Muriel", "551111", "murielmauch@gmail.com"));
        db.addCliente(new Cliente("Benzelara", "551111", "benzelara@gmail.com"));

        //apagando
        Cliente cliente = new Cliente();
        cliente.setCodigo(3);
        db.apagarCliente(cliente);

        //selecionando
        Cliente cliente = new Cliente();
        cliente.setCodigo(4);
        db.selecionarCliente(cliente);

        Log.d("Cliente Selecionado", "Codigo" + cliente.getCodigo() + " Nome" + cliente.getNome() + "Identificacao" + cliente.getIdentificao()
        + " Email" + cliente.getEmail());

        //Atualizando
        Cliente cliente = new Cliente();
        cliente.setCodigo(4);
        cliente.setNome("Alexandra Lara");
        cliente.setIdentificao("551817");
        cliente.setEmail("alexandrelara@gmail.com");

        public void listar


        Toast.makeText(Cadastro.this,"Salvo com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Apagado com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Selecionado com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Alterado com Sucesso",Toast.LENGTH_LONG).show();

*/





