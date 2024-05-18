//THIS IS WHERE WE GET DATA FROM THE WEBSITE TO OUR APP

package com.example.recipeeapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit=Retrofit.Builder().baseUrl("http://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface APIService{
    @GET("categories.php")  //GET keyword has to be used when getting data from a website
    suspend fun getcategories():CategoryResponse
}

val recipeservice= retrofit.create(APIService::class.java)  //THIS LINKS THE retrofit to the APIService