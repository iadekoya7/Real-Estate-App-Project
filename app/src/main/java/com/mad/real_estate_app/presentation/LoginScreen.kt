package com.mad.real_estate_app.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.mad.real_estate_app.R
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme
import com.mad.real_estate_app.util.AppSecondButton
import com.mad.real_estate_app.util.RealEstateAppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    var textFieldName by remember { mutableStateOf("") }
    var passwordString by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val passwordIcon = if (passwordVisibility){
        Icons.Filled.Visibility
    } else {
        Icons.Filled.VisibilityOff
    }
    val passwordIsValid = passwordString.isNotBlank()
    val emailIsValid = textFieldName.isNotBlank()
    val coroutineScope = rememberCoroutineScope()

    val loginUser : CoroutineScope.() -> Unit =
        remember(emailIsValid, passwordIsValid){
            loginUser@{
                if(!emailIsValid) {
                    Toast.makeText(context, "Email Address cannot be empty", Toast.LENGTH_LONG).show()
                    return@loginUser
                }
                if(!passwordIsValid) {
                    Toast.makeText(context, "Password cannot be empty", Toast.LENGTH_LONG).show()
                    return@loginUser
                }
                val firebaseAuth = FirebaseAuth.getInstance()
                coroutineScope.launch {
                    if(emailIsValid && passwordIsValid){
                        firebaseAuth.signInWithEmailAndPassword(
                            textFieldName,
                            passwordString
                        ).addOnCompleteListener { task->
                            if(task.isSuccessful){
                               Toast.makeText(context, task.result.toString(), Toast.LENGTH_LONG).show()
                               navController.navigate(Routes.Home.route)
                            }
                            else{
                                Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show()
                                return@addOnCompleteListener
                            }
                        }
                    }
                }
            }
        }


    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
    )
    {
        RealEstateAppBar(
            navController  = navController,
            title = "Sign In",
            onBackPressed = { navController.popBackStack() }
        )
        Image(
            painter = painterResource(id = R.drawable.real_estate),
            contentDescription = stringResource(id = R.string.real_estate_splash),
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(35.dp))
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

        NameTextField(name = textFieldName, stringResource(id = R.string.email_address), changed = { textFieldName = it })
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.password))},
            value = passwordString,
            onValueChange = {passwordString = it},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 15.dp, bottom = 10.dp)
                .align(Alignment.CenterHorizontally),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        passwordIcon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true
        )

        AppSecondButton(
            onClick = {
                coroutineScope.launch {
                    loginUser()
                }
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
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 15.dp, bottom = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLoginScreen() {
    Real_Estate_AppTheme {
        LoginScreen(navController = rememberNavController())
    }
}