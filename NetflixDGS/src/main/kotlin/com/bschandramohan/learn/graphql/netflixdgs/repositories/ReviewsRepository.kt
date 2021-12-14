package com.bschandramohan.learn.graphql.netflixdgs.repositories

import com.bschandramohan.learn.graphql.netflixdgs.models.ReviewModel
import com.bschandramohan.learn.graphql.netflixdgs.types.Review
import org.springframework.stereotype.Repository

@Repository
class ReviewsRepository {
    private val reviews = mutableListOf(
        ReviewModel(id="r1", courseId = "c1", binaryRating = true),
        ReviewModel(id="r2", courseId = "c2", binaryRating = false, feedbackText = "Could be improved"),
    )

    fun getReviewsList() = reviews

    fun getReview(id: String) = reviews.firstOrNull { it.id == id }

    fun getReviewForCourse(courseId: String) = reviews.firstOrNull { it.courseId == courseId }
}
