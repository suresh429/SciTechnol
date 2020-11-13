package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArchiveResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("archive_years")
    private List<ArchiveYearsBean> archiveYears;

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

    public List<ArchiveYearsBean> getArchiveYears() {
        return archiveYears;
    }

    public void setArchiveYears(List<ArchiveYearsBean> archiveYears) {
        this.archiveYears = archiveYears;
    }

    public static class ArchiveYearsBean {
        @SerializedName("year")
        private String year;
        @SerializedName("archive_details")
        private List<ArchiveDetailsBean> archiveDetails;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<ArchiveDetailsBean> getArchiveDetails() {
            return archiveDetails;
        }

        public void setArchiveDetails(List<ArchiveDetailsBean> archiveDetails) {
            this.archiveDetails = archiveDetails;
        }

        public static class ArchiveDetailsBean {
            @SerializedName("valume")
            private String valume;
            @SerializedName("year")
            private String year;
            @SerializedName("month")
            private String month;
            @SerializedName("journal")
            private String journal;
            @SerializedName("vol")
            private String vol;
            @SerializedName("issue")
            private String issue;
            @SerializedName("total")
            private String total;

            public String getValume() {
                return valume;
            }

            public void setValume(String valume) {
                this.valume = valume;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getJournal() {
                return journal;
            }

            public void setJournal(String journal) {
                this.journal = journal;
            }

            public String getVol() {
                return vol;
            }

            public void setVol(String vol) {
                this.vol = vol;
            }

            public String getIssue() {
                return issue;
            }

            public void setIssue(String issue) {
                this.issue = issue;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }
        }
    }
}
