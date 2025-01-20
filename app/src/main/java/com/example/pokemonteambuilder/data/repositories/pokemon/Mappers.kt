package com.example.pokemonteambuilder.data.repositories.pokemon

import com.example.pokemonteambuilder.data.network.models.PokemonInfoResponse
import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon

fun PokemonInfoResponse.toDomain() = Pokemon(
    name = name.replaceFirstChar(Char::titlecase),
    number = order,
    firstType = PokemonType.valueOf(types.first().type.name.uppercase()),
    secondType = types.getOrNull(1)?.type?.let { PokemonType.valueOf(it.name.uppercase()) },
    imageUrl = sprites.frontDefault,
    cryUrl = cries.latest,
    stats = stats.map { it.toDomain() },
    height = height,
    weight = weight
)

fun PokemonInfoResponse.Stat.toDomain() = Pokemon.PokemonStat(
    name = stat.name,
    baseStat = baseStat
)