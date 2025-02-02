package com.example.pokemonteambuilder.ui.pokemon

import androidx.lifecycle.viewModelScope
import com.example.pokemonteambuilder.domain.pokemons.PokemonsRepository
import com.example.pokemonteambuilder.ui.common.StateViewModel
import com.example.pokemonteambuilder.ui.common.toPokemonUI
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val pokemonsRepository: PokemonsRepository
) : StateViewModel<PokemonScreenState>(PokemonScreenState()) {
    fun fetchPokemon(name: String) {
        viewModelScope.launch {
            pokemonsRepository.getPokemonByName(name).collectLatest { pokemon ->
                _state.update {
                    it.copy(
                        pokemon = pokemon.toPokemonUI()
                    )
                }
            }
        }
    }
}