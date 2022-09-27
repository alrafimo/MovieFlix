package com.example.movieflix


import com.google.gson.annotations.SerializedName

class Movies {


    @JvmField
    @SerializedName("original_title")
    var title: String? = null

    @JvmField
    //TODO bookImageUrl
    @SerializedName("poster_path")
    var movieImageUrl: String? = null

    //TODO description
    @SerializedName("overview")
    var description: String? = null

    //TODO-STRETCH-GOALS amazonUrl
}