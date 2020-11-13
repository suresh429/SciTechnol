package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

public class JournalHomeResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("abt_journal")
    private int abtJournal;
    @SerializedName("abt_journal_details")
    private String abtJournalDetails;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAbtJournal() {
        return abtJournal;
    }

    public void setAbtJournal(int abtJournal) {
        this.abtJournal = abtJournal;
    }

    public String getAbtJournalDetails() {
        return abtJournalDetails;
    }

    public void setAbtJournalDetails(String abtJournalDetails) {
        this.abtJournalDetails = abtJournalDetails;
    }
}
