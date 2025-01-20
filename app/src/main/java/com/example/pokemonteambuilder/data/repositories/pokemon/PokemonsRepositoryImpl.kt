package com.example.pokemonteambuilder.data.repositories.pokemon

import com.example.pokemonteambuilder.data.network.PokemonAPI
import com.example.pokemonteambuilder.domain.pokemons.PokemonsRepository
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class PokemonsRepositoryImpl(
    private val api: PokemonAPI,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : PokemonsRepository {
    override fun getPokemons(offset: Int, limit: Int): Flow<List<Pokemon>> = flow {
        val pokemonNames = api.getPokemons(offset, limit).results.map { it.name }
        val pokemons = pokemonNames.map { api.getPokemonByName(it).toDomain() }
        emit(pokemons)
    }.flowOn(coroutineContext)

    override fun getPokemonInfo(name: String): Flow<Pokemon> = flow {
        val pokemon = api.getPokemonByName(name).toDomain()
        emit(pokemon)
    }.flowOn(coroutineContext)
}