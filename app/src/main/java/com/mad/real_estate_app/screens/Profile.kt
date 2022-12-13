package com.mad.real_estate_app.screens


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mad.real_estate_app.R


@Composable
fun ProfileScreen()
{
    var name by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
//        RealEstateAppBar(
//            title = title,
//            onBackPressed = { navController.popBackStack() }
//        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.updateProfile),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = name,
            label = { Text(stringResource(id = R.string.fullname)) },
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = phone,
            label = { Text(stringResource(id = R.string.phone)) },
            onValueChange = { phone = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = email,
            label = { Text(stringResource(id = R.string.emailAdd)) },
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        updateButton{
            if(name == "" || phone == "" || email == ""){
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.error),
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.successMsg),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


@Composable
fun updateButton(clicked: () -> Unit){
    Button(onClick= clicked) {
        Text(stringResource(id = R.string.update))
    }
}
