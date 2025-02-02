package com.example.pokemonteambuilder.data.network

import com.example.pokemonteambuilder.data.network.models.PokemonInfoResponse
import com.example.pokemonteambuilder.data.network.models.PokemonsResponse
import com.example.pokemonteambuilder.data.network.models.PokemonSpeciesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonsResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): PokemonInfoResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpeciesByName(@Path("name") name: String): PokemonSpeciesResponse
}