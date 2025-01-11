package com.lihan.drinkorderapp.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.drinkorderapp.feature.home.presentation.model.DrinkUI

@Composable
fun DrinkItem(
    modifier: Modifier = Modifier,
    drink: DrinkUI? = null
) {
    drink?.let {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Image(
                    modifier = Modifier.size(73.dp),
                    painter = painterResource(drink.img),
                    contentDescription = drink.name
                )
            }
           Column(
               modifier = Modifier
                   .padding(start = 22.dp, end = 28.dp)
                   .fillMaxWidth()
                   .weight(1f),
               verticalArrangement = Arrangement.spacedBy(5.dp,Alignment.CenterVertically),
           ){
               Text(
                   text = drink.name,
                   fontSize = 20.sp,
               )
               Text(
                   text = drink.description,
                   maxLines = 2,
                   overflow = TextOverflow.Ellipsis,
                   fontSize = 10.sp,
                   lineHeight = 12.sp,
               )
           }
           Text(
               text = "$ ${drink.price}",
               fontSize = 25.sp,
               color = MaterialTheme.colorScheme.onBackground
           )
        }
    }
}