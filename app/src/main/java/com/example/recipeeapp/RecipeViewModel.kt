package com.example.recipeeapp
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import kotlinx.coroutines.launch

class RecipeViewModel:ViewModel() {
    init {
        fetchcategories()
    }
   private fun fetchcategories(){
       viewModelScope.launch {   //Coroutine Scope is needed to call a suspend function
            try {
                val categorylist= recipeservice.getcategories()
                _categoryState.value=_categoryState.value.copy(loading=false,
                Error=null,
                list=categorylist.categories)  //WE CANNOT USE categorystate instead of _categorystate BECAUSE CHANGING categorystate WILL CHANGE THE value of private variable _categorystate
            }
            catch (e:Exception){
                _categoryState.value=_categoryState.value.copy(loading=false,
                    Error="${e.message}")
            }
       }
   }

    data class RecipeState(val loading:Boolean=true,
                            val Error:String?=null,
                            val list:List<Category> = emptyList()

    )

    private val _categoryState= mutableStateOf(RecipeState())
    val categoryState:State<RecipeState> =_categoryState  //IMPORT THE RIGHT State

}