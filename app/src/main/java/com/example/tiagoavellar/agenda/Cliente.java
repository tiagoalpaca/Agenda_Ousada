package com.example.tiagoavellar.agenda;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

public class Cliente extends AppCompatActivity {


    String nome,email,endereco,telefone,observacao;

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {

        return observacao;
    }

    public Cliente(String nome1, String email1, String endereco, String telefone, String observacao){

        this.nome = nome1;
        this.email = email1;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Cliente(String nome){

        this.nome = nome;
    }


    public String getNome(){
        return nome;
    }
    public void  setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

}

