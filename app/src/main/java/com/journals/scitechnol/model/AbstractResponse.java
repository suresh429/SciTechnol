package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AbstractResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("abstract")
    private int abstractX;
    @SerializedName("abstract_details")
    private List<AbstractDetailsBean> abstractDetails;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(int abstractX) {
        this.abstractX = abstractX;
    }

    public List<AbstractDetailsBean> getAbstractDetails() {
        return abstractDetails;
    }

    public void setAbstractDetails(List<AbstractDetailsBean> abstractDetails) {
        this.abstractDetails = abstractDetails;
    }

    public static class AbstractDetailsBean {
        @SerializedName("sno")
        private String sno;
        @SerializedName("journal")
        private String journal;
        @SerializedName("title")
        private String title;
        @SerializedName("name")
        private String name;
        @SerializedName("fullname")
        private String fullname;
        @SerializedName("access_type")
        private String accessType;
        @SerializedName("pdflink")
        private String pdflink;
        @SerializedName("fulltextlink")
        private String fulltextlink;
        @SerializedName("keywords")
        private String keywords;
        @SerializedName("article")
        private String article;
        @SerializedName("abstract")
        private String abstractX;
        @SerializedName("class_keywords")
        private String classKeywords;
        @SerializedName("year")
        private String year;
        @SerializedName("vol")
        private String vol;
        @SerializedName("issue")
        private String issue;
        @SerializedName("doi")
        private String doi;
        @SerializedName("issn")
        private String issn;
        @SerializedName("pub_date")
        private String pubDate;
        @SerializedName("s_page")
        private String sPage;
        @SerializedName("e_page")
        private String ePage;
        @SerializedName("abs_link")
        private String absLink;

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getJournal() {
            return journal;
        }

        public void setJournal(String journal) {
            this.journal = journal;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getAccessType() {
            return accessType;
        }

        public void setAccessType(String accessType) {
            this.accessType = accessType;
        }

        public String getPdflink() {
            return pdflink;
        }

        public void setPdflink(String pdflink) {
            this.pdflink = pdflink;
        }

        public String getFulltextlink() {
            return fulltextlink;
        }

        public void setFulltextlink(String fulltextlink) {
            this.fulltextlink = fulltextlink;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getClassKeywords() {
            return classKeywords;
        }

        public void setClassKeywords(String classKeywords) {
            this.classKeywords = classKeywords;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
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

        public String getDoi() {
            return doi;
        }

        public void setDoi(String doi) {
            this.doi = doi;
        }

        public String getIssn() {
            return issn;
        }

        public void setIssn(String issn) {
            this.issn = issn;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getSPage() {
            return sPage;
        }

        public void setSPage(String sPage) {
            this.sPage = sPage;
        }

        public String getEPage() {
            return ePage;
        }

        public void setEPage(String ePage) {
            this.ePage = ePage;
        }

        public String getAbsLink() {
            return absLink;
        }

        public void setAbsLink(String absLink) {
            this.absLink = absLink;
        }
    }
}
