package com.example.pokemonteambuilder.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.pokemonteambuilder.ui.theme.mediumDp
import com.example.pokemonteambuilder.ui.theme.smallDp

@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(mediumDp))
            .clip(shape = RoundedCornerShape(mediumDp))
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(smallDp)
            .then(modifier)
    ) {
        content()
    }
}