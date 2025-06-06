package com.example.donutapp.presentation.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.donutapp.DonutViewModel
import com.example.donutapp.GetScreenSizeDp
import com.example.donutapp.R
import com.example.donutapp.presentation.homeScreen.DonutItemContent
import com.example.donutapp.presentation.homeScreen.donuts
import com.example.donutapp.ui.theme.InterFont
import com.example.donutapp.ui.theme.LightPink8DF
import com.example.donutapp.ui.theme.MainBlack
import com.example.donutapp.ui.theme.MainPink74
import com.example.donutapp.ui.theme.White
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.KFunction0

@Composable
fun CartScreen(
    navController: NavHostController,
    donutId: String = "",
    viewModel: DonutViewModel = koinViewModel()
) {
    val selectedDonut: DonutItemContent? = donuts.find { it.id == donutId }
    val counter by viewModel.state.collectAsState()

    CartContent(
        navController,
        selectedDonut,
        counterState = counter,
        onIncreaseCounter = {
            viewModel.onIncreaseCounter()
                            },
        onDecreaseCounter = {
            viewModel.onDecreaseCounter()
        }
    )

}

@Composable
private fun CartContent(
    navController: NavHostController,
    selectedDonut: DonutItemContent?,
    counterState: Int,
    onIncreaseCounter: ()->Unit,
    onDecreaseCounter: ()->Unit,
) {
    val (localScreenWidth, localScreenHeight) = GetScreenSizeDp()
    val pixel3_w = 393
    val pixel3_h = 808
    val small_w = 360
    val small_h = 640
    if (localScreenWidth < pixel3_w && localScreenHeight < pixel3_h) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPink8DF)
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 32.dp, top = 45.dp)
                    .size(25.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                painter = painterResource(R.drawable.pink_arrow),
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(220.dp)
                    .offset(y = -25.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(
                        selectedDonut?.imageId ?: R.drawable.strawberry_wheel
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .background(
                        color = White,
                        shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
                    )
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .offset(x = -33.dp, y = -23.dp)
                        .shadow(
                            elevation = 1.dp,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(
                            color = White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .align(Alignment.End),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(R.drawable.vector),
                        contentDescription = null
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp)
                            .offset(y = -5.dp),
                        text = selectedDonut?.title ?: "Strawberry Wheel",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            color = MainPink74
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 33.dp),
                        text = "About Gonut",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp,
                            color = MainBlack
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 16.dp, end = 40.dp)
                            .alpha(0.6f),
                        text = selectedDonut?.desc
                            ?: "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = MainBlack
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 26.dp),
                        text = "Quantity",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp,
                            color = MainBlack
                        )
                    )

                    Row(
                        modifier = Modifier.padding(start = 40.dp, top = 19.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable {
                                    onDecreaseCounter()
                                }
                                .size(35.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = White,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.offset(y = -2.dp),
                                text = "-",
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = White,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "1",
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clickable {
                                    onIncreaseCounter()
                                }
                                .size(35.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = MainBlack,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.offset(y = -2.dp),
                                text = "+",
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = White,
                                    lineHeight = 25.sp,
                                )
                            )
                        }


                    }

                    Spacer(
                        Modifier
                            .weight(1f)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, top = 47.dp, end = 40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(26.dp)
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "£16",
                            style = TextStyle(
                                fontFamily = InterFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 25.sp,
                                color = MainBlack
                            )
                        )

                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                                .background(
                                    color = MainPink74,
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .clickable {
                                    //
                                },
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                modifier = Modifier,
                                text = stringResource(R.string.add_to_cart),
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp,
                                    color = White
                                )
                            )
                        }
                    }


                    Spacer(Modifier.height(40.dp))

                }

            }


        }
    }
    else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPink8DF)
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 32.dp, top = 45.dp)
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                painter = painterResource(R.drawable.pink_arrow),
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .padding(top = 28.dp)
                    .size(350.dp)
                    .offset(y = -25.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = rememberAsyncImagePainter("https://api.btill.app/storage/products/IhdWvT1LoVXC0fFx5WU5VglT4tTuKDw6lIASDI8K.jpg"),
                    contentDescription = null,
//                    contentScale = ContentScale.Crop
                )
            }

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .background(
                        color = White,
                        shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
                    )
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .offset(x = -33.dp, y = -23.dp)
                        .shadow(
                            elevation = 1.dp,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(
                            color = White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .align(Alignment.End),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        modifier = Modifier.size(27.dp),
                        painter = painterResource(R.drawable.vector),
                        contentDescription = null
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp)
                            .offset(y = -5.dp),
                        text = selectedDonut?.title ?: "Strawberry Wheel",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp,
                            color = MainPink74
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 33.dp),
                        text = "About Gonut",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = MainBlack
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 16.dp, end = 40.dp)
                            .alpha(0.6f),
                        text = selectedDonut?.desc
                            ?: "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = MainBlack
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 26.dp),
                        text = "Quantity",
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = MainBlack
                        )
                    )

                    Row(
                        modifier = Modifier.padding(start = 40.dp, top = 19.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable {
                                    onDecreaseCounter()
                                }
                                .size(45.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = White,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.offset(y = -2.dp),
                                text = "-",
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(45.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = White,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = counterState.toString(),
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }


                        Box(
                            modifier = Modifier
                                .clickable {
                                    onIncreaseCounter()
                                }
                                .size(45.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .background(
                                    color = MainBlack,
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.offset(y = -2.dp),
                                text = "+",
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = White,
                                    lineHeight = 32.sp,
                                )
                            )
                        }


                    }

                    Spacer(
                        Modifier
                            .weight(1f)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, top = 47.dp, end = 40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(26.dp)
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "£16",
                            style = TextStyle(
                                fontFamily = InterFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 30.sp,
                                color = MainBlack
                            )
                        )

                        Box(
                            modifier = Modifier
                                .width(270.dp)
                                .height(67.dp)
                                .background(
                                    color = MainPink74,
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .clickable {
                                    //
                                },
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                modifier = Modifier,
                                text = stringResource(R.string.add_to_cart),
                                style = TextStyle(
                                    fontFamily = InterFont,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp,
                                    color = White
                                )
                            )
                        }
                    }


                    Spacer(Modifier.height(40.dp))

                }

            }


        }
    }
}

//@Composable
//fun CartContent() {
//
//}


@Preview(name = "figma", device = "spec:width=428dp,height=926dp,dpi=420")
@Preview(name = "PHONE",device = Devices.PHONE)
@Preview(name = "PIXEL_4",device = Devices.PIXEL_4)
@Preview(name = "pixel 3", device = "spec:width=393dp,height=808dp,dpi=420")
@Preview(name = "small phone", device = "spec:width=360dp,height=640dp,dpi=420")
@Composable
fun CartScreenP(modifier: Modifier = Modifier) {
    CartContent(
        rememberNavController(),
        donuts[1],
        counterState = 0,
        onIncreaseCounter = {},
        onDecreaseCounter = {}
    )
}