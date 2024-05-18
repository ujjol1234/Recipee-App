package com.example.recipeeapp

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeeapp.ui.theme.RecipeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeApp()
                }
            }
        }
    }
}

@Composable
fun RecipeApp() {
    val recipevm:RecipeViewModel= viewModel()
    val liststate by recipevm.categoryState
    val navcontroller= rememberNavController()

    NavHost(navController = navcontroller, startDestination ="RS" ){
        //THIS IS THE METHOD FOR PASSING CLAS OBJECTS FROM ONE SCREEN TO ANOTHER
        composable("RS"){
            Recipescreen(navigatetodetail = {
                navcontroller.currentBackStackEntry?.savedStateHandle?.set("c",it)
                navcontroller.navigate("CD")
            })
        }
        composable("CD"){
            val cat= navcontroller.previousBackStackEntry?.savedStateHandle?.get<Category>("c")?: Category("","",
                "","")
            Detail(category = cat)
        }
    }

}


