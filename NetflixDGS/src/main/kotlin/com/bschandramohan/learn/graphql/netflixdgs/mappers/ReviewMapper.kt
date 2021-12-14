package com.bschandramohan.learn.graphql.netflixdgs.mappers

import com.bschandramohan.learn.graphql.netflixdgs.models.ReviewModel
import com.bschandramohan.learn.graphql.netflixdgs.types.Review

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
