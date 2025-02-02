package com.example.pokemonteambuilder.ui.pokemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokemonteambuilder.ui.common.components.MediumSpacer
import com.example.pokemonteambuilder.ui.common.toPokemonNumberString
import com.example.pokemonteambuilder.ui.theme.Typography

@Composable
fun PokemonTopBar(
    modifier: Modifier = Modifier,
    name: String,
    number: Int,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(20.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.size(32.dp), onClick = onBackClick
        ) {
            Box {
                Icon(
                    modifier = Modifier
                        .offset(x = 2.dp, y = 2.dp)
                        .blur(2.dp),
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = Color(red = 0, green = 0, blue = 0, alpha = 40)
                ) // this icon is used to make shadow effect
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        MediumSpacer()

        Text(
            style = Typography.headlineMedium,
            text = name,
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            style = Typography.titleMedium,
            text = "#${number.toPokemonNumberString()}",
            color = Color.White
        )
    }
}