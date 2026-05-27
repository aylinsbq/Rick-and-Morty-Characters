package com.arkano.androidChallenge.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.arkano.androidChallenge.R

@Composable
fun CoilImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.ic_outline_photo),
        error = painterResource(R.drawable.ic_android_black)
    )

}
