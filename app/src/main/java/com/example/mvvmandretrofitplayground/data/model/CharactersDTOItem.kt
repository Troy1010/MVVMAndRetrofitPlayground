package com.example.mvvmandretrofitplayground.data.model

data class CharactersDTOItem(
    val age: String,
    val gender: String,
    val homePlanet: String,
    val id: Int,
    val images: Images,
    val name: Name,
    val occupation: String,
    val sayings: List<String>,
    val species: String
)