package com.example.recipeeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//We take Category attributes with the exact same name as in the Json file so that the data mapping is possible

@Parcelize
data class Category(val idCategory:String,
                    val strCategory: String,
                    val strCategoryThumb:String,
                    val strCategoryDescription:String):Parcelable  //Parcelize is needed for passing the object of this class as argument from one screen to another


//"idCategory": "2",
//"strCategory": "Chicken",
//"strCategoryThumb": "https://www.themealdb.com/images/category/chicken.png",
//"strCategoryDescription": "Chicken is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.[1] Humans commonly keep chickens as a source of food (consuming both their meat and eggs) and, more rarely, as pets."


data class CategoryResponse(
    val categories:List<Category>  //This also has the same name as the Json file
)