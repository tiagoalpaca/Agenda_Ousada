package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tiago Avellar on 05/10/2017.
 */

public class ExibeContato extends AppCompatActivity {

    //variaveis dos campos em branco
    @BindView(R.id.list_tudo) ListView lv;
    ArrayList<String> lista;
    ArrayAdapter adaptador;
    BancoDados db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_contato);
        ButterKnife.bind(this);
        this.db = new BancoDados(this);
        lista = db.MostraLista();
        adaptador= new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);
    }
}
