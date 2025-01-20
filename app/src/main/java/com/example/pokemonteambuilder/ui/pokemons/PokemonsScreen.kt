package com.example.pokemonteambuilder.ui.pokemons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.example.pokemonteambuilder.ui.common.components.MediumSpacer
import com.example.pokemonteambuilder.ui.pokemons.components.PokemonItem
import com.example.pokemonteambuilder.ui.theme.smallDp
import org.koin.androidx.compose.koinViewModel

class PokemonsScreen() : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokemonsViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.fetchPokemons(offset = 0, limit = 20)
        }

        PokemonScreenBody(
            state = state,
            onPokemonClick = { viewModel.onPokemonClick() },
            onAddToPartyClick = { viewModel.onAddToPartyClick() }
        )
    }
}

@Composable
private fun PokemonScreenBody(
    state: PokemonsScreenState,
    onPokemonClick: () -> Unit = {},
    onAddToPartyClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(smallDp)
    ) {
        Text(text = "All Pokemon")

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