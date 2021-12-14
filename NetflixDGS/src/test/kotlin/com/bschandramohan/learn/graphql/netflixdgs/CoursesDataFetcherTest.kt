package com.bschandramohan.learn.graphql.netflixdgs

import com.bschandramohan.learn.graphql.netflixdgs.client.CoursesGraphQLQuery
import com.bschandramohan.learn.graphql.netflixdgs.client.CoursesProjectionRoot
import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CoursesDataFetcherTest {
    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun courses() {
        val titles: List<String> = dgsQueryExecutor.executeAndExtractJsonPath(
            """
                {
                    courses {
                        title 
                    }
                }
            """.trimIndent(),
            "data.courses[*].title"
        )

        assertThat(titles.size).isEqualTo(2)
    }

    @Test
    fun coursesQuery() {
        val graphQLQueryRequest = GraphQLQueryRequest(
            CoursesGraphQLQuery
                .Builder()
                .courseTitle("Amazing Python")
                .build(),
            CoursesProjectionRoot().title()
        )

        val titles: List<String> = dgsQueryExecutor.executeAndExtractJsonPath(
            graphQLQueryRequest.serialize(),
            "data.courses[*].title"
        )

        assertThat(titles.size == 1)
    }
}
