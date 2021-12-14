package com.bschandramohan.learn.graphql.netflixdgs.mappers

import com.bschandramohan.learn.graphql.netflixdgs.models.TrainerModel
import com.bschandramohan.learn.graphql.netflixdgs.types.Trainer

fun TrainerModel.toTrainer() = Trainer(
    id = this.id,
    name = this.name,
    dob = this.dob,
    email = this.email,
    gender = this.gender
)

fun List<TrainerModel>.toTrainerList() = map {
    it.toTrainer()
}
