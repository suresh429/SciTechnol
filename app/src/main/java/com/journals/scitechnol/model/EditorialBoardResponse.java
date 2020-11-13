package com.journals.scitechnol.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EditorialBoardResponse {


    @SerializedName("status")
    private boolean status;
    @SerializedName("editorialboardcnt")
    private int editorialboardcnt;
    @SerializedName("editorialboardarr")
    private List<EditorialboardarrBean> editorialboardarr;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getEditorialboardcnt() {
        return editorialboardcnt;
    }

    public void setEditorialboardcnt(int editorialboardcnt) {
        this.editorialboardcnt = editorialboardcnt;
    }

    public List<EditorialboardarrBean> getEditorialboardarr() {
        return editorialboardarr;
    }

    public void setEditorialboardarr(List<EditorialboardarrBean> editorialboardarr) {
        this.editorialboardarr = editorialboardarr;
    }

    public static class EditorialboardarrBean {
        @SerializedName("ename")
        private String ename;
        @SerializedName("ebimage")
        private String ebimage;
        @SerializedName("ebmember")
        private String ebmember;
        @SerializedName("eprofile_url")
        private String eprofileUrl;
        @SerializedName("editor_type")
        private String editorType;
        @SerializedName("editor_email")
        private String editorEmail;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getEbimage() {
            return ebimage;
        }

        public void setEbimage(String ebimage) {
            this.ebimage = ebimage;
        }

        public String getEbmember() {
            return ebmember;
        }

        public void setEbmember(String ebmember) {
            this.ebmember = ebmember;
        }

        public String getEprofileUrl() {
            return eprofileUrl;
        }

        public void setEprofileUrl(String eprofileUrl) {
            this.eprofileUrl = eprofileUrl;
        }

        public String getEditorType() {
            return editorType;
        }

        public void setEditorType(String editorType) {
            this.editorType = editorType;
        }

        public String getEditorEmail() {
            return editorEmail;
        }

        public void setEditorEmail(String editorEmail) {
            this.editorEmail = editorEmail;
        }
    }
}
