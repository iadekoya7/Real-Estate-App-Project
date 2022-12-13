package com.mad.real_estate_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.mad.real_estate_app.R
import com.mad.real_estate_app.data.DataState
import com.mad.real_estate_app.data.House
import com.mad.real_estate_app.data.HouseViewModel
import com.mad.real_estate_app.presentation.Routes
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme
import com.mad.real_estate_app.util.RealEstateAppBar


@Composable
fun HomeScreen(
    navController: NavController
) {
    val title = stringResource(id = R.string.listings)
    val houseVM: HouseViewModel = viewModel()
//    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .verticalScroll(scrollState)
    ) {
        RealEstateAppBar(
            navController  = navController,
            title = title,
            onBackPressed = { navController.popBackStack()
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        showListings(houseVM)
    }
}

@Composable
fun showListings(viewModel: HouseViewModel)
{
    when(val result = viewModel.response.value){
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        is DataState.Success -> {
            displayHouses(result.data)
        }

        is DataState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = result.message,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(id = R.string.listingserror),
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
            }
        }
    }
}
@Composable
fun displayHouses(houses: MutableList<House>) {
    LazyColumn {
        items(houses){ house ->
            displayHouse(house)
        }
    }
}

@Composable
fun displayHouse(house: House) {
Card(
    modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(10.dp)
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = rememberImagePainter(house.Image),
            modifier = Modifier.fillMaxSize(),
            contentDescription = house.Description,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = house.Description!!,
            fontSize = MaterialTheme.typography.h5.fontSize,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.LightGray),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            text = house.Price!!.toString(),
            fontSize = MaterialTheme.typography.h6.fontSize,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.LightGray),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
 }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    Real_Estate_AppTheme {
//        HomeScreen()
//    }
//}