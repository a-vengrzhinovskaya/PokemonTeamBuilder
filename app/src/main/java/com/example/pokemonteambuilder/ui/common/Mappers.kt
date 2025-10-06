package com.example.pokemonteambuilder.ui.common

import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon
import com.example.pokemonteambuilder.ui.common.models.PokemonUI
import com.example.pokemonteambuilder.ui.theme.BugTypeColor
import com.example.pokemonteambuilder.ui.theme.DarkTypeColor
import com.example.pokemonteambuilder.ui.theme.DragonTypeColor
import com.example.pokemonteambuilder.ui.theme.ElectricTypeColor
import com.example.pokemonteambuilder.ui.theme.FairyTypeColor
import com.example.pokemonteambuilder.ui.theme.FightingTypeColor
import com.example.pokemonteambuilder.ui.theme.FireTypeColor
import com.example.pokemonteambuilder.ui.theme.FlyingTypeColor
import com.example.pokemonteambuilder.ui.theme.GhostTypeColor
import com.example.pokemonteambuilder.ui.theme.GrassTypeColor
import com.example.pokemonteambuilder.ui.theme.GroundTypeColor
import com.example.pokemonteambuilder.ui.theme.IceTypeColor
import com.example.pokemonteambuilder.ui.theme.NormalTypeColor
import com.example.pokemonteambuilder.ui.theme.PoisonTypeColor
import com.example.pokemonteambuilder.ui.theme.PsychicTypeColor
import com.example.pokemonteambuilder.ui.theme.RockTypeColor
import com.example.pokemonteambuilder.ui.theme.SteelTypeColor
import com.example.pokemonteambuilder.ui.theme.WaterTypeColor

private const val NUMBER_STRING_LENGTH = 4
private const val STAT_STRING_LENGTH = 3
private const val VALUE_PLACEHOLDER = '0'

fun Pokemon.toPokemonUI() = PokemonUI(
    name = name,
    number = number,
    description = description,
    firstType = firstType,
    typeColor = when (firstType) {
        PokemonType.NORMAL -> NormalTypeColor
        PokemonType.FIGHTING -> FightingTypeColor
        PokemonType.FLYING -> FlyingTypeColor
        PokemonType.POISON -> PoisonTypeColor
        PokemonType.GROUND -> GroundTypeColor
        PokemonType.ROCK -> RockTypeColor
        PokemonType.BUG -> BugTypeColor
        PokemonType.GHOST -> GhostTypeColor
        PokemonType.STEEL -> SteelTypeColor
        PokemonType.FIRE -> FireTypeColor
        PokemonType.WATER -> WaterTypeColor
        PokemonType.GRASS -> GrassTypeColor
        PokemonType.ELECTRIC -> ElectricTypeColor
        PokemonType.PSYCHIC -> PsychicTypeColor
        PokemonType.ICE -> IceTypeColor
        PokemonType.DRAGON -> DragonTypeColor
        PokemonType.DARK -> DarkTypeColor
        PokemonType.FAIRY -> FairyTypeColor
    },
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