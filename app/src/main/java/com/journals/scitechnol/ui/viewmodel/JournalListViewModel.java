package com.journals.scitechnol.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.journals.scitechnol.model.ContactResponse;
import com.journals.scitechnol.model.JournalsListResponse;
import com.journals.scitechnol.network.JournalRepository;

public class JournalListViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver ;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<JournalsListResponse> journalsListResponseMutableLiveData;
    private MutableLiveData<ContactResponse> contactResponseMutableLiveData;

    public void journalList(String page, Context context){
        if (journalsListResponseMutableLiveData != null){
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page",page);
        journalsListResponseMutableLiveData = journalRepository.getJournalListDisplay(jsonObject);

        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();
    }


    public void contactData(String journalcode,String firstname,String lastname,String email,String ucat,
                            String dept, String phone,String country,String message,Context context){
        if (contactResponseMutableLiveData != null){
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);

        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("journal",journalcode);
        jsonObject1.addProperty("firstname",firstname);
        jsonObject1.addProperty("lastname",lastname);
        jsonObject1.addProperty("email",email);
        jsonObject1.addProperty("ucat",ucat);
        jsonObject1.addProperty("dept",dept);
        jsonObject1.addProperty("phone",phone);
        jsonObject1.addProperty("country",country);
        jsonObject1.addProperty("message",message);
        jsonObject1.addProperty("source","android");
        contactResponseMutableLiveData = journalRepository.getContactData(jsonObject1);

        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<JournalsListResponse> getJournalListRepository() {
        return journalsListResponseMutableLiveData;
    }

    public LiveData<ContactResponse> getContactRepository() {
        return contactResponseMutableLiveData;
    }

    public LiveData<String> getToastObserver(){
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }



}