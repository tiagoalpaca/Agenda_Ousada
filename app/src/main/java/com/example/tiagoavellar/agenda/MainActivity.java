package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity  {
    @BindView(R.id.button) Button button;
    @BindView(R.id.button3) Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
        @OnClick(R.id.button)
        public void EntraAplicativo(){
                Intent it = new Intent(MainActivity.this, Menu.class);
                startActivity(it);
                }

    @OnClick(R.id.button3)
    public void EntraMenuAjuda(){
        Intent it = new Intent(MainActivity.this, MenuAjuda.class);
        startActivity(it);
    }
}