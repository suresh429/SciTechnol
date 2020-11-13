package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentIssueResponse {


    @SerializedName("currentissue_cnt")
    private int currentissueCnt;
    @SerializedName("status")
    private boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("currentissue_details")
    private List<CurrentissueDetailsBean> currentissueDetails;

    public int getCurrentissueCnt() {
        return currentissueCnt;
    }

    public void setCurrentissueCnt(int currentissueCnt) {
        this.currentissueCnt = currentissueCnt;
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

    public List<CurrentissueDetailsBean> getCurrentissueDetails() {
        return currentissueDetails;
    }

    public void setCurrentissueDetails(List<CurrentissueDetailsBean> currentissueDetails) {
        this.currentissueDetails = currentissueDetails;
    }

    public static class CurrentissueDetailsBean {
        @SerializedName("sno")
        private String sno;
        @SerializedName("valume")
        private String valume;
        @SerializedName("journal")
        private String journal;
        @SerializedName("access_type")
        private String accessType;
        @SerializedName("article")
        private String article;
        @SerializedName("shortjournal")
        private String shortjournal;
        @SerializedName("doi")
        private String doi;
        @SerializedName("fulltextlink")
        private String fulltextlink;
        @SerializedName("name")
        private String name;
        @SerializedName("pdflink")
        private String pdflink;
        @SerializedName("title")
        private String title;
        @SerializedName("sup")
        private String sup;
        @SerializedName("articleimage")
        private Object articleimage;
        @SerializedName("abs_link")
        private String absLink;
        @SerializedName("doi_stat")
        private String doiStat;

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getValume() {
            return valume;
        }

        public void setValume(String valume) {
            this.valume = valume;
        }

        public String getJournal() {
            return journal;
        }

        public void setJournal(String journal) {
            this.journal = journal;
        }

        public String getAccessType() {
            return accessType;
        }

        public void setAccessType(String accessType) {
            this.accessType = accessType;
        }

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getShortjournal() {
            return shortjournal;
        }

        public void setShortjournal(String shortjournal) {
            this.shortjournal = shortjournal;
        }

        public String getDoi() {
            return doi;
        }

        public void setDoi(String doi) {
            this.doi = doi;
        }

        public String getFulltextlink() {
            return fulltextlink;
        }

        public void setFulltextlink(String fulltextlink) {
            this.fulltextlink = fulltextlink;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPdflink() {
            return pdflink;
        }

        public void setPdflink(String pdflink) {
            this.pdflink = pdflink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSup() {
            return sup;
        }

        public void setSup(String sup) {
            this.sup = sup;
        }

        public Object getArticleimage() {
            return articleimage;
        }

        public void setArticleimage(Object articleimage) {
            this.articleimage = articleimage;
        }

        public String getAbsLink() {
            return absLink;
        }

        public void setAbsLink(String absLink) {
            this.absLink = absLink;
        }

        public String getDoiStat() {
            return doiStat;
        }

        public void setDoiStat(String doiStat) {
            this.doiStat = doiStat;
        }
    }
}
