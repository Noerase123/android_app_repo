package com.e.loginapp;

import com.e.loginapp.Model.Invoice;
import com.e.loginapp.Model.Post;
import com.e.loginapp.Model.Tenant;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonHolderApi {

    @GET("posts/1")
    Call<List<Post>> getPosts();

//    @GET("GetTenant/159")
//    Call<List<Tenant>> getTenant();

    @GET("GetInvoices/3304")
    Call<List<Invoice>> getInvoices();

    @GET("getTenant/3304")
    Call<Tenant> getTenant();
}
