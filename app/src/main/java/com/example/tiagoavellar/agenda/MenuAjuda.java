package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

public class MenuAjuda extends AppCompatActivity {
    @BindView(R.id.button16) Button button16;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ajuda);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.button16)
    public void MenuInicial(){
        Intent it = new Intent(MenuAjuda.this, MainActivity.class);
        startActivity(it);
    }
}

