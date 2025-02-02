package com.example.pokemonteambuilder.ui.pokemons

import androidx.lifecycle.viewModelScope
import com.example.pokemonteambuilder.domain.pokemons.PokemonsRepository
import com.example.pokemonteambuilder.ui.common.StateViewModel
import com.example.pokemonteambuilder.ui.common.toPokemonUI
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val POKEMONS_PER_PAGE = 20

class PokemonsViewModel(
    private val pokemonsRepository: PokemonsRepository
) : StateViewModel<PokemonsScreenState>(PokemonsScreenState()) {
    fun fetchPokemons() {
        viewModelScope.launch {
            pokemonsRepository.getPokemons(
                offset = state.value.offset,
                limit = POKEMONS_PER_PAGE
            ).collectLatest { pokemons ->
                _state.update {
                    it.copy(
                        pokemons = pokemons.map { pokemon -> pokemon.toPokemonUI() }
                    )
                }
            }
        }
    }

    fun onPokemonClick() {
        TODO("Not yet implemented")
    }

    fun onAddToPartyClick() {
        TODO("Not yet implemented")
    }
}