package com.bschandramohan.learn.graphql.netflixdgs.datafetchers

import com.bschandramohan.learn.graphql.netflixdgs.mappers.toCourseList
import com.bschandramohan.learn.graphql.netflixdgs.repositories.CourseRepository
import com.bschandramohan.learn.graphql.netflixdgs.repositories.ReviewsRepository
import com.bschandramohan.learn.graphql.netflixdgs.repositories.TrainerRepository
import com.bschandramohan.learn.graphql.netflixdgs.types.Course
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class CoursesDataFetcher(val courseRepository: CourseRepository,
                         val trainerRepository: TrainerRepository,
                         val reviewRepository: ReviewsRepository) {

    @DgsQuery
    fun courses(@InputArgument courseTitle: String?): List<Course> {
        val courses = courseRepository.getCoursesList()
        if (courseTitle != null)
            return courses.filter { it.title == courseTitle }.toCourseList(trainerRepository, reviewRepository)

        return courses.toCourseList(trainerRepository, reviewRepository)
    }

    @DgsQuery
    fun coursesByTitle(@InputArgument title: String): List<Course> {
        val courses = courseRepository.getCoursesList()
        return courses.filter { it.title == title }.toCourseList(trainerRepository, reviewRepository)
    }
}
