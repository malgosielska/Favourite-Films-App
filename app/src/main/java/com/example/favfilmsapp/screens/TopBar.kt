package com.example.favfilmsapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.favfilmsapp.ui.theme.background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar(title: String) {
    Surface(
        color = MaterialTheme.colorScheme.secondary // Kolor top baru
    ) {
        TopAppBar(
            modifier = Modifier
                .padding(10.dp)
                .height(30.dp),
            // Wysokość top baru
            // Przezroczyste tło top baru
            title = {
                Text(
                    text = title,
                    color = Color.White// Kolor tekstu
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary )
        )
    }
}