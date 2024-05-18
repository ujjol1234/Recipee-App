package com.example.recipeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter


@Composable
fun Recipescreen(navigatetodetail:(Category)->Unit){
    val recipevm:RecipeViewModel= viewModel()
    val viewstate by recipevm.categoryState
   Box(modifier =Modifier.fillMaxSize() ){
       when{
           viewstate.loading->{
               CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
           }
           viewstate.Error!=null->{
               Text(text = "Error Occured! ${viewstate.Error}")
           }
           else->{
                Categoryscreen(categories = viewstate.list,navigatetodetail)
           }
       }
   }

}

@Composable
fun Categoryscreen(categories:List<Category>,navigatetodetail: (Category) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        items(categories){
            CategoryItem(cat = it,navigatetodetail)
        }
    }
}

@Composable
fun CategoryItem(cat:Category,navigatetodetail: (Category) -> Unit){
    Column (Modifier.border(width = 2.dp, color = Color.Black,shape=RoundedCornerShape(10.dp)).padding(8.dp)){
        Image(painter = rememberAsyncImagePainter(model = cat.strCategoryThumb), //rememberAsyncImagePainter  HAS COME FROM OUR IMPLEMENTATION
            contentDescription = "Image",
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clickable {navigatetodetail(cat)})
        Row {
            Text(text = cat.idCategory, modifier = Modifier.padding(8.dp))
            Text(text = cat.strCategory,modifier = Modifier.padding(8.dp), color = Color.Black, fontWeight = FontWeight.Bold)

        }

    }
}


