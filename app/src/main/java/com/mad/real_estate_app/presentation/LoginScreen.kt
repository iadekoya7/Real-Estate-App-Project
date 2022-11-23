package com.mad.real_estate_app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mad.real_estate_app.R
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme
import com.mad.real_estate_app.util.AppSecondButton

@Composable
fun LoginScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    var textFieldName by remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.real_estate),
            contentDescription = stringResource(id = R.string.real_estate_splash),
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
                .clip(RoundedCornerShape(35.dp))
                .padding(bottom = 10.dp)
                .fillMaxWidth(1f)
        )
        Text(

            text = stringResource(id = R.string.sign_in),
            fontSize = 30.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 0.dp)
                .fillMaxWidth()
                .align(CenterHorizontally),
        )

        NameTextField(name = textFieldName, stringResource(id = R.string.user_name), changed = { textFieldName = it })
        NameTextField(name = textFieldName, stringResource(id = R.string.password),changed = { textFieldName = it })

        AppSecondButton(
            onClick = {
                navController.popBackStack()
                navController.navigate(Routes.LoginScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}

@Composable
fun NameTextField(name: String, labels: String, changed: (String) ->Unit){
    OutlinedTextField(
        value = name,
        label = {Text(text = labels)},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 15.dp, bottom = 20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLoginScreen() {
    Real_Estate_AppTheme {
        LoginScreen(navController = rememberNavController())
    }
}