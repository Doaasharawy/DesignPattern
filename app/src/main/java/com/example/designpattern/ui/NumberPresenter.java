package com.example.designpattern.ui;

import com.example.designpattern.pojo.NumberModel;

public class NumberPresenter {
    NumberView view;

    public NumberPresenter(NumberView view){
        this.view=view;

    }
    public NumberModel getNumberFromDatabase(){

        return new NumberModel(4,2);
    }
public void getDiv(){
        view.OnGetDivResult(getNumberFromDatabase().getFirstNumber()/ getNumberFromDatabase().getSecondNumber());
}
}
