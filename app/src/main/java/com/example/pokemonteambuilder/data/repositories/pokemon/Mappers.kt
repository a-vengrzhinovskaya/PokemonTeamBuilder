package com.example.pokemonteambuilder.data.repositories.pokemon

import com.example.pokemonteambuilder.data.network.models.PokemonInfoResponse
import com.example.pokemonteambuilder.data.network.models.PokemonSpeciesResponse
import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon

fun PokemonInfoResponse.toDomain(speciesResponse: PokemonSpeciesResponse) = Pokemon(
    name = name.replaceFirstChar(Char::titlecase),
    number = order,
    description = speciesResponse.flavorTextEntries.last { it.language.name == "en" }.flavorText,
    firstType = PokemonType.valueOf(types.first().type.name.uppercase()),
    secondType = types.getOrNull(1)?.type?.let { PokemonType.valueOf(it.name.uppercase()) },
    dexImageUrl = sprites.frontDefault,
    defaultImageUrl = sprites.other.officialArtwork.frontDefault,
    shinyImageUrl = sprites.other.officialArtwork.frontShiny,
    cryUrl = cries.latest,
    stats = stats.map {
        Pair(
            Pokemon.PokemonStat.valueOf(
                it.stat.name
                    .replace('-', '_')
                    .uppercase()
            ),
            it.baseStat
        )
    },
    height = height,
    weight = weight,
    group = when {
        speciesResponse.isBaby -> Pokemon.PokemonGroup.BABY
        speciesResponse.isLegendary -> Pokemon.PokemonGroup.LEGENDARY
        speciesResponse.isMythical -> Pokemon.PokemonGroup.MYTHICAL
        else -> Pokemon.PokemonGroup.DEFAULT
    }
)