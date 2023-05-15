package com.neotica.lazylist.data.model

import java.io.Serializable

data class PersonEntity(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val personImageId: Int = 0
) : Serializable
