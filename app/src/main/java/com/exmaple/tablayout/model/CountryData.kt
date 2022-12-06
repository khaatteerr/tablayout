package com.exmaple.tablayout.model

import com.google.gson.annotations.SerializedName

data class CountryData(

    @SerializedName("United States")
    val  UnitedStates: List<UnitedState?>?,
    val Australia: List<Australia?>?,
    val Canada: List<Canada?>?,
    val EGYPT: List<EGYPT?>?,
    val FRANCS: List<FRANCS?>?
)