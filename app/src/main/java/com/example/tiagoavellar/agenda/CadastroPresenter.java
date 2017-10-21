package com.example.tiagoavellar.agenda;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Tiago Avellar on 21/10/2017.
 */

public class CadastroPresenter {

    CadastroView cadastroView;

    public CadastroPresenter(CadastroView cadastroView) {
        this.cadastroView = cadastroView;
    }

    public void login(String nome,String telefone) {

        if (TextUtils.isEmpty(nome)) {
            cadastroView.falhoCadastro();
        } else if (TextUtils.isEmpty(telefone)) {
            cadastroView.falhoCadastro();
        }else{
            cadastroView.sucessoCadastro();
        }
    }
}