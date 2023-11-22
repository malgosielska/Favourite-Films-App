package com.example.favfilmsapp.screens

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.favfilmsapp.ui.theme.Typography
import com.example.favfilmsapp.ui.theme.topBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar(title: String) {
    Surface(
        color = topBar
    ) {
        TopAppBar(
            modifier = Modifier
                .padding(10.dp)
                .heightIn(min = 25.dp, max = 35.dp),

            title = {
                Text(
                    text = title,
                    style = Typography.titleLarge
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topBar)
        )
    }
}