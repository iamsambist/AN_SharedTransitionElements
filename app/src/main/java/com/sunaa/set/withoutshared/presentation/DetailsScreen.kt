package com.sunaa.set.withoutshared.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailsScreenView(
    itemIndex: Int,
    homeViewModel: HomeViewModel,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val context = LocalContext.current
    val currentItem = homeViewModel.listItemsState.value.get(itemIndex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        with(sharedTransitionScope){
            Column(modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Image(painter = painterResource(currentItem.itemLogo), contentDescription = "des",
                    modifier = Modifier.sharedElement(
                        rememberSharedContentState(key = "itemLogo_${itemIndex}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ))


            }
            Column(modifier = Modifier.weight(2f).padding(10.dp)) {

                Text(text = context.getString(currentItem.itemName).uppercase(), fontWeight = FontWeight.W500,
                    modifier = Modifier.sharedElement(rememberSharedContentState(key = "itemName_${itemIndex}"),
                        animatedVisibilityScope = animatedVisibilityScope))
                Text(text = context.getString(currentItem.itemDes), fontWeight = FontWeight.W200,
                    modifier = Modifier.sharedElement(
                        rememberSharedContentState(key = "itemDes_${itemIndex}"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ))


            }
        }

    }
}