package com.example.tiagoavellar.agenda;

/**
 * Created by Tiago Avellar on 21/10/2017.
 */

public interface CadastroView {

    void sucessoCadastro(String nome,String endereco, String email,String telefone);
    void falhoCadastro();
}
