package com.example.pokemonteambuilder.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesResponse(
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,
    @SerialName("is_baby")
    val isBaby: Boolean,
    @SerialName("is_legendary")
    val isLegendary: Boolean,
    @SerialName("is_mythical")
    val isMythical: Boolean
) {
    @Serializable
    data class FlavorTextEntry(
        @SerialName("flavor_text")
        val flavorText: String,
        val language: Language
    ) {
        @Serializable
        data class Language(
            val name: String
        )
    }
}