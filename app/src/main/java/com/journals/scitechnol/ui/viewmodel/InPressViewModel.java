package com.journals.scitechnol.ui.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.journals.scitechnol.model.InPressResponse;
import com.journals.scitechnol.network.JournalRepository;

import static android.content.ContentValues.TAG;

public class InPressViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver ;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<InPressResponse> mutableLiveData;

    public void init(String journalcode, Context context){
        if (mutableLiveData != null){
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("journalcode",journalcode);
        Log.d(TAG, "init: "+jsonObject);
        mutableLiveData = journalRepository.getInPressData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();
    }

    public LiveData<InPressResponse> getInPressRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver(){
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }

}