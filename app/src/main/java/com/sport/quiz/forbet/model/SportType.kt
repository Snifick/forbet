package com.sport.quiz.forbet.model

sealed class SportType(val type:String) {

    data object Football: SportType("Football")
    data object Basketball: SportType("Basketball")
    data object Tennis: SportType("Tennis")
    data object Box: SportType("Box")
    data object Cybersport: SportType("Cybersport")
}