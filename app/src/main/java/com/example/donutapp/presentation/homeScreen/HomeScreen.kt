package com.example.donutapp.presentation.homeScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.donutapp.R
import com.example.donutapp.Screens
import com.example.donutapp.getScreenSizeDp
import com.example.donutapp.presentation.homeScreen.component.DonutItem
import com.example.donutapp.presentation.homeScreen.component.SmallDonutItem
import com.example.donutapp.presentation.homeScreen.component.smallDonuts
import com.example.donutapp.ui.theme.HomeBackground
import com.example.donutapp.ui.theme.InterFont
import com.example.donutapp.ui.theme.Item1Color
import com.example.donutapp.ui.theme.Item2Color
import com.example.donutapp.ui.theme.LightPink8DF
import com.example.donutapp.ui.theme.MainBlack
import com.example.donutapp.ui.theme.MainPink74
import kotlin.math.roundToInt

@Composable
fun HomeScreen(navController: NavHostController) {
    val (localScreenWidth, localScreenHeight) = getScreenSizeDp()
    val pixel3_w = 393
    val pixel3_h = 808
    Log.d("local size", "OnboardingScreen:$localScreenWidth X $localScreenHeight ")

    val scrollStart = rememberScrollState()

    if (localScreenWidth == pixel3_w && localScreenHeight == pixel3_h) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = HomeBackground)
                    .verticalScroll(scrollStart)
                    .padding(bottom = 100.dp)
            ) {
                TopBar()
                LazyRow(
                    modifier = Modifier.padding(top = 25.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(start = 38.dp, end = 25.dp)
                ) {
                    items(donuts) { donut ->
                        DonutItem(
                            donut = donut,
                            modifier = Modifier.clickable {
                                navController.navigate("${Screens.CartScreen.rout}/${donut.id}")
                            },
                        )
                    }
                }

                Text(
                    modifier = Modifier.padding(top = 46.dp, start = 38.dp),
                    text = "Donuts",
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp,
                        color = MainBlack,
                    ),
                )


                LazyRow(
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(start = 38.dp, bottom = 10.dp, end = 25.dp)
                ) {
                    items(smallDonuts) { donut ->
                        SmallDonutItem(donut = donut)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .height(70.dp)
                    .background(color = HomeBackground),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.home),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.heart),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.notification),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.buy),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.user),
                    contentDescription = null
                )

            }
        }
    } else if (localScreenWidth < pixel3_w && localScreenHeight < pixel3_h) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = HomeBackground)
                    .verticalScroll(scrollStart)
                    .padding(bottom = 100.dp)
            ) {
                SmallTopBar()
                LazyRow(
                    modifier = Modifier.padding(top = 25.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(start = 38.dp, end = 25.dp)
                ) {
                    items(donuts) { donut ->
                        DonutItem(donut = donut, modifier = Modifier.clickable {
                            navController.navigate("${Screens.CartScreen.rout}/${donut.id}")
                        })
                    }
                }

                Text(
                    modifier = Modifier.padding(top = 46.dp, start = 38.dp),
                    text = "Donuts",
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp,
                        color = MainBlack,
                    ),
                )


                LazyRow(
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(start = 38.dp, bottom = 10.dp, end = 25.dp)
                ) {
                    items(smallDonuts) { donut ->
                        SmallDonutItem(donut = donut)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .height(70.dp)
                    .background(color = HomeBackground),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.home),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.heart),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.notification),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.buy),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.user),
                    contentDescription = null
                )

            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = HomeBackground)
                    .verticalScroll(scrollStart)
                    .padding(bottom = 100.dp)
            ) {
                TopBar()
                LazyRow(
                    modifier = Modifier.padding(top = 25.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(start = 38.dp, end = 25.dp)
                ) {
//                    items(donuts){donut->
//
//                    }
                    itemsIndexed(donuts) { index: Int, donut: DonutItemContent ->
                        DonutItem(
                            donut = donut,
                            modifier = Modifier.clickable {
                                navController.navigate("${Screens.CartScreen.rout}/${donut.id}")
                            },
                        )
                        Log.d("itemsIndexed", "HomeScreen: donut:${donut.title} with index:$index")
                    }
                }

                Text(
                    modifier = Modifier.padding(top = 46.dp, start = 38.dp),
                    text = "Donuts",
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp,
                        color = MainBlack,
                    ),
                )


                LazyRow(
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(start = 38.dp, bottom = 10.dp, end = 25.dp)
                ) {
                    items(smallDonuts) { donut ->
                        SmallDonutItem(donut = donut)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .height(70.dp)
                    .background(color = HomeBackground),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.home),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.heart),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.notification),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.buy),
                    contentDescription = null
                )
                Spacer(Modifier.width(40.dp))
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.user),
                    contentDescription = null
                )

            }
        }

    }


}

data class DonutItemContent(
    val id: String,
    val imageId: Int,
    val title: String,
    val desc: String,
    val cardColor: Color,
    val price: Double,
    val discount: Double,
) {
    val finalPrice: Double = (this.price * (1 - this.discount))
}

val donuts = listOf(
    DonutItemContent(
        id = "1",
        imageId = R.drawable.strawberry_wheel,
        title = "Strawberry Wheel",
        desc = "These Baked Strawberry Donuts are filled with fresh strawberries...",
        cardColor = Item1Color,
        price = 20.0,
        discount = 0.05,
    ),
    DonutItemContent(
        id = "2",
        imageId = R.drawable.chocolate_glaze,
        title = "Chocolate Glaze",
        desc = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
        cardColor = Item2Color,
        price = 20.0,
        discount = 0.20,
    )
)


@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = 38.dp, top = 61.dp, end = 40.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(R.string.let_s_gonuts),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 30.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        color = MainPink74
                    )
                )
                Text(
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 3.dp),
                    text = stringResource(R.string.order_your_favourite_donuts_from_here),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 14.sp,
                        lineHeight = 17.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.sp,
                        color = MainBlack,
                    ),
                )
            }
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterEnd)
                    .background(color = LightPink8DF, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp),
                    painter = painterResource(R.drawable.ic_round_search),
                    contentDescription = null
                )
            }
        }




        Text(
            modifier = Modifier.padding(top = 54.dp),
            text = stringResource(R.string.today_offers),
            style = TextStyle(
                fontFamily = InterFont,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.sp,
                color = MainBlack,
            ),
        )

    }
}

@Composable
private fun SmallTopBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = 38.dp, top = 61.dp, end = 40.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(R.string.let_s_gonuts),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 25.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        color = MainPink74
                    )
                )
                Text(
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 3.dp),
                    text = stringResource(R.string.order_your_favourite_donuts_from_here),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontSize = 12.sp,
                        lineHeight = 17.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.sp,
                        color = MainBlack,
                    ),
                )
            }
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterEnd)
                    .background(color = LightPink8DF, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp),
                    painter = painterResource(R.drawable.ic_round_search),
                    contentDescription = null
                )
            }
        }




        Text(
            modifier = Modifier.padding(top = 54.dp),
            text = stringResource(R.string.today_offers),
            style = TextStyle(
                fontFamily = InterFont,
                fontSize = 18.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.sp,
                color = MainBlack,
            ),
        )

    }
}


@Preview(name = "figma", device = "spec:width=428dp,height=926dp,dpi=420")
@Preview(name = "PHONE", device = Devices.PHONE)
@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "pixel 3", device = "spec:width=393dp,height=808dp,dpi=420")
@Preview(name = "small phone", device = "spec:width=360dp,height=640dp,dpi=420")
@Composable
fun HomeScreenP(modifier: Modifier = Modifier) {
    HomeScreen(rememberNavController())
}