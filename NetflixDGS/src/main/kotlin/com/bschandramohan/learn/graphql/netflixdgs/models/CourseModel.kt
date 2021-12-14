package com.bschandramohan.learn.graphql.netflixdgs.models

data class CourseModel(
    val id: String,
    val title: String,
    val trainers: List<String> = listOf(),
    val reviews: List<String> = listOf()
)
