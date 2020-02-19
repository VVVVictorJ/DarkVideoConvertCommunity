package com.victor.convert.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public static MutableLiveData<Integer> mNumber;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Integer> getmNumber(){
        if (mNumber == null) {
            mNumber = new MutableLiveData<>();
            mNumber.setValue(0);
        }
        return mNumber;
    }

    public void add(int x){
        mNumber.setValue(mNumber.getValue()+x);
        if (mNumber.getValue()<0){
            mNumber.setValue(0);
        }
        if (mNumber.getValue()>10){
            mNumber.setValue(0);
        }
    }
}