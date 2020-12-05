package com.example.designpattern.ui;

import android.os.Bundle;
import android.view.View;

import com.example.designpattern.R;
import com.example.designpattern.databinding.ActivityMainBinding;
import com.example.designpattern.pojo.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements NumberView {
ActivityMainBinding binding;
//***** Mvp **********
NumberPresenter presenter;
//********* MVVM *********
    NumberViewModel numberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /// ********** Mvc ***********
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.plusResultTextView.setText(Integer.toString(getsum()));
            }
        });
        ///************* Mvp **************
        presenter = new NumberPresenter(this);
        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDiv();
            }
        });

        //******** MVVM **********
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        numberViewModel.multiMutableData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.mulResultTextView.setText(Integer.toString(integer));
            }
        });
        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberViewModel.getMultiNumbers();
            }
        });
    }
        ///--------------- Mvc --------
       public NumberModel getNumberFromDtabase(){
           return new NumberModel(2,4);

        }

    public int getsum(){
        return getNumberFromDtabase().getFirstNumber()+getNumberFromDtabase().getSecondNumber();
    }

    /// *********** MVP ***********
    @Override
    public void OnGetDivResult(int result) {
        binding.divResultTextView.setText(Integer.toString(result));
    }
}