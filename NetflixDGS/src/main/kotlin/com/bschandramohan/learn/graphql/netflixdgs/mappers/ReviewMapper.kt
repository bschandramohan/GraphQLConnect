package com.bschandramohan.learn.graphql.netflixdgs.mappers

import com.bschandramohan.learn.graphql.netflixdgs.models.ReviewModel
import com.bschandramohan.learn.graphql.netflixdgs.types.Review
import com.bschandramohan.learn.graphql.netflixdgs.types.ReviewInput
import kotlin.random.Random

fun ReviewModel.toReview() = Review(
    id = this.id,
    courseId = this.courseId,
    binaryRating = this.binaryRating,
    scaleRating = this.scaleRating,
    scaleRatingMax = this.scaleRatingMax,
    feedbackText = this.feedbackText
)

fun List<ReviewModel>.toReviewList() = map {
    it.toReview()
}

fun ReviewInput.toModel() = ReviewModel(
    id = this.id ?: Random.nextLong(100000, 1000000000).toString(),
    courseId = this.courseId,
    binaryRating = this.binaryRating,
    scaleRating = this.scaleRating,
    scaleRatingMax = this.scaleRatingMax,
    feedbackText = this.feedbackText
)