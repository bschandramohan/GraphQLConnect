package com.bschandramohan.learn.graphql.netflixdgs.datafetchers

import com.bschandramohan.learn.graphql.netflixdgs.types.Course
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class CoursesDataFetcher {
    var courses = listOf(Course(title="Amazing Python"), Course(title = "Kotlin for everyone"))

    @DgsQuery
    fun courses(@InputArgument courseTitle: String?): List<Course> {
        if (courseTitle != null)
            return courses.filter { it.title == courseTitle }

        return courses
    }
}
