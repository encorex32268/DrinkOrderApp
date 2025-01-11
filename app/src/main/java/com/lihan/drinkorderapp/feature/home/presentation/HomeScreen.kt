package com.lihan.drinkorderapp.feature.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.drinkorderapp.R
import com.lihan.drinkorderapp.feature.core.domain.drinks
import com.lihan.drinkorderapp.feature.core.domain.mapper.toDrinkUI
import com.lihan.drinkorderapp.feature.home.presentation.components.DrinkCardItemBackground
import com.lihan.drinkorderapp.feature.home.presentation.components.DrinkItem
import com.lihan.drinkorderapp.feature.home.presentation.components.DrinkSearchBar
import com.lihan.drinkorderapp.feature.home.presentation.components.customTabIndicatorOffset
import com.lihan.drinkorderapp.ui.theme.DrinkOrderAppTheme

private val tabs = listOf(
    "Recommend",
    "Coffee",
    "Green Tea",
    "Fruit Juice",
    "Appetizers"
)

@Composable
fun HomeScreenRoot() {
    HomeScreen()
}

@Composable
fun HomeScreen() {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(start = 32.dp)
    ){
        item {
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Home",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            DrinkSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp,end = 32.dp , bottom = 30.dp),
                text = "",
                onValueChange = {
                    // Event : onValueChange
                }
            )

        }
        item {
            ScrollableTabRow(
                selectedTabIndex = selectedIndex,
                indicator = {
                    TabRowDefaults.PrimaryIndicator(
                        modifier = Modifier.customTabIndicatorOffset(
                            currentTabPosition = it[selectedIndex],
                            tabWidth = tabWidths[selectedIndex]
                        ),
                    )
                },
                divider = {},
                edgePadding = 0.dp
            ) {
                tabs.forEachIndexed { index, text ->
                    val selected = selectedIndex == index
                    Tab(
                        selected = selected,
                        content = {
                            Text(
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                                    .clickable {
                                        //Event Filter
                                    },
                                text = text,
                                color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                                fontSize = if (selected) 16.sp else 12.sp
                            )
                        },
                        onClick = {
                            selectedIndex = index
                        }
                    )
                }
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(items = drinks){ drink ->
                    DrinkCardItemBackground(
                        modifier = Modifier.size(width = 131.dp, height = 164.dp),
                        content = {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Image(
                                    modifier = Modifier.size(105.dp),
                                    painter = painterResource(drink.image),
                                    contentDescription = drink.name
                                )
                                Text(
                                    text = drink.name,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.background,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    )
                }
            }

        }
        item {
            Text(
                modifier = Modifier.padding(top = 36.dp , bottom = 32.dp),
                text = "Menu",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        items(
            drinks
        ){
            DrinkItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 27.dp, bottom = 40.dp),
                drink = it.toDrinkUI()
            )
        }
    }
}




@Composable
@Preview(showSystemUi = true)
private fun HomeScreenPreview(){
    DrinkOrderAppTheme {
        HomeScreen()
    }
}