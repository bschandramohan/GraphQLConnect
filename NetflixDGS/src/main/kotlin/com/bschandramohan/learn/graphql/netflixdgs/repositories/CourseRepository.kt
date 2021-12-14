package com.bschandramohan.learn.graphql.netflixdgs.repositories

import com.bschandramohan.learn.graphql.netflixdgs.models.CourseModel
import org.springframework.stereotype.Repository

@Repository
class CourseRepository {
    var courses = mutableListOf(
        CourseModel(id="c1", title="Amazing Python", trainers = mutableListOf("t1", "t2"), reviews = mutableListOf("r1")),
        CourseModel(id="c2", title = "Kotlin for everyone", trainers = mutableListOf("t1"), reviews = mutableListOf("r1", "r2"))
    )

    fun getCoursesList() = courses
}
