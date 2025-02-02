package com.example.pokemonteambuilder.domain.pokemons.models

import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType

data class Pokemon(
    val name: String,
    val number: Int,
    val description: String,
    val firstType: PokemonType,
    val secondType: PokemonType? = null,
    val dexImageUrl: String,
    val defaultImageUrl: String,
    val shinyImageUrl: String,
    val cryUrl: String,
    val stats: List<Pair<PokemonStat, Int>>,
    val height: Int,
    val weight: Int,
    val group: PokemonGroup
) {
    enum class PokemonStat(val shortName: String) {
        HP("HP"),
        ATTACK("ATK"),
        DEFENSE("DEF"),
        SPECIAL_ATTACK("SATK"),
        SPECIAL_DEFENSE("SDEF"),
        SPEED("SPD"),
    }

    enum class PokemonGroup {
        DEFAULT,
        BABY,
        LEGENDARY,
        MYTHICAL
    }
}