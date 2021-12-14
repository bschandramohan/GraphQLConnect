package com.bschandramohan.learn.graphql.netflixdgs.mutations

import com.bschandramohan.learn.graphql.netflixdgs.repositories.CourseRepository
import com.bschandramohan.learn.graphql.netflixdgs.repositories.ReviewsRepository
import com.bschandramohan.learn.graphql.netflixdgs.types.Review
import com.bschandramohan.learn.graphql.netflixdgs.types.ReviewInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class ReviewMutation(val reviewsRepository: ReviewsRepository, val coursesRepository: CourseRepository) {

    @DgsMutation
    fun addReview(@InputArgument reviewInput: ReviewInput): Review {
        val addedReview = reviewsRepository.addReview(reviewInput)
        // If successfully added review, also update the course reviews
        if (addedReview.id != null) {
            coursesRepository.courses.first { it.id == reviewInput.courseId }.reviews.add(addedReview.id)
        }

        return addedReview
    }
}
