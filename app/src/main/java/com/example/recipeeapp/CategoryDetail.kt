package com.example.recipeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter

@Composable
fun Detail(category: Category){
    Column (modifier=Modifier.fillMaxSize()){


            Image(
                painter = rememberAsyncImagePainter(model =category.strCategoryThumb),
                contentDescription = "Image",
                modifier = Modifier
                    .aspectRatio(1f)
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Text(text = category.strCategoryDescription)
                }
            }
    }
}
