package com.mad.real_estate_app.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mad.real_estate_app.R
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme
import com.mad.real_estate_app.util.AppButton
import com.mad.real_estate_app.util.RealEstateAppBar

@Composable
fun SignUpScreen(
    navController: NavController
){

    val scrollState = rememberScrollState()
    val title = stringResource(id = R.string.sign_up)
    var firstNameString by remember { mutableStateOf("") }
    var lastNameString by remember { mutableStateOf("") }
    var emailAddressString by remember { mutableStateOf("") }
    val accountList = listOf("LandLord", "Tenant")
    var passwordString by remember{ mutableStateOf("") }
    var expanded by remember{ mutableStateOf(false) }
    var accountExpanded by remember{ mutableStateOf(false) }
    val list = listOf("Male", "Female")
    var selectedItem by remember { mutableStateOf("") }
    var accountSelectedItem by remember{ mutableStateOf("") }
    var textFiledSize by remember { mutableStateOf(Size.Zero) }
    var accountTextFiledSize by remember{ mutableStateOf(Size.Zero) }
    var passwordVisibility by remember { mutableStateOf(false) }
    val passwordIcon = if (passwordVisibility){
        Icons.Filled.Visibility
    } else {
        Icons.Filled.VisibilityOff
    }

    val icon = if(expanded){
        Icons.Filled.KeyboardArrowUp
    } else{
        Icons.Filled.KeyboardArrowDown
    }
    val accountIcon = if(accountExpanded){
        Icons.Filled.KeyboardArrowUp
    } else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
    ){
        RealEstateAppBar(
            title = title,
            onBackPressed = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.create_account),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
        )
        OutlinedTextField (
            label = { Text(text = stringResource(id = R.string.first_name)) },
            value = firstNameString,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            onValueChange = { firstNameString = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            singleLine = true
        )
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.last_name))},
            value = lastNameString,
            onValueChange = {lastNameString = it},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            singleLine = true
        )
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = stringResource(id = R.string.gender))},
            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = "",
                    Modifier.clickable {
                        expanded = !expanded
                    }
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current){
                    textFiledSize.width.toDp()
                })
        ) {
            list.forEach{ gender ->
                DropdownMenuItem(onClick = {
                    selectedItem = gender
                    expanded = false
                }) {
                    Text(text = gender)
                }
            }
        }
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.email_address))},
            value = emailAddressString,
            onValueChange = {emailAddressString = it},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            singleLine = true
        )
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.password))},
            value = passwordString,
            onValueChange = {passwordString = it},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
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
        OutlinedTextField(
            value = accountSelectedItem,
            onValueChange = {accountSelectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .onGloballyPositioned { coordinates ->
                    accountTextFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = stringResource(id = R.string.account_type))},
            trailingIcon = {
                Icon(
                    accountIcon,
                    contentDescription = "",
                    Modifier.clickable {
                        accountExpanded = !accountExpanded
                    }
                )
            }
        )
        DropdownMenu(
            expanded = accountExpanded,
            onDismissRequest = {accountExpanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current){
                    accountTextFiledSize.width.toDp()
                })
        ) {
            accountList.forEach{ accountType ->
                DropdownMenuItem(onClick = {
                    accountSelectedItem = accountType
                    accountExpanded = false
                }) {
                    Text(text = accountType)
                }
            }
        }
        AppButton(
            onClick = {
                navController.navigate(Routes.SignUpScreen.route)
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Real_Estate_AppTheme {
        SignUpScreen(navController = rememberNavController())
    }
}