package com.marcos.perez.mvpexample.perfil.model;

import com.marcos.perez.mvpexample.perfil.presenter.IPerfilPresenter;

/**
 * Created by Joan Manel on 14/10/2017.
 */

public class PerfilModel {
    IPerfilPresenter mPresenter;
    public PerfilModel(IPerfilPresenter perfilPresenter) {
        this.mPresenter = perfilPresenter;
    }

}
