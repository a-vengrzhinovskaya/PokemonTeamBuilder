package com.example.pokemonteambuilder.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfoResponse(
    val cries: Cries,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
    @Serializable
    data class Cries(
        val latest: String
    )

    @Serializable
    data class Sprites(
        @SerialName("front_default")
        val frontDefault: String,
        val other: Other
    ) {
        @Serializable
        data class Other(
            @SerialName("official-artwork")
            val officialArtwork: OfficialArtwork
        ) {
            @Serializable
            data class OfficialArtwork(
                @SerialName("front_default")
                val frontDefault: String,
                @SerialName("front_shiny")
                val frontShiny: String
            )
        }
    }

    @Serializable
    data class Stat(
        @SerialName("base_stat")
        val baseStat: Int,
        val stat: Stat
    ) {
        @Serializable
        data class Stat(
            val name: String
        )
    }

    @Serializable
    data class Type(
        val type: Type
    ) {
        @Serializable
        data class Type(
            val name: String,
            val url: String
        )
    }
}