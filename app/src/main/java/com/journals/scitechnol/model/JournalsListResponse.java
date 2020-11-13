package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JournalsListResponse {


    @SerializedName("journal_cnt")
    private int journalCnt;
    @SerializedName("status")
    private boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("country_cnt")
    private int countryCnt;
    @SerializedName("journal_details")
    private List<JournalDetailsBean> journalDetails;
    @SerializedName("country_details")
    private List<CountryDetailsBean> countryDetails;

    public int getJournalCnt() {
        return journalCnt;
    }

    public void setJournalCnt(int journalCnt) {
        this.journalCnt = journalCnt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCountryCnt() {
        return countryCnt;
    }

    public void setCountryCnt(int countryCnt) {
        this.countryCnt = countryCnt;
    }

    public List<JournalDetailsBean> getJournalDetails() {
        return journalDetails;
    }

    public void setJournalDetails(List<JournalDetailsBean> journalDetails) {
        this.journalDetails = journalDetails;
    }

    public List<CountryDetailsBean> getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(List<CountryDetailsBean> countryDetails) {
        this.countryDetails = countryDetails;
    }

    public static class JournalDetailsBean {
        @SerializedName("journal")
        private String journal;
        @SerializedName("journalname")
        private String journalname;
        @SerializedName("managejournal")
        private String managejournal;
        @SerializedName("journal_url")
        private String journalUrl;

        public String getJournal() {
            return journal;
        }

        public void setJournal(String journal) {
            this.journal = journal;
        }

        public String getJournalname() {
            return journalname;
        }

        public void setJournalname(String journalname) {
            this.journalname = journalname;
        }

        public String getManagejournal() {
            return managejournal;
        }

        public void setManagejournal(String managejournal) {
            this.managejournal = managejournal;
        }

        public String getJournalUrl() {
            return journalUrl;
        }

        public void setJournalUrl(String journalUrl) {
            this.journalUrl = journalUrl;
        }
    }

    public static class CountryDetailsBean {
        @SerializedName("id")
        private String id;
        @SerializedName("iso")
        private String iso;
        @SerializedName("name")
        private String name;
        @SerializedName("printable_name")
        private String printableName;
        @SerializedName("iso3")
        private String iso3;
        @SerializedName("numcode")
        private String numcode;
        @SerializedName("slug")
        private String slug;
        @SerializedName("status")
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrintableName() {
            return printableName;
        }

        public void setPrintableName(String printableName) {
            this.printableName = printableName;
        }

        public String getIso3() {
            return iso3;
        }

        public void setIso3(String iso3) {
            this.iso3 = iso3;
        }

        public String getNumcode() {
            return numcode;
        }

        public void setNumcode(String numcode) {
            this.numcode = numcode;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
