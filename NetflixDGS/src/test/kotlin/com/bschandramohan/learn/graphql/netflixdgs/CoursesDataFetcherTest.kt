package com.bschandramohan.learn.graphql.netflixdgs

import com.bschandramohan.learn.graphql.netflixdgs.datafetchers.CoursesDataFetcher
import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DgsAutoConfiguration::class, CoursesDataFetcher::class])
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
}
