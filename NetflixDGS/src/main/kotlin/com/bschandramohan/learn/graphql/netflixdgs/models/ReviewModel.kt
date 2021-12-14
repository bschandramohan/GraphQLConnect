package com.bschandramohan.learn.graphql.netflixdgs.models

data class ReviewModel(
    val id: String,
    var courseId: String? = null,
    var binaryRating: Boolean? = null,
    var scaleRating: Int? = null,
    var scaleRatingMax: Int? = null,
    var feedbackText: String? = null
)