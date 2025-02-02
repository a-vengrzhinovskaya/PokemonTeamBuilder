package com.example.pokemonteambuilder.ui.pokemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokemonteambuilder.ui.theme.Typography
import com.example.pokemonteambuilder.ui.theme.mediumDp

private const val CONVERTION_COEF = 10

@Composable
fun AboutItem(
    modifier: Modifier = Modifier,
    iconId: Int,
    value: Int,
    metrics: String,
    text: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(mediumDp)
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = iconId),
                tint = Color.Black,
                contentDescription = null
            )
            Text(
                style = Typography.bodySmall,
                text = "${value / CONVERTION_COEF} $metrics",
            )
        }
        Text(
            modifier = Modifier.weight(1f),
            style = Typography.labelMedium,
            text = text,
            color = Color.Gray
        )
    }
}