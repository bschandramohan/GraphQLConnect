package com.bschandramohan.learn.graphql.netflixdgs.models

import com.bschandramohan.learn.graphql.netflixdgs.types.GENDER

data class TrainerModel(
    val id: String,
    var name: String? = null,
    var dob: String? = null,
    var email: String? = null,
    var gender: GENDER = GENDER.UNKNOWN,
)
