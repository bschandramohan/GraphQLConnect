package com.bschandramohan.learn.graphql.netflixdgs.mappers

import com.bschandramohan.learn.graphql.netflixdgs.models.CourseModel
import com.bschandramohan.learn.graphql.netflixdgs.repositories.ReviewsRepository
import com.bschandramohan.learn.graphql.netflixdgs.repositories.TrainerRepository
import com.bschandramohan.learn.graphql.netflixdgs.types.Course

fun CourseModel.toCourse(trainerRepository: TrainerRepository, reviewRepository: ReviewsRepository) : Course {
    val trainersList = this.trainers.map {
        trainerRepository.getTrainer(it)?.toTrainer()
    }

    val reviewList = this.reviews.map {
        reviewRepository.getReview(it)?.toReview()
    }

    return Course(title = this.title, trainer = trainersList, review = reviewList)
}

fun List<CourseModel>.toCourseList(trainerRepository: TrainerRepository, reviewRepository: ReviewsRepository) = map {
    it.toCourse(trainerRepository, reviewRepository)
}
