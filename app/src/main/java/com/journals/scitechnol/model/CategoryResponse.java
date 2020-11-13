package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("subcat_cnt")
    private int subcatCnt;
    @SerializedName("subcat_details")
    private List<SubcatDetailsBean> subcatDetails;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSubcatCnt() {
        return subcatCnt;
    }

    public void setSubcatCnt(int subcatCnt) {
        this.subcatCnt = subcatCnt;
    }

    public List<SubcatDetailsBean> getSubcatDetails() {
        return subcatDetails;
    }

    public void setSubcatDetails(List<SubcatDetailsBean> subcatDetails) {
        this.subcatDetails = subcatDetails;
    }

    public static class SubcatDetailsBean {
        @SerializedName("journal")
        private String journal;
        @SerializedName("journal_name")
        private String journalName;
        @SerializedName("journal_url")
        private String journalUrl;
        @SerializedName("track_paper")
        private String trackPaper;

        public String getJournal() {
            return journal;
        }

        public void setJournal(String journal) {
            this.journal = journal;
        }

        public String getJournalName() {
            return journalName;
        }

        public void setJournalName(String journalName) {
            this.journalName = journalName;
        }

        public String getJournalUrl() {
            return journalUrl;
        }

        public void setJournalUrl(String journalUrl) {
            this.journalUrl = journalUrl;
        }

        public String getTrackPaper() {
            return trackPaper;
        }

        public void setTrackPaper(String trackPaper) {
            this.trackPaper = trackPaper;
        }
    }
}
