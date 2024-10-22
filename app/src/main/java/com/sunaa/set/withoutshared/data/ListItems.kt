package com.sunaa.set.withoutshared.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ListItems(
    @StringRes val itemName: Int,
    @DrawableRes val itemLogo: Int,
    @StringRes val itemDes: Int
)

// these annotation provide helpful compile time checks to ensure that correct resource ID is passed to
// Create an object of ListItems
