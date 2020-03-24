package com.e.loginapp.ApiServer;

import com.e.loginapp.Model.Invoice;
import com.e.loginapp.Model.Issue;
import com.e.loginapp.Model.Post;
import com.e.loginapp.Model.Tenant;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonHolderApi {

    @GET("posts/1")
    Call<List<Post>> getPosts();

//    @GET("GetTenant/159")
//    Call<List<Tenant>> getTenant();

    @GET("GetInvoices/3304")
    Call<List<Invoice>> getInvoices();

    @GET("GetTenant/{id}")
    Call<Tenant> getTenant(@Path("id") int tenantId);

}
