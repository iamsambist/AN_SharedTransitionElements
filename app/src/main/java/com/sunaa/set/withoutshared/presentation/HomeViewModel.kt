package com.sunaa.set.withoutshared.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sunaa.set.withoutshared.data.DataSource

class HomeViewModel : ViewModel() {
    private var dataSource: DataSource = DataSource()

    val listItemsState = mutableStateOf(dataSource.getListOfItems())

    // collecting mutableStateOf in Composable we use observeAsState

}