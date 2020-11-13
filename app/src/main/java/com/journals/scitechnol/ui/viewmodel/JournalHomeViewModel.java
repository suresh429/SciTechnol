package com.journals.scitechnol.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.journals.scitechnol.model.JournalHomeResponse;
import com.journals.scitechnol.network.JournalRepository;

public class JournalHomeViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver ;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<JournalHomeResponse> mutableLiveData;

    public void init(String journal, Context context){
        if (mutableLiveData != null){
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("journal",journal);
        mutableLiveData = journalRepository.getJournalHomeData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();
    }

    public LiveData<JournalHomeResponse> getJournalHomeRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver(){
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }

}