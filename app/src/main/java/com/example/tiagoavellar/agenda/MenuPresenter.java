package com.example.tiagoavellar.agenda;

import android.text.TextUtils;

/**
 * Created by Tiago Avellar on 21/10/2017.
 */

public class MenuPresenter {

    MenuView menuView;

    public MenuPresenter(MenuView menuView) {
        this.menuView = menuView;
    }

    public void pesquisa(String pesquisa) {
        if (TextUtils.isEmpty(pesquisa)) {
            menuView.falhoPesquisa();
        } else{
            menuView.sucessoPesquisa(pesquisa);
        }
    }
}
