package com.example.pokemonteambuilder.ui.pokemons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import com.example.pokemonteambuilder.R
import com.example.pokemonteambuilder.ui.common.components.PrimaryCard
import com.example.pokemonteambuilder.ui.common.components.TypeItem
import com.example.pokemonteambuilder.ui.pokemons.PokemonsScreenState
import com.example.pokemonteambuilder.ui.theme.extraSmallDp

@Composable
fun PokemonItem(
    pokemon: PokemonsScreenState.PokemonUI,
    onPokemonClick: () -> Unit,
    onAddToPartyClick: () -> Unit
) {
    PrimaryCard(modifier = Modifier.clickable { onPokemonClick() }) {
        Row(modifier = Modifier.fillMaxWidth()) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterVertically),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.imageUrl)
                    .build(),
                contentScale = ContentScale.Crop,
                loading = {
                    CircularProgressIndicator(modifier = Modifier.requiredSize(40.dp))
                },
                contentDescription = null
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(extraSmallDp),
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(extraSmallDp)) {
                    Text(text = pokemon.name)
                    Text(
                        text = "#${pokemon.number}",
                        color = Color.Gray
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(extraSmallDp)) {
                    TypeItem(type = pokemon.firstType)
                    pokemon.secondType?.let {
                        TypeItem(type = it)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                modifier = Modifier.size(36.dp),
                onClick = onAddToPartyClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_pokeball),
                    tint = Color.Gray,
                    contentDescription = null
                )
            }
        }
    }
}