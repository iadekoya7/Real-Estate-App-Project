package com.mad.real_estate_app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mad.real_estate_app.R
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme
import com.mad.real_estate_app.util.AppButton
import com.mad.real_estate_app.util.AppSecondButton

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.card_background),
            contentDescription = stringResource(id = R.string.real_estate_splash),
            modifier = Modifier
                .padding(top = 50.dp)
                .clip(RoundedCornerShape(30.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.discover_home),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
        )
        Text(
            text = stringResource(id = R.string.find_affordable),
            fontSize = 17.sp,
            softWrap = true,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily(Font(R.font.rajdhani_light)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentWidth()
                .align(CenterHorizontally)
                .padding(15.dp),
        )
        AppButton(
            onClick = {
                navController.navigate(Routes.SignUpScreen.route)
            }
        ) {
            Text(text = stringResource(id = R.string.sign_up))
        }

        AppSecondButton(
            onClick = {
                navController.navigate(Routes.LoginScreen.route)
            }
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Real_Estate_AppTheme {
        SplashScreen(navController = rememberNavController())
    }
}