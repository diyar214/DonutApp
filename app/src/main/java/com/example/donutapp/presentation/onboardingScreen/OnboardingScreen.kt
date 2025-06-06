package com.example.donutapp.presentation.onboardingScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.donutapp.GetScreenSizeDp
import com.example.donutapp.R
import com.example.donutapp.Screens
import com.example.donutapp.ui.theme.InterFont
import com.example.donutapp.ui.theme.LightPink8DF
import com.example.donutapp.ui.theme.MainPink74
import com.example.donutapp.ui.theme.SecondPink94
import com.example.donutapp.ui.theme.White

@Composable
fun OnboardingScreen(navController: NavHostController) {
    val (localScreenWidth, localScreenHeight) = GetScreenSizeDp()
    val pixel3_w = 393
    val pixel3_h = 808
    val small_w = 360
    val small_h = 640
    Log.d("local size", "OnboardingScreen:$localScreenWidth X $localScreenHeight ")

    if (localScreenWidth == pixel3_w && localScreenHeight == pixel3_h){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPink8DF)
                .clipToBounds()
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.TopStart)
                    .offset(x = -19.dp, y = -39.dp),
                painter = painterResource(R.drawable.purple_donut),
                contentDescription = null
            )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(700f / 401f)
//                    .offset(y = 50.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 100.dp)
//                .aspectRatio(1.7f)
//                .align(Alignment.TopCenter)
//                .offset(y=90.dp)
//                .padding(top = 150.dp)
                            .scale(1.8f)
                        ,
                        painter = painterResource(R.drawable.all_donuts),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }



            Image(
                modifier = Modifier
                    .size(210.dp, 155.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = -45.dp, y = 10.dp)
                    .scale(0.85f),
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(209.dp, 165.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = 340.dp, x = 102.dp),
                painter = painterResource(R.drawable.bait_donut),
                contentDescription = null
            )


            Image(
                modifier = Modifier
                    .size(94.dp, 69.dp)
                    .align(Alignment.TopStart)
                    .graphicsLayer {
                        scaleX = -1f
                    }
                    .scale(1.1f)
                    .offset(x = -10.dp, y = 210.dp)
                    ,
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
            ) {
                Text(
                    modifier = Modifier.width(193.dp),
                    text = stringResource(R.string.gonuts_with_donuts),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 54.sp,
                        color = MainPink74
                    )
                )
                Spacer(Modifier.height(19.dp))

                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.gonuts_with_donuts_is_a_sri_lanka_dedicated_food_outlets_for_specialize_manufacturing_of_donuts_in_colombo_sri_lanka),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = SecondPink94
                    )
                )

                Spacer(Modifier.height(60.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(67.dp)
                        .background(
                            color = White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navController.navigate(Screens.HomeScreen.rout)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.get_started),
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    )
                }
                Spacer(Modifier.height(46.dp))


            }

        }
    }
    else if (localScreenWidth < pixel3_w && localScreenHeight < pixel3_h){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPink8DF)
                .clipToBounds()
        ) {
            Image(
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.TopStart)
                    .offset(x = -19.dp, y = -39.dp),
                painter = painterResource(R.drawable.purple_donut),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(700f / 401f)
//                    .offset(y = 50.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = 70.dp)
//                .aspectRatio(1.7f)
//                .align(Alignment.TopCenter)
//                .offset(y=90.dp)
//                .padding(top = 150.dp)
                        .scale(1.5f)
                    ,
                    painter = painterResource(R.drawable.all_donuts),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }



            Image(
                modifier = Modifier
                    .size(210.dp, 155.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = -45.dp, y = 5.dp)
                    .scale(0.65f),
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .aspectRatio(209.dp / 165.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = 260.dp, x = 65.dp),
                painter = painterResource(R.drawable.bait_donut),
                contentDescription = null
            )


            Image(
                modifier = Modifier
                    .size(94.dp, 69.dp)
                    .align(Alignment.TopStart)
                    .graphicsLayer {
                        scaleX = -1f
                    }
                    .scale(1.1f)
                    .offset(x = -10.dp, y = 180.dp)
                ,
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
            ) {
                Text(
                    modifier = Modifier.width(150.dp),
                    text = stringResource(R.string.gonuts_with_donuts),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 33.sp,
                        color = MainPink74
                    )
                )
                Spacer(Modifier.height(19.dp))

                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.gonuts_with_donuts_is_a_sri_lanka_dedicated_food_outlets_for_specialize_manufacturing_of_donuts_in_colombo_sri_lanka),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = SecondPink94
                    )
                )

                Spacer(Modifier.height(40.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp)
                        .background(
                            color = White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navController.navigate(Screens.HomeScreen.rout)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.get_started),
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    )
                }
                Spacer(Modifier.height(46.dp))


            }

        }
    }
    else{
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPink8DF)
                .clipToBounds()
        ) {
            Image(
                modifier = Modifier
                    .size(186.dp)
                    .align(Alignment.TopStart)
                    .offset(x = -19.dp, y = -39.dp),
                painter = painterResource(R.drawable.purple_donut),
                contentDescription = null
            )
            if (localScreenWidth < 1000) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(700f / 401f)
//                    .offset(y = 50.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 145.dp)
//                .aspectRatio(1.7f)
//                .align(Alignment.TopCenter)
//                .offset(y=90.dp)
//                .padding(top = 150.dp)
                            .scale(1.9f)
                        ,
                        painter = painterResource(R.drawable.all_donuts),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            } else {
                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.7f)
                            .align(Alignment.TopCenter)
                            .offset(y = -100.dp)
//                        .scale(3f)
                        ,
                        painter = painterResource(R.drawable.all_donuts),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }


            Image(
                modifier = Modifier
                    .size(210.dp, 155.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 40.dp, end = 33.dp)
                    .scale(1.2f),
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(209.dp, 165.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = 420.dp, x = 102.dp),
                painter = painterResource(R.drawable.bait_donut),
                contentDescription = null
            )


            Image(
                modifier = Modifier
                    .size(94.dp, 69.dp)
                    .align(Alignment.TopStart)
                    .graphicsLayer {
                        scaleX = -1f
                    }
                    .scale(1.1f)
                    .offset(x = -10.dp, y = 270.dp)
                    ,
                painter = painterResource(R.drawable.marchmello_donut),
                contentDescription = null
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
            ) {
                Text(
                    modifier = Modifier.width(193.dp),
                    text = stringResource(R.string.gonuts_with_donuts),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 54.sp,
                        color = MainPink74
                    )
                )
                Spacer(Modifier.height(19.dp))

                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.gonuts_with_donuts_is_a_sri_lanka_dedicated_food_outlets_for_specialize_manufacturing_of_donuts_in_colombo_sri_lanka),
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = SecondPink94
                    )
                )

                Spacer(Modifier.height(60.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(67.dp)
                        .background(
                            color = White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navController.navigate(Screens.HomeScreen.rout)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.get_started),
                        style = TextStyle(
                            fontFamily = InterFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    )
                }
                Spacer(Modifier.height(46.dp))


            }

        }
    }

}


@Preview(name = "figma", device = "spec:width=428dp,height=926dp,dpi=420")
@Preview(name = "PHONE",device = Devices.PHONE)
@Preview(name = "PIXEL_4",device = Devices.PIXEL_4)
@Preview(name = "pixel 3", device = "spec:width=393dp,height=808dp,dpi=420")
@Preview(name = "small phone", device = "spec:width=360dp,height=640dp,dpi=420")
//@PreviewScreenSizes
@Composable
fun OnboardingP(modifier: Modifier = Modifier) {
    OnboardingScreen(rememberNavController())
}