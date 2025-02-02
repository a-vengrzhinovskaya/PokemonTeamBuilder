package com.example.pokemonteambuilder.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokemonteambuilder.R
import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.ui.theme.BugTypeColor
import com.example.pokemonteambuilder.ui.theme.DarkTypeColor
import com.example.pokemonteambuilder.ui.theme.DragonTypeColor
import com.example.pokemonteambuilder.ui.theme.ElectricTypeColor
import com.example.pokemonteambuilder.ui.theme.FairyTypeColor
import com.example.pokemonteambuilder.ui.theme.FightingTypeColor
import com.example.pokemonteambuilder.ui.theme.FireTypeColor
import com.example.pokemonteambuilder.ui.theme.FlyingTypeColor
import com.example.pokemonteambuilder.ui.theme.GhostTypeColor
import com.example.pokemonteambuilder.ui.theme.GrassTypeColor
import com.example.pokemonteambuilder.ui.theme.GroundTypeColor
import com.example.pokemonteambuilder.ui.theme.IceTypeColor
import com.example.pokemonteambuilder.ui.theme.NormalTypeColor
import com.example.pokemonteambuilder.ui.theme.PoisonTypeColor
import com.example.pokemonteambuilder.ui.theme.PsychicTypeColor
import com.example.pokemonteambuilder.ui.theme.RockTypeColor
import com.example.pokemonteambuilder.ui.theme.SteelTypeColor
import com.example.pokemonteambuilder.ui.theme.Typography
import com.example.pokemonteambuilder.ui.theme.WaterTypeColor
import com.example.pokemonteambuilder.ui.theme.extraSmallDp
import com.example.pokemonteambuilder.ui.theme.mediumDp

@Composable
fun TypeItem(type: PokemonType) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(mediumDp))
            .background(
                color = when (type) {
                    PokemonType.NORMAL -> NormalTypeColor
                    PokemonType.FIGHTING -> FightingTypeColor
                    PokemonType.FLYING -> FlyingTypeColor
                    PokemonType.POISON -> PoisonTypeColor
                    PokemonType.GROUND -> GroundTypeColor
                    PokemonType.ROCK -> RockTypeColor
                    PokemonType.BUG -> BugTypeColor
                    PokemonType.GHOST -> GhostTypeColor
                    PokemonType.STEEL -> SteelTypeColor
                    PokemonType.FIRE -> FireTypeColor
                    PokemonType.WATER -> WaterTypeColor
                    PokemonType.GRASS -> GrassTypeColor
                    PokemonType.ELECTRIC -> ElectricTypeColor
                    PokemonType.PSYCHIC -> PsychicTypeColor
                    PokemonType.ICE -> IceTypeColor
                    PokemonType.DRAGON -> DragonTypeColor
                    PokemonType.DARK -> DarkTypeColor
                    PokemonType.FAIRY -> FairyTypeColor
                }
            )
            .padding(extraSmallDp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(
                id = when (type) {
                    PokemonType.NORMAL -> R.drawable.ic_type_normal
                    PokemonType.FIGHTING -> R.drawable.ic_type_fighting
                    PokemonType.FLYING -> R.drawable.ic_type_flying
                    PokemonType.POISON -> R.drawable.ic_type_poison
                    PokemonType.GROUND -> R.drawable.ic_type_ground
                    PokemonType.ROCK -> R.drawable.ic_type_rock
                    PokemonType.BUG -> R.drawable.ic_type_bug
                    PokemonType.GHOST -> R.drawable.ic_type_ghost
                    PokemonType.STEEL -> R.drawable.ic_type_steel
                    PokemonType.FIRE -> R.drawable.ic_type_fire
                    PokemonType.WATER -> R.drawable.ic_type_water
                    PokemonType.GRASS -> R.drawable.ic_type_grass
                    PokemonType.ELECTRIC -> R.drawable.ic_type_electric
                    PokemonType.PSYCHIC -> R.drawable.ic_type_psychic
                    PokemonType.ICE -> R.drawable.ic_type_ice
                    PokemonType.DRAGON -> R.drawable.ic_type_dragon
                    PokemonType.DARK -> R.drawable.ic_type_dark
                    PokemonType.FAIRY -> R.drawable.ic_type_fairy
                }
            ),
            tint = Color.White,
            contentDescription = null
        )

        ExtraSmallSpacer()

        Text(
            style = Typography.labelLarge,
            text = type.toString(),
            color = Color.White
        )
    }
}