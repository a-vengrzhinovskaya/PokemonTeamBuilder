package com.example.pokemonteambuilder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.pokemonteambuilder.ui.pokemons.PokemonsScreen
import com.example.pokemonteambuilder.ui.theme.PokemonTeamBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonTeamBuilderTheme {
                Navigator(PokemonsScreen())
            }
        }
    }
}