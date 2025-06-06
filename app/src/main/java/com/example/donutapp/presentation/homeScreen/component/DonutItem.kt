package com.example.donutapp.presentation.homeScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donutapp.R
import com.example.donutapp.getScreenSizeDp
import com.example.donutapp.presentation.homeScreen.DonutItemContent
import com.example.donutapp.presentation.homeScreen.donuts
import com.example.donutapp.ui.theme.InterFont
import com.example.donutapp.ui.theme.Item1Color
import com.example.donutapp.ui.theme.White

@Composable
fun DonutItem(modifier: Modifier = Modifier, donut: DonutItemContent) {
    val (localScreenWidth, localScreenHeight) = getScreenSizeDp()
    val pixel3_w = 393
    val pixel3_h = 808
    val small_w = 360
    val small_h = 640
    Box(
        modifier = modifier
            .width(230.dp)
            .height(325.dp),
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = donut.cardColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .width(193.dp)
                .height(325.dp)
                .aspectRatio(193.dp / 325.dp)
                .padding(15.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 5.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 9.dp),
                    text = donut.title,
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
                Text(
                    modifier = Modifier
                        .alpha(0.6f)
                        .width(157.dp),
                    text = donut.desc,
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Black,
                        letterSpacing = 0.5.sp
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .alpha(0.6f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 1.dp),
                            text = "$20",
                            style = TextStyle(
                                fontFamily = InterFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        )
                        Spacer(Modifier
                            .width(25.dp)
                            .height(1.dp)
                            .background(Black))
                    }
                    Spacer(Modifier.width(5.dp))

                    Text(
                        modifier = Modifier,
                        text = "$16",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                    )

                }
            }

            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(color = White, shape = RoundedCornerShape(100.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp, 18.dp)
                        .offset(y = 2.dp),
                    painter = painterResource(R.drawable.vector),
                    contentDescription = null
                )
            }

        }
        Box {
            val size = if (donut.id == "2") {
                180
            } else {
                170
            }

            val offSit: Pair<Int, Int> = if (donut.id == "2") {
                Pair(80, 30)
            } else {
                Pair(70, 30)
            }
            Box(
                modifier = Modifier
                    .size(size.dp)
                    .offset(x = offSit.first.dp, y = offSit.second.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(donut.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

    }

}


@Preview
@Composable
fun DonutItemP1(modifier: Modifier = Modifier) {
    DonutItem(donut = donuts[0])
}

@Preview
@Composable
fun DonutItemP2(modifier: Modifier = Modifier) {
    DonutItem(donut = donuts[1])
}