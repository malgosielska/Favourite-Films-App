package com.example.favfilmsapp.screens

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner

import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@Composable
fun VideosTab(videos: List<Int>) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    var player by remember { mutableStateOf<ExoPlayer?>(null) }

    DisposableEffect(context, lifecycle) {
        player = ExoPlayer.Builder(context).build()

        videos.forEach { video ->
            val uri = "android.resource://${context.packageName}/${video}"
            player?.addMediaItem(MediaItem.fromUri(uri))
        }

        player?.prepare()

        onDispose {
            player?.release()
        }
    }

    VideoView(lifecycle, player)
}

@Composable
fun VideoView(lifecycle: Lifecycle, player: ExoPlayer?) {
    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            }
        },
        update = { playerView ->
            playerView.player = player
            when (lifecycle.currentState) {
                Lifecycle.State.STARTED -> player?.play()
                else -> player?.pause()
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(16 / 9f)
    )
}
