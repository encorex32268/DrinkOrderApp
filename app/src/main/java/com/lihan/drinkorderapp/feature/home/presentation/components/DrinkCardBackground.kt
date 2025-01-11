package com.lihan.drinkorderapp.feature.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.lihan.drinkorderapp.R
import com.lihan.drinkorderapp.ui.theme.DrinkOrderAppTheme

@Composable
fun DrinkCardItemBackground(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(15.dp),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = shape
            )
            .drawBehind {
                drawCircle(
                    color = Color.LightGray,
                    radius = 80f,
                    style = Stroke(width = 50f, join = StrokeJoin.Round),
                    center = Offset(
                        x = this.size.width - 15.dp.toPx(),
                        y = 0f
                    ),
                    alpha = 0.2f
                )

                drawCircle(
                    color = Color.LightGray,
                    radius = 100f,
                    style = Stroke(width = 50f, join = StrokeJoin.Round),
                    center = Offset(
                        x = this.size.width * 0.2f,
                        y = this.size.height - 15.dp.toPx()
                    ),
                    alpha = 0.2f
                )

                drawCircle(
                    color = Color.LightGray,
                    radius = 50f,
                    style = Stroke(width = 25f, join = StrokeJoin.Round),
                    center = Offset(
                        x = this.size.width * 0.2f,
                        y = this.size.height - 15.dp.toPx()
                    ),
                    alpha = 0.2f
                )
            }
        ,
        contentAlignment = Alignment.Center
    ){
        content()
    }

}

@Composable
@Preview(showSystemUi = true)
private fun DrinkCardItemBackgroundPreview(){
    DrinkOrderAppTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            DrinkCardItemBackground(
                modifier = Modifier.size(300.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.img_latte),
                        contentDescription = "latte"
                    )
                    Text(
                        text = "Tester"
                    )

                }
            }

        }
    }
}