package com.sunaa.set.withoutshared.presentation

import android.util.Log
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sunaa.set.withoutshared.data.ListItems
import com.sunaa.set.withoutshared.navigation.ScreenNav

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreenView(
    listItems: List<ListItems>,
    coordinator: ScreenNav,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        with(sharedTransitionScope) {
            LazyColumn(modifier = Modifier.padding(10.dp)) {
                items(listItems) { item: ListItems ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                        .clickable {
                            Log.i(
                                "index",
                                listItems
                                    .indexOf(item)
                                    .toString()
                            )
                            coordinator.navigateTo("details", listItems.indexOf(item))
                        }) {
                        Column(modifier = Modifier.weight(2f)) {
                            Text(
                                text = context.getString(item.itemName).uppercase(),
                                modifier = Modifier.sharedElement(
                                    rememberSharedContentState(key = "itemName_${listItems.indexOf(item)}"),
                                    animatedVisibilityScope = animatedVisibilityScope
                                )
                            )
                            Text(
                                text = context.getString(item.itemDes),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.sharedElement(
                                    rememberSharedContentState(key = "itemDes_${listItems.indexOf(item)}"),
                                    animatedVisibilityScope = animatedVisibilityScope
                                )
                            )
                        }
                        Image(
                            painter = painterResource(item.itemLogo),
                            contentDescription = "this",
                            modifier = Modifier
                                .weight(1f)
                                .sharedElement(
                                    rememberSharedContentState(key = "itemLogo_${listItems.indexOf(item)}"),
                                    animatedVisibilityScope = animatedVisibilityScope
                                )
                        )
                    }

                }
            }
        }
    }

}
