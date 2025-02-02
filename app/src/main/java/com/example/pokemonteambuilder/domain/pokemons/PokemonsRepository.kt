package com.example.pokemonteambuilder.domain.pokemons

import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {
    fun getPokemons(offset: Int, limit: Int): Flow<List<Pokemon>>

    fun getPokemonByName(name: String): Flow<Pokemon>
}