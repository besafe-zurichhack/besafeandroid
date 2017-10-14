package com.marcos.perez.mvpexample.perfil.presenter;


import com.marcos.perez.mvpexample.perfil.model.PerfilModel;
import com.marcos.perez.mvpexample.perfil.model.IPerfilModel;
import com.marcos.perez.mvpexample.perfil.view.IPerfilView;

/**
 * Created by Joan Manel on 14/10/2017.
 */

public class PerfilPresenter {
    IPerfilModel mModel;
    IPerfilView mView;

    public PerfilPresenter(IPerfilView view){
        this.mView = view;
        this.mModel= (IPerfilModel) new PerfilModel((IPerfilPresenter) this);
    }
}
