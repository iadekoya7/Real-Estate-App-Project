package com.mad.real_estate_app.util

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mad.real_estate_app.R

@Composable
inline fun AppButton(
    modifier: Modifier = Modifier,
    noinline onClick: () -> Unit,
    crossinline content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .height(50.dp)
            .fillMaxWidth(0.8f)
            .then(modifier),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(R.color.colorAccentContrast),
            contentColor = colorResource(R.color.white),
        ),
        onClick = onClick
    ) {
        content()
    }
}

@Composable
inline fun AppSecondButton(
    modifier: Modifier = Modifier,
    noinline onClick: () -> Unit,
    crossinline content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .height(50.dp)
            .fillMaxWidth(0.8f)
            .then(modifier),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(R.color.white),
            contentColor = colorResource(R.color.colorAccentContrast),
        ),
        onClick = onClick
    ) {
        content()
    }
}