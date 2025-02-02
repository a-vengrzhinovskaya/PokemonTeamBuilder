package com.example.pokemonteambuilder.ui.common

import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon
import com.example.pokemonteambuilder.ui.common.models.PokemonUI

private const val NUMBER_STRING_LENGTH = 4
private const val STAT_STRING_LENGTH = 3
private const val VALUE_PLACEHOLDER = '0'

fun Pokemon.toPokemonUI() = PokemonUI(
    name = name,
    number = number,
    description = description,
    firstType = firstType,
    secondType = secondType,
    dexImageUrl = dexImageUrl,
    defaultImageUrl = defaultImageUrl,
    shinyImageUrl = shinyImageUrl,
    cryUrl = cryUrl,
    stats = stats,
    height = height,
    weight = weight,
)

fun Int.toPokemonNumberString() = toString().padStart(NUMBER_STRING_LENGTH, VALUE_PLACEHOLDER)

fun Int.toPokemonStatString() = toString().padStart(STAT_STRING_LENGTH, VALUE_PLACEHOLDER)