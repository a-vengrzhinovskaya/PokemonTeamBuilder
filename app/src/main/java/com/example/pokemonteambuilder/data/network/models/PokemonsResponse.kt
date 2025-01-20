package com.example.pokemonteambuilder.data.network.models


import kotlinx.serialization.Serializable

@Serializable
data class PokemonsResponse(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Result>
) {
    @Serializable
    data class Result(
        val name: String
    )
}