package com.bschandramohan.learn.graphql.netflixdgs.repositories

import com.bschandramohan.learn.graphql.netflixdgs.models.TrainerModel
import org.springframework.stereotype.Repository

@Repository
class TrainerRepository {
    private val trainers = listOf(
        TrainerModel(id="t1", name="Chandra"),
        TrainerModel(id="t2", name="Mohan")
    )

    fun getTrainersList() = trainers

    fun getTrainer(id: String) = trainers.firstOrNull { it.id == id }
}
