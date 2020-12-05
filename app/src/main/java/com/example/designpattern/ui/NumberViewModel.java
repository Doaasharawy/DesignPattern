package com.example.designpattern.ui;

import com.example.designpattern.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
MutableLiveData<Integer>multiMutableData=new MutableLiveData<>();
public NumberModel getNumbersFromDatabase(){
    return new NumberModel(2,4);
}

public void getMultiNumbers(){
    int result=getNumbersFromDatabase().getFirstNumber()*getNumbersFromDatabase().getSecondNumber();
    multiMutableData.setValue(result);
}
}

