package com.bschandramohan.learn.graphql.netflixdgs.models

data class CourseModel(
    val id: String,
    val title: String,
    val trainers: MutableList<String> = mutableListOf(),
    val reviews: MutableList<String> = mutableListOf()
)
