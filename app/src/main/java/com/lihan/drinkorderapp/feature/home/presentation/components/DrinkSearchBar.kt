package com.lihan.drinkorderapp.feature.home.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.drinkorderapp.feature.core.presentation.SearchNormalIcon
import com.lihan.drinkorderapp.ui.theme.DrinkOrderAppTheme

@Composable
fun DrinkSearchBar(
    modifier: Modifier = Modifier,
    text: String,
    hintText: String = "Search",
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(10.dp)
        ,
        value = text,
        onValueChange = onValueChange,
        decorationBox = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = SearchNormalIcon,
                    contentDescription = "Home Search"
                )
                if(text.isEmpty()){
                    Text(
                        text = hintText,
                        fontSize = 16.sp
                    )
                }
                it()
            }
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 16.sp
        )
    )
}


@Composable
@Preview(showSystemUi = true)
private fun DrinkSearchBarPreview(){
    DrinkOrderAppTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            DrinkSearchBar(
                modifier = Modifier.fillMaxWidth(),
                text = "test",
                onValueChange = {

                }
            )

        }
    }
}