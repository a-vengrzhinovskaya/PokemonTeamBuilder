package com.example.pokemonteambuilder.ui.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import com.example.pokemonteambuilder.R
import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon
import com.example.pokemonteambuilder.ui.common.components.PrimaryCard
import com.example.pokemonteambuilder.ui.common.components.TypeItem
import com.example.pokemonteambuilder.ui.common.models.PokemonUI
import com.example.pokemonteambuilder.ui.common.toPokemonStatString
import com.example.pokemonteambuilder.ui.pokemon.components.AboutItem
import com.example.pokemonteambuilder.ui.pokemon.components.PokemonTopBar
import com.example.pokemonteambuilder.ui.theme.PokemonTeamBuilderTheme
import com.example.pokemonteambuilder.ui.theme.Typography
import com.example.pokemonteambuilder.ui.theme.extraLargeDp
import com.example.pokemonteambuilder.ui.theme.mediumDp
import com.example.pokemonteambuilder.ui.theme.smallDp
import org.koin.androidx.compose.koinViewModel

class PokemonScreen(val name: String) : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokemonViewModel>()
        val state by viewModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            viewModel.fetchPokemon(name)
        }

        PokemonScreenBody(
            pokemon = state.pokemon,
            onBackClick = remember { { navigator.pop() } }
        )
    }
}

@Composable
private fun PokemonScreenBody(
    pokemon: PokemonUI,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            PokemonTopBar(
                name = pokemon.name,
                number = pokemon.number,
                onBackClick = onBackClick
            )
        },
        containerColor = pokemon.typeColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Box(Modifier.weight(1f).fillMaxWidth()) {
                Icon(
                    modifier = Modifier
                        .size(208.dp)
                        .offset(x = 48.dp, y = -64.dp)
                        .align(Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.ic_pokeball_filled),
                    tint = Color.White.copy(alpha = 0.2f),
                    contentDescription = null
                )

                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.defaultImageUrl)
                        .build(),
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator(modifier = Modifier.size(40.dp))
                    },
                    contentDescription = null
                )
            }

            PrimaryCard {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    verticalArrangement = Arrangement.spacedBy(extraLargeDp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(extraLargeDp)
                    ) {
                        TypeItem(type = pokemon.firstType)
                        pokemon.secondType?.let { TypeItem(type = it) }
                    }

                    Text(
                        style = Typography.titleLarge,
                        text = "About",
                        color = pokemon.typeColor
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AboutItem(
                            modifier = Modifier.fillMaxHeight(),
                            iconId = R.drawable.ic_weight,
                            value = pokemon.weight,
                            metrics = "kg",
                            text = "Weight"
                        )

                        VerticalDivider(modifier = Modifier.fillMaxHeight())

                        AboutItem(
                            modifier = Modifier.fillMaxHeight(),
                            iconId = R.drawable.ic_height,
                            value = pokemon.height,
                            metrics = "m",
                            text = "Height"
                        )

                        VerticalDivider(modifier = Modifier.fillMaxHeight())

                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(
                                modifier = Modifier.size(32.dp),
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Outlined.PlayArrow,
                                    tint = Color.Black,
                                    contentDescription = null
                                )
                            }
                            Text(
                                style = Typography.labelMedium,
                                modifier = Modifier.weight(1f),
                                text = "Cry", color = Color.Gray
                            )
                        }
                    }

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = Typography.bodySmall,
                        text = pokemon.description,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        style = Typography.titleLarge,
                        text = "Base Stats",
                        color = pokemon.typeColor
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(mediumDp)
                    ) {
                        Column(
                            modifier = Modifier.width(IntrinsicSize.Min),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            pokemon.stats.map { it.first }.forEach {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = it.shortName,
                                    color = pokemon.typeColor,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }

                        VerticalDivider(modifier = Modifier.fillMaxHeight())

                        Column(
                            modifier = Modifier.width(IntrinsicSize.Min),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            pokemon.stats.map { it.second }.forEach {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = it.toPokemonStatString(),
                                    textAlign = TextAlign.End
                                )
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            pokemon.stats.map { it.second }.forEach {
                                Row(
                                    modifier = Modifier.padding(smallDp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    LinearProgressIndicator(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(8.dp)
                                            .clip(RoundedCornerShape(smallDp)),
                                        progress = { it / 252f },
                                        color = pokemon.typeColor,
                                        trackColor = pokemon.typeColor.copy(alpha = 0.2f)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun PokemonScreenPreview() {
    PokemonTeamBuilderTheme {
        PokemonScreenBody(
            pokemon = PokemonUI(
                name = "Haunter",
                number = 93,
                description = "Haunter is a dangerous Pokémon. If one beckons you while floating in darkness, you must never approach it. This Pokémon will try to lick you with its tongue and steal your life away. It strikes at humans from total darkness.",
                firstType = PokemonType.GHOST,
                secondType = PokemonType.POISON,
                weight = 94,
                height = 14,
                stats = listOf(
                    Pair(Pokemon.PokemonStat.HP, 45),
                    Pair(Pokemon.PokemonStat.ATTACK, 50),
                    Pair(Pokemon.PokemonStat.DEFENSE, 45),
                    Pair(Pokemon.PokemonStat.SPECIAL_ATTACK, 115),
                    Pair(Pokemon.PokemonStat.SPECIAL_DEFENSE, 55),
                    Pair(Pokemon.PokemonStat.SPEED, 95)
                ),
                defaultImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/93.png"
            ),
            onBackClick = { }
        )
    }
}