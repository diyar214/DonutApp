package com.example.donutapp.presentation.homeScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donutapp.R
import com.example.donutapp.ui.theme.InterFont
import com.example.donutapp.ui.theme.MainBlack
import com.example.donutapp.ui.theme.MainPink74
import com.example.donutapp.ui.theme.SmallDonutItemBackground
import com.example.donutapp.ui.theme.White

@Composable
fun SmallDonutItem(modifier: Modifier = Modifier,donut:SmallDonutItemData) {
    Box(
        modifier = modifier
            .width(138.dp)
            .height(160.dp)

           ,
        contentAlignment = Alignment.BottomCenter

    ){
        Box(
            modifier = Modifier
//                .shadow(
//                    elevation = 2.dp,
//                    shape = RoundedCornerShape(
//                        topStart = 20.dp,
//                        topEnd = 20.dp,
//                        bottomStart = 10.dp,
//                        bottomEnd = 10.dp)
//                )
                .background(
                    color = SmallDonutItemBackground,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 10.dp, bottomEnd = 10.dp)
                )
                .width(138.dp)
                .height(111.dp)
                ,
            contentAlignment = Alignment.BottomCenter
        ) {

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text(
                    modifier = Modifier.alpha(0.6f),
                    text = donut.title,
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = MainBlack
                    )
                )
                Text(
                    modifier = Modifier,
                    text = "$22",
                    style = TextStyle(
                        fontFamily = InterFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = MainPink74,
                        letterSpacing = 0.5.sp
                    )
                )

            }

        }
        Box{
            Box(
                modifier = Modifier
                    .size(104.dp,112.dp)
                    .offset( y = -50.dp).align(Alignment.TopCenter)
                ,
                contentAlignment = Alignment.Center
            ){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(donut.imageID),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}

@Preview
@Composable
fun SmallDonutItemP(modifier: Modifier = Modifier) {
    SmallDonutItem(donut = smallDonuts[0])
}


data class SmallDonutItemData(
    val imageID:Int,
    val title:String,
    val price:String
)

val smallDonuts = listOf(
    SmallDonutItemData(
        imageID = R.drawable.chocolate_cherry,
        title = "Chocolate Cherry",
        price = "$22"
    ),
    SmallDonutItemData(
        imageID = R.drawable.strawberry_rain,
        title = "Strawberry Rain",
        price = "$19"
    ),
    SmallDonutItemData(
        imageID = R.drawable.strawberry_coco,
        title = "Strawberry Coco",
        price = "$25"
    ),

)