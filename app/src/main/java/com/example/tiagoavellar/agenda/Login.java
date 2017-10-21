package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

public class Login extends AppCompatActivity {
    @BindView(R.id.button4) Button button4;
    @BindView(R.id.button5) Button button5;
    @BindView(R.id.button7) Button button7;
    @BindView(R.id.button8) Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button4)
    public void BuscaContato(){
        Intent it = new Intent(Login.this, BuscaContato.class);
        startActivity(it);
    }
    @OnClick(R.id.button5)
    public void Cadastro(){
        Intent it = new Intent(Login.this, Cadastro.class);
        startActivity(it);
    }

    @OnClick(R.id.button7)
    public void RemoveContato(){
        Intent it = new Intent(Login.this, Login.class);
        startActivity(it);
    }

    @OnClick(R.id.button8)
    public void EditaContato(){
        Intent it = new Intent(Login.this, EditaContato.class);
        startActivity(it);
    }
}