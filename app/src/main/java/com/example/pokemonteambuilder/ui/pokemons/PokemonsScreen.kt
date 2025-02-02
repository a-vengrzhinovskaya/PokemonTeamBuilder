package com.example.pokemonteambuilder.ui.pokemons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.pokemonteambuilder.ui.common.components.MediumSpacer
import com.example.pokemonteambuilder.ui.common.models.PokemonUI
import com.example.pokemonteambuilder.ui.pokemon.PokemonScreen
import com.example.pokemonteambuilder.ui.pokemons.components.PokemonItem
import com.example.pokemonteambuilder.ui.theme.smallDp
import org.koin.androidx.compose.koinViewModel

class PokemonsScreen() : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokemonsViewModel>()
        val state by viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            viewModel.fetchPokemons()
        }

        PokemonScreenBody(
            state = state,
            onPokemonClick = remember { { navigator.push(PokemonScreen(it)) } },
            onAddToPartyClick = { viewModel.onAddToPartyClick() }
        )
    }
}

@Composable
private fun PokemonScreenBody(
    state: PokemonsScreenState,
    onPokemonClick: (String) -> Unit,
    onAddToPartyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(smallDp)
    ) {
        LazyColumn {
            items(state.pokemons) {
                PokemonItem(
                    pokemon = it,
                    onPokemonClick = onPokemonClick,
                    onAddToPartyClick = onAddToPartyClick
                )
                MediumSpacer()
            }
        }
    }
}