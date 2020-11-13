package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("cat_cnt")
    private int catCnt;
    @SerializedName("cat_details")
    private List<CatDetailsBean> catDetails;
    @SerializedName("recent_publications")
    private List<RecentPublicationsBean> recentPublications;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCatCnt() {
        return catCnt;
    }

    public void setCatCnt(int catCnt) {
        this.catCnt = catCnt;
    }

    public List<CatDetailsBean> getCatDetails() {
        return catDetails;
    }

    public void setCatDetails(List<CatDetailsBean> catDetails) {
        this.catDetails = catDetails;
    }

    public List<RecentPublicationsBean> getRecentPublications() {
        return recentPublications;
    }

    public void setRecentPublications(List<RecentPublicationsBean> recentPublications) {
        this.recentPublications = recentPublications;
    }

    public static class CatDetailsBean {
        @SerializedName("sno")
        private String sno;
        @SerializedName("journal_cat")
        private String journalCat;
        @SerializedName("cat_type")
        private String catType;
        @SerializedName("journal_cat_name")
        private String journalCatName;
        @SerializedName("journal_cat_desc")
        private String journalCatDesc;
        @SerializedName("journal_cat_url")
        private String journalCatUrl;
        @SerializedName("status")
        private String status;
        @SerializedName("journal_image")
        private String journalImage;
        @SerializedName("journal_logo")
        private String journalLogo;

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getJournalCat() {
            return journalCat;
        }

        public void setJournalCat(String journalCat) {
            this.journalCat = journalCat;
        }

        public String getCatType() {
            return catType;
        }

        public void setCatType(String catType) {
            this.catType = catType;
        }

        public String getJournalCatName() {
            return journalCatName;
        }

        public void setJournalCatName(String journalCatName) {
            this.journalCatName = journalCatName;
        }

        public String getJournalCatDesc() {
            return journalCatDesc;
        }

        public void setJournalCatDesc(String journalCatDesc) {
            this.journalCatDesc = journalCatDesc;
        }

        public String getJournalCatUrl() {
            return journalCatUrl;
        }

        public void setJournalCatUrl(String journalCatUrl) {
            this.journalCatUrl = journalCatUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getJournalImage() {
            return journalImage;
        }

        public void setJournalImage(String journalImage) {
            this.journalImage = journalImage;
        }

        public String getJournalLogo() {
            return journalLogo;
        }

        public void setJournalLogo(String journalLogo) {
            this.journalLogo = journalLogo;
        }
    }

    public static class RecentPublicationsBean {
        @SerializedName("sno")
        private String sno;
        @SerializedName("fullname")
        private String fullname;
        @SerializedName("access_type")
        private String accessType;
        @SerializedName("article")
        private String article;
        @SerializedName("shortjournal")
        private String shortjournal;
        @SerializedName("doi")
        private String doi;
        @SerializedName("title")
        private String title;
        @SerializedName("name")
        private String name;
        @SerializedName("abstract")
        private String abstractX;
        @SerializedName("fulltextlink")
        private String fulltextlink;
        @SerializedName("pdflink")
        private String pdflink;
        @SerializedName("date")
        private String date;
        @SerializedName("articleimage")
        private Object articleimage;
        @SerializedName("journal")
        private String journal;
        @SerializedName("abs_link")
        private String absLink;

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
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

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getFulltextlink() {
            return fulltextlink;
        }

        public void setFulltextlink(String fulltextlink) {
            this.fulltextlink = fulltextlink;
        }

        public String getPdflink() {
            return pdflink;
        }

        public void setPdflink(String pdflink) {
            this.pdflink = pdflink;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Object getArticleimage() {
            return articleimage;
        }

        public void setArticleimage(Object articleimage) {
            this.articleimage = articleimage;
        }

        public String getJournal() {
            return journal;
        }

        public void setJournal(String journal) {
            this.journal = journal;
        }

        public String getAbsLink() {
            return absLink;
        }

        public void setAbsLink(String absLink) {
            this.absLink = absLink;
        }
    }
}
