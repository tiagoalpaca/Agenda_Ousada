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

    public void login(String nome,String endereco, String email,String telefone, String observacao) {

        if (TextUtils.isEmpty(nome)) {
            cadastroView.falhoCadastro();
        } else if (TextUtils.isEmpty(telefone)) {
            cadastroView.falhoCadastro();
        }else{
            cadastroView.sucessoCadastro(nome,endereco,email,telefone,observacao);
        }
    }
}