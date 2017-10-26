package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

public class Menu extends AppCompatActivity implements MenuView {

    @BindView(R.id.button4) Button button4;
    @BindView(R.id.button5) Button button5;
    @BindView(R.id.button6) Button button6;
    @BindView(R.id.ButaoPesquisa) ImageButton ButaoPesuisa;
    @BindView(R.id.txt_pesquisa) EditText txt_pesquisa;
    BancoDados db;
    MenuPresenter menuPresenter;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        menuPresenter = new MenuPresenter(this);
    }

    @OnClick(R.id.button4)
    public void TodosContato(){
        Intent it = new Intent(Menu.this, ExibeContato.class);
        startActivity(it);
    }

    @OnClick(R.id.ButaoPesquisa)
    public void BuscaContato(){
        menuPresenter.pesquisa(txt_pesquisa.getText().toString());
    }

    @OnClick(R.id.button5)
    public void Cadastro(){
        Intent it = new Intent(Menu.this, Cadastro.class);
        startActivity(it);
    }
    @OnClick(R.id.button6)
    public void Voltar(){
        Intent it = new Intent(Menu.this, MainActivity.class);
        startActivity(it);
    }

    @Override
    public void sucessoPesquisa(String pesquisa){
        this.db = new BancoDados(this);
        nome = db.BuscaCliente(new Cliente(pesquisa));
        Toast.makeText(Menu.this, nome, Toast.LENGTH_LONG).show();
        Intent it = new Intent(Menu.this, Menu.class);
        startActivity(it);
    }
    @Override
    public void falhoPesquisa(){
        Toast.makeText(Menu.this, "Falta o nome para buscar o Contato ", Toast.LENGTH_LONG).show();
        Intent it = new Intent(Menu.this, Menu.class);
        startActivity(it);
    }
}