package com.victor.convert.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.victor.convert.R;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public static MutableLiveData<Integer> mNumber;
    public Context context;



    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        //load();

    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Integer> getmNumber(){

        if (mNumber == null) {
            mNumber = new MutableLiveData<>();
            mNumber.setValue(load());
        }
        return mNumber;
    }



    public void add(int x){
        mNumber.setValue(mNumber.getValue()+x);
        if (mNumber.getValue()<0){
            mNumber.setValue(0);
        }
        if (mNumber.getValue()>20){
            mNumber.setValue(0);
        }
    }

    public int load() {
        SharedPreferences preferences = context.getSharedPreferences("sp",Context.MODE_PRIVATE);
        int x = preferences.getInt("value",0);
        Log.d("msg",String.valueOf(x));
        return x;
    }

    public void save() {
        SharedPreferences preferences = context.getSharedPreferences("sp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("value",getmNumber().getValue());
        editor.apply();
    }

}