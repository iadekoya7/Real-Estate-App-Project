package com.mad.real_estate_app.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mad.real_estate_app.R

@Composable
fun RealEstateAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackPressed: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    val appBarColor = colorResource(R.color.colorAccentContrast)

    // Draw a scrim over the status bar which matches the app bar
    Spacer(
        Modifier
            .background(appBarColor)
            .fillMaxWidth()
            .statusBarsPadding()
    )
    TopAppBar(
        modifier = modifier,
        title = {
            Row {
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .heightIn(max = 24.dp)
                )
            }
        },
        navigationIcon = if (onBackPressed != null) {
            {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary.copy(0.52f)
                    )
                }
            }
        } else null,
        elevation = 5.dp,
        actions = actions,
    )
}