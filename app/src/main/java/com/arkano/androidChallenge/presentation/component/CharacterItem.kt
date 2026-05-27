package com.arkano.androidChallenge.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.arkano.androidChallenge.ui.theme.RickAndMortyCharactersTheme
import com.arkano.domain.model.Character
import com.arkano.domain.model.CharacterStatus

@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${character.status}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (character.status == CharacterStatus.ALIVE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterItemAlivePreview() {
    val character = Character(
        id = 1,
        name = "Rick Sanchez",
        status = CharacterStatus.ALIVE,
        image = "")
    RickAndMortyCharactersTheme {
        CharacterItem(character = character)
    }
}
@Preview
@Composable
fun CharacterItemDeadPreview() {
    val character = Character(
        id = 1,
        name = "Rick Sanchez",
        status = CharacterStatus.DEAD,
        image = "")
    RickAndMortyCharactersTheme {
        CharacterItem(character = character)
    }
}
