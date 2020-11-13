package com.journals.scitechnol.network;

import com.google.gson.JsonObject;
import com.journals.scitechnol.model.AbstractResponse;
import com.journals.scitechnol.model.ArchiveResponse;
import com.journals.scitechnol.model.CategoryResponse;
import com.journals.scitechnol.model.ContactResponse;
import com.journals.scitechnol.model.CurrentIssueResponse;
import com.journals.scitechnol.model.EditorialBoardResponse;
import com.journals.scitechnol.model.HomeResponse;
import com.journals.scitechnol.model.InPressResponse;
import com.journals.scitechnol.model.InstructionforAuthorsResponse;
import com.journals.scitechnol.model.JournalHomeResponse;
import com.journals.scitechnol.model.JournalsListResponse;
import com.journals.scitechnol.model.VolumeIssueResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers("Content-Type: application/json")
    @POST("homeapi.php")
    Call<HomeResponse> getHomeList(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("categorylistapi.php")
    Call<CategoryResponse> getCategoryList(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("aboutjournalapi.php")
    Call<JournalHomeResponse> getJournalHomeDetails(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("current-issueapi.php")
    Call<CurrentIssueResponse> getCurrentIssueList(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("inpressapi.php")
    Call<InPressResponse> getInPressList(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("archiveapi.php")
    Call<ArchiveResponse> getArchiveList(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("abstractdisplayapi.php")
    Call<AbstractResponse> getAbstractDisplay(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("vol_issueapi.php")
    Call<VolumeIssueResponse> getVolumeIssueDisplay(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("contactpagejournalsapi.php")
    Call<JournalsListResponse> getJournalListDisplay(@Body JsonObject jsonObject);



    @Headers("Content-Type: application/json")
    @POST("contactapi.php")
    Call<ContactResponse> getContactDisplay(@Body JsonObject jsonObject);


    @Headers("Content-Type: application/json")
    @POST("instructionsforauthorsapi.php")
    Call<InstructionforAuthorsResponse> getInstructionsList(@Body JsonObject jsonObject);


    @Headers("Content-Type: application/json")
    @POST("editorialboardapi.php")
    Call<EditorialBoardResponse> getEditorialList(@Body JsonObject jsonObject);

}
