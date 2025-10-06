package com.example.pokemonteambuilder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.pokemonteambuilder.ui.home.HomeScreen
import com.example.pokemonteambuilder.ui.pokemons.PokemonsScreen
import com.example.pokemonteambuilder.ui.theme.PokemonTeamBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonTeamBuilderTheme {
                Navigator(HomeScreen())
            }
        }
    }
}