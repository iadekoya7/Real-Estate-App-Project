package com.mad.real_estate_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mad.real_estate_app.R
import com.mad.real_estate_app.data.HouseViewModel
import com.mad.real_estate_app.util.RealEstateAppBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    val title = stringResource(id = R.string.listings)
    val houseVM: HouseViewModel = viewModel()
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
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

}
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    Real_Estate_AppTheme {
//        HomeScreen()
//    }
//}