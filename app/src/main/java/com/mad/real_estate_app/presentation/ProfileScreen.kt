package com.mad.real_estate_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mad.real_estate_app.R

@Composable
fun getInput(name: String, changed: (String) -> Unit){
    TextField(
        value = name,
        label = { Text(stringResource(id = R.string.inText)) },
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    )
}

@Composable
fun displayImage(id: Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(id = R.string.imageDescription),
        modifier = Modifier
            .padding(top = 40.dp, bottom = 40.dp)
            .size(190.dp)
            .clip(CircleShape)
    )
}