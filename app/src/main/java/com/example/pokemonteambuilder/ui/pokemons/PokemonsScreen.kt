package com.example.pokemonteambuilder.ui.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.pokemonteambuilder.ui.common.components.MediumSpacer
import com.example.pokemonteambuilder.ui.pokemon.PokemonScreen
import com.example.pokemonteambuilder.ui.pokemons.components.PokemonItem
import com.example.pokemonteambuilder.ui.theme.smallDp
import org.koin.androidx.compose.koinViewModel

class PokemonsScreen() : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokemonsViewModel>()
        val state by viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            viewModel.fetchPokemons()
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Pokemons")
                    }
                )
            }
        ) {
            PokemonScreenBody(
                state = state,
                onPokemonClick = remember { { navigator.push(PokemonScreen(it)) } },
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Composable
private fun PokemonScreenBody(
    state: PokemonsScreenState,
    onPokemonClick: (String) -> Unit,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(smallDp),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(state.pokemons) {
                    PokemonItem(
                        pokemon = it,
                        onPokemonClick = onPokemonClick,
                    )
                    MediumSpacer()
                }
            }
        }
    }
}