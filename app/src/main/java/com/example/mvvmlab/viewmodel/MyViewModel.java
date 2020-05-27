package com.example.mvvmlab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//Necessita herdar de ViewModel
//O AndroidViewModel propaga o context... que é esse que utilizaremos (entre aspas propagaremos os estados)
public class MyViewModel extends ViewModel {

    /*public MyViewModel(@NonNull Application application) {
        super(application);
    }*/

    //Objeto que vai segurar o estado da aplicação => MutableLiveData
    private MutableLiveData<String> name;

    public MutableLiveData<String> getName() {
        if(this.name == null) {
            this.name = new MutableLiveData<>();
            updateName();
        }
        return this.name;
    }

    private void updateName() {
        this.name.setValue("Dev Venture");
    }
}
