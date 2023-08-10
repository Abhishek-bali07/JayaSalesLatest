package com.jaya.app.jayasaleslatest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jaya.app.jayasaleslatest.ui.theme.JayaSalesLatestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JayaSalesLatestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //SplashScreen()
                   // MobileScreen()
                   //OtpScreen()
                    //DashboardScreen()
                    //RouterScreen()
                    //ProductScreen()
                    //AddStoreScreen()
                   // StoreSearchScreen()
                    StoreDetailScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(){
  Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
  ){
    Column(  modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xffFF4155)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(id = R.drawable.jayalogo),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(text = "Sales", style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.White

        ))
        Surface(modifier = Modifier.weight(2f))


        {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xffFF4155)),
                contentAlignment = Alignment.BottomCenter){
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(vertical = 30.dp)
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(color = Color.White),
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Splash button icon",
                        tint = Color.Red,
                        modifier = Modifier.padding(6.dp),
                    )
                }
            }
        }



        
    }
  }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileScreen(){

    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp


    var textState by remember { mutableStateOf(TextFieldValue("")) }



    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalAlignment = Alignment.Start,
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Splash button icon",
                    tint = Color.Black,
                )
            }
            Text(modifier = Modifier.padding(horizontal = 10.dp),text = "Login here", style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold))


            Text(modifier = Modifier.padding(horizontal = 10.dp),text = "Enter your mobile number", style = TextStyle(fontSize = 15.sp))

            Surface(
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier
                    .padding(10.dp)
                    .width(screenWidthDp * .95f)
                    .height(55.dp),
            ) {
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                    Text(text = "+91", modifier = Modifier.padding(10.dp))


                   Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .fillMaxHeight()  //fill the max height
                            .width(1.dp)
                    )

                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        value = textState,
                        onValueChange = {
                        textState = it },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


                    )






                }
            }
        }

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 20.dp), shape = RoundedCornerShape(1.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                 containerColor = Color(0xFFFF4155)
                )
        ) {
            Text(text = "Get OTP Verification",color = Color.White)
        }

    }


}


/////OTPSCREEN/////

@Composable
fun OtpScreen() {

    val otpOne = remember { mutableStateOf("") }
    val otpTwo = remember { mutableStateOf("") }
    val otpThree = remember { mutableStateOf("") }
    val otpFour = remember { mutableStateOf("") }

    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            IconButton(modifier = Modifier,
                onClick = { }
            ) {
                Icon(painter = painterResource(id = R.drawable.backarrow), contentDescription = "")
            }
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Verify your Mobile Number",
                style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold), textAlign = TextAlign.Center
            )


            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Please check the OTP sent to your mobile no.",
                style = TextStyle(fontSize = 15.sp, color = Color.LightGray)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = screenHeightDp * .25f, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CommonOtpTextField(otp = otpOne)
                CommonOtpTextField(otp = otpTwo)
                CommonOtpTextField(otp = otpThree)
                CommonOtpTextField(otp = otpFour)
            }
            
            
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(
                    modifier = Modifier,
                    text = "An code has been sent to your Phone",
                    style = TextStyle(fontSize = 14.sp, color = Color.LightGray)
                )
                
                TextButton(onClick = { /*TODO*/ }) {
                  Text(text = "RESEND", style = TextStyle(color = Color.Red))
                }
            }
           





        }




    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonOtpTextField(otp: MutableState<String>) {
    val max = 1
    OutlinedTextField(
        value = otp.value,
        singleLine = true,
        onValueChange = { if (it.length <= max) otp.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(70.dp)
            .height(70.dp),
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center
        )
    )
}


///////DASHBOARD//////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(){
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { /*TODO*/ }, shape = RoundedCornerShape(50.dp),
            containerColor = Color(0xffECECEC),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        )
    },) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            GreetingSection()
            FeatureSection()
        }

    }

}



@Composable
fun GreetingSection() {

    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
           modifier = Modifier
               .height(screenHeightDp * .25f)
               .fillMaxWidth()
               .background(color = Color.Red)
               .padding(horizontal = 20.dp, vertical = 10.dp),
    ){
        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {


            IconButton(modifier = Modifier,
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier
                    .width(150.dp)
                    .height(55.dp),

                ) {
                Row(modifier = Modifier.background(color = Color.Red),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(
                            vertical = 3.dp, horizontal = 10.dp
                        ),
                        text = "",
                        style = TextStyle(
                            color = Color(0xff212121),
                            fontSize = 13.sp,
                        ),
                    )

                    IconButton(onClick = {

                    }) {
                        Icon(modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = null, tint = Color.White,
                        )
                    }
                }


            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(modifier = Modifier,
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp)
                    )
                }


                IconButton(modifier = Modifier,
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Image(modifier = Modifier,
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "")
                
                Text(
                    modifier = Modifier,
                    text = "Dream Enterprises",
                    style = TextStyle(fontSize = 26.sp, color = Color.White)
                )
                Row(modifier = Modifier, 
                    horizontalArrangement = Arrangement.Center) {
                    Icon(modifier = Modifier.size(20.dp),painter = painterResource(id = R.drawable.location), contentDescription = "", tint = Color.White,)
                    Text(text = "18,Padma Babu Road, Bally , Howrah", style = TextStyle(fontSize = 12.sp, color = Color.White))
                    
                    
                }


                Row(modifier = Modifier.padding(1.dp),
                    horizontalArrangement = Arrangement.Start) {
                    Icon(modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "",
                        tint = Color.White,
                        )
                    Text(text = "+91 9876543210", style = TextStyle(fontSize = 12.sp, color = Color.White))


                }
            }

        }
    }
}


@Composable
fun FeatureSection() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
    ) {
        Column(modifier = Modifier.padding(5.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .height(80.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Row (modifier = Modifier){
                        Image(painter = painterResource(id = R.drawable.img), contentDescription = "", modifier = Modifier.size(50.dp))
                        Text(
                            modifier = Modifier.padding(horizontal = 1.dp),
                            text = "Parties",
                            style = TextStyle(fontSize = 26.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier) {
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Total",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "200",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }

                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Active",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "185",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }
                    }



                }
            }


            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .height(80.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Row (modifier = Modifier){
                        Image(painter = painterResource(id = R.drawable.grp), contentDescription = "", modifier = Modifier.size(50.dp))
                        Text(
                            modifier = Modifier.padding(horizontal = 1.dp),
                            text = "Sales",
                            style = TextStyle(fontSize = 26.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier) {
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Total",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "200",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }

                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Active",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "185",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }
                    }



                }
            }




            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .height(80.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Row (modifier = Modifier){
                        Image(painter = painterResource(id = R.drawable.item), contentDescription = "", modifier = Modifier.size(50.dp))
                        Text(
                            modifier = Modifier.padding(horizontal = 1.dp),
                            text = "Items",
                            style = TextStyle(fontSize = 26.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier) {
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Total",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "200",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }

                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Active",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "185",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }
                    }



                }
            }



            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .height(80.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Row (modifier = Modifier){
                        Image(painter = painterResource(id = R.drawable.payment), contentDescription = "", modifier = Modifier.size(50.dp))
                        Text(
                            modifier = Modifier.padding(horizontal = 1.dp),
                            text = "Payments",
                            style = TextStyle(fontSize = 26.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier) {
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Total",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "12000",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }

                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Dues",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "1185",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                        }
                    }



                }
            }
        }
    }
}


//////ROUTER////


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouterScreen(){
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
        TopAppBar(
            title = {
                Text(
                    "Routes", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp,
                    )
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
            navigationIcon = {
                IconButton(
                    onClick = {

                    }) {
                    Image(

                        modifier = Modifier
                            .size(30.dp)
                            .padding(horizontal = 8.dp),
                        painter = painterResource(id =R.drawable.wback),
                        contentDescription = null,
                    )
                }

            }, actions = {
                IconButton(
                    onClick = {

                    })
                {
                    Image(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = null
                    )
                }
            }

            )


            CardSection()


    }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSection(){
 Column {
     OutlinedTextField(
         value = "",
         onValueChange = {},
         modifier = Modifier
             .fillMaxWidth()
             .padding(vertical = 5.dp, horizontal = 10.dp),
         textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
         trailingIcon = {
             IconButton(
                 onClick = {}
             ) {
                 Icon(
                     Icons.Default.Search,
                     contentDescription = "",
                     modifier = Modifier
                         .size(48.dp)
                 )
             }
         },
         singleLine = true,
         shape = RectangleShape,
         colors = TextFieldDefaults.outlinedTextFieldColors(

             textColor = Color.Black,
             cursorColor = Color.Black,
             focusedBorderColor = Color(0xffC0C0C0),
             unfocusedBorderColor = Color(0xffC0C0C0)
         )

         )



     Card(
         modifier = Modifier
             .padding(horizontal = 10.dp, vertical = 2.dp)
             .height(80.dp),
         shape = RoundedCornerShape(6.dp),
         colors = CardDefaults.cardColors(
             containerColor = Color.White
         ),
         elevation = CardDefaults.cardElevation(
             defaultElevation = 10.dp
         ), border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
     ) {
         Row(
             horizontalArrangement = Arrangement.Start,
             verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 15.dp, start = 8.dp),
         ) {
             Row(modifier =Modifier.weight(7f)) {
                 Box(
                     modifier = Modifier
                         .size(40.dp)
                         .clip(CircleShape)
                         .background(Color.Red)
                 ){
                     Text(
                         "B", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                             color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                         )
                     )
                 }

                 Text(
                     "Bally", modifier = Modifier.padding(horizontal = 10.dp), style = TextStyle(
                         color = Color.Black, fontSize = 20.sp,
                     )
                 )
             }


             Box(
                 modifier = Modifier
                     .weight(1f)
                     .padding(horizontal = 14.dp)
                     .size(20.dp)
                     .clip(CircleShape)
                     .background(Color.Red)
             )




         }
     }



     Card(
         modifier = Modifier
             .padding(horizontal = 10.dp, vertical = 2.dp)
             .height(80.dp),
         shape = RoundedCornerShape(6.dp),
         colors = CardDefaults.cardColors(
             containerColor = Color.White
         ),
         elevation = CardDefaults.cardElevation(
             defaultElevation = 10.dp
         ), border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
     ) {
         Row(
             horizontalArrangement = Arrangement.Start,
             verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 15.dp, start = 8.dp),
         ) {
             Row(modifier =Modifier.weight(7f)) {
                 Box(
                     modifier = Modifier
                         .size(40.dp)
                         .clip(CircleShape)
                         .background(Color.Red)
                 ){
                     Text(
                         "H", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                             color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                         )
                     )
                 }

                 Text(
                     "Howrah", modifier = Modifier.padding(horizontal = 10.dp), style = TextStyle(
                         color = Color.Black, fontSize = 20.sp,
                     )
                 )
             }


             Box(
                 modifier = Modifier
                     .weight(1f)
                     .padding(horizontal = 14.dp)
                     .size(20.dp)
                     .clip(CircleShape)
                     .background(Color.LightGray)
             )




         }
     }



     Card(
         modifier = Modifier
             .padding(horizontal = 10.dp, vertical = 2.dp)
             .height(80.dp),
         shape = RoundedCornerShape(6.dp),
         colors = CardDefaults.cardColors(
             containerColor = Color.White
         ),
         elevation = CardDefaults.cardElevation(
             defaultElevation = 10.dp
         ), border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
     ) {
         Row(
             horizontalArrangement = Arrangement.Start,
             verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 15.dp, start = 8.dp),
         ) {
             Row(modifier =Modifier.weight(7f)) {
                 Box(
                     modifier = Modifier
                         .size(40.dp)
                         .clip(CircleShape)
                         .background(Color.Red)
                 ){
                     Text(
                         "B", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                             color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                         )
                     )
                 }

                 Text(
                     "Belur", modifier = Modifier.padding(horizontal = 10.dp), style = TextStyle(
                         color = Color.Black, fontSize = 20.sp,
                     )
                 )
             }


             Box(
                 modifier = Modifier
                     .weight(1f)
                     .padding(horizontal = 14.dp)
                     .size(20.dp)
                     .clip(CircleShape)
                     .background(Color.LightGray)
             )




         }
     }
 }
}

/////////productlist//////////





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(){
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { /*TODO*/ }, shape = RoundedCornerShape(50.dp),
            containerColor = Color(0xffECECEC),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        )
    }) {
        paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            UpperSection()
            LowerSection()
        }
    }

}



@Composable
fun UpperSection(){

    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp


    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp


    var locationState by remember { mutableStateOf(TextFieldValue("Search Store")) }

    Column(
        modifier = Modifier
            .height(screenHeightDp * .25f)
            .fillMaxWidth()
            .background(color = Color(0xffFF4155))
            .padding(horizontal = 10.dp, vertical = 10.dp), verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {


            IconButton(modifier = Modifier,
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.wback),
                    contentDescription = "", tint = Color.White, modifier = Modifier.size(20.dp)
                )
            }


            Text(
                "Bally", modifier = Modifier, style = TextStyle(
                    color = Color.White, fontSize = 30.sp,
                )
            )
           


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
               
                IconButton(modifier = Modifier,
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "", tint = Color.White, modifier = Modifier
                            .padding(top = 5.dp)
                            .size(30.dp)
                    )
                }
            }
        }




        Card(
            border = BorderStroke(1.dp, Color.LightGray),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(75.dp)
                .padding(bottom = 20.dp, start = 5.dp, end = 5.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(1.dp)
                        .background(color = Color(0xffFFEB56))
                        .weight(1f)
                        .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enter Location",
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )


                    IconButton(onClick = {

                    }) {
                        Icon(modifier = Modifier.size(17.dp),
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = null,
                            tint = Color.Black,
                        )
                    }




                }
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BasicTextField(
                        modifier = Modifier
                            .padding(2.dp),
                        value = locationState,
                        onValueChange = {
                            locationState = it },
                        maxLines = 1,
                    )


                    IconButton(onClick = {

                    }) {
                        Icon(modifier = Modifier.size(17.dp),
                            painter = painterResource(id = R.drawable.srch),
                            contentDescription = null,
                            tint = Color.Black,
                        )
                    }


                }
            }//row
        }
    }

}


@Composable
fun LowerSection(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = "Store List", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "View all", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W400, color = Color(0xffB7B7B7)))

                }
            }



            Divider(color =  Color(0xffB7B7B7), modifier = Modifier
                .fillMaxWidth()
                .width(1.dp))


            gridView(LocalContext.current)
        }

    }
}



@Composable
fun gridView(context: Context) {
    val numbers = (1..12).toList()


    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(10.dp)
    ) {
       items(numbers.size) {

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(100.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ), shape = RoundedCornerShape(6.dp),
            ) {

                Column(

                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    /*Image(
                        painter = painterResource(id = ),
                        contentDescription = "",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp)
                    )*/


                    Spacer(modifier = Modifier.height(9.dp))


                    Text(
                        text =" ${ it+1 }",
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}








///////NewStore//////


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStoreScreen(){

    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Text(
                        "Add New Store", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                            color = Color.White, fontSize = 20.sp,
                        )
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id =R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(
                        onClick = {

                        })
                    {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )


            TextFieldSection()


        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldSection(){
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Name",
                style = TextStyle(fontWeight = FontWeight.W500)
            )
            
            
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange ={}, )
        }
}


////////storeSearchSection//////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreSearchScreen(){
    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(48.dp),
                        value = "",
                        onValueChange = {},
                        trailingIcon = {
                                       Icon(modifier = Modifier.size(15.dp),painter = painterResource(id = R.drawable.srch), contentDescription = "")
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            containerColor = Color.White,
                            focusedBorderColor = Color.White
                        ))
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id =R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(
                        onClick = {

                        })
                    {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )


            PagerSection()


        }
    }

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerSection(){


    val listState = rememberLazyListState()
    val screenHeightBy40 = LocalConfiguration.current.screenHeightDp * 0.90f
    val screenWidthBy90 = LocalConfiguration.current.screenWidthDp * 0.95f



    val storeItem = listOf("Ram Krishna Store","Ram Krishna Store","Krishna Store")
    
    val itemsList = (0..5).toList()
    val pages = listOf(
        "Visited" ,
        "Completed",
        "Pending",
        "View All"
    )


    LazyRow {
        items(pages) { index ->
            Text(
                modifier = Modifier.padding(all = 6.dp),
                text = "$index",
                fontSize = 20.sp, color = Color.LightGray

            )
        }
    }





    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .height(screenHeightBy40.dp),
        userScrollEnabled = true
    ){
        items(storeItem){item ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .height(80.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xffFFFFFF)
                ),
                shape = RoundedCornerShape(6.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(modifier = Modifier.padding(top = 10
                    .dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically)
                {

                    Row(modifier = Modifier.weight(3f)) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color.Red)
                        ){
                            Text(
                                "H", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                                    color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                                )
                            )
                        }

                        Column (modifier = Modifier.padding(horizontal = 5.dp)){
                            Text(
                                item, modifier = Modifier, style = TextStyle(
                                    color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center
                                )
                            )


                            Text(
                                "#93SARJAPUR ROAR", modifier = Modifier, style = TextStyle(
                                    color = Color.Gray, fontSize = 14.sp, textAlign = TextAlign.Center
                                )
                            )
                        }
                    }




                    Column (modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp))
                    {
                        Text(
                            "43923", modifier = Modifier, style = TextStyle(
                                color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center
                            )
                        )


                        Text(
                            "To get", modifier = Modifier, style = TextStyle(
                                color = Color.Black, fontSize = 14.sp, textAlign = TextAlign.Center
                            )
                        )
                    }


                }
            }
        }
    }
}


@Composable
fun StoreDataItem(
    store: String,
    content: () -> Unit) {
   Card(
       modifier = Modifier
           .padding(horizontal = 10.dp, vertical = 2.dp)
           .wrapContentHeight()
           .width(150.dp),
       colors = CardDefaults.cardColors(
           containerColor = Color.Red
       ),
       shape = RoundedCornerShape(6.dp),
       elevation = CardDefaults.cardElevation(
           defaultElevation = 10.dp
       )
   ) {
        Row(modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            ){
                Text(
                    "H", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                    )
                )
            }
        }
   }
}

///////storeDetail////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreDetailScreen(){
    Scaffold()
    {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


           DetailSection()
           ProductListSection()
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSection() {
    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier
            .height(screenHeightDp * .20f)
            .fillMaxWidth()
            .background(color = Color(0xffF22E4F))
            .padding(vertical = 10.dp), verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Start) {


            IconButton(modifier = Modifier,
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.wback),
                    contentDescription = "", tint = Color.White, modifier = Modifier.size(20.dp)
                )
            }



            OutlinedTextField(
                modifier = Modifier
                    .height(48.dp),
                value = "",
                onValueChange = {},
                trailingIcon = {
                    Icon(modifier = Modifier.size(15.dp),painter = painterResource(id = R.drawable.srch), contentDescription = "")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ))



            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End)
            {
                IconButton(modifier = Modifier,
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "", tint = Color.White, modifier = Modifier.size(30.dp)
                    )
                }
            }
        }



        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
        {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally)
                {

                Text(
                    modifier = Modifier,
                    text = "Ram Krishna Store",
                    style = TextStyle(fontSize = 26.sp, color = Color.White)
                )
                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(modifier = Modifier.size(20.dp),painter = painterResource(id = R.drawable.location), contentDescription = "", tint = Color.White,)
                    Text(text = "#93SARJAPUR ROAR", style = TextStyle(fontSize = 18.sp, color = Color.White))


                }


                Row(modifier = Modifier.padding(1.dp),
                    horizontalArrangement = Arrangement.Start) {
                    Icon(modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    Text(text = "+91 9876543210", style = TextStyle(fontSize = 14.sp, color = Color.White))


                }
            }

        }
    }
}


@Composable
fun ProductListSection() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
    ){  Column(modifier = Modifier.fillMaxWidth())
            {
                Row(modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 15.dp,
                        horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Card(modifier = Modifier
                        .shadow(4.dp)
                        .height(120.dp)
                        .width(120.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )) {

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(modifier = Modifier.size(80.dp),
                                painter = painterResource(id = R.drawable.mcircle),
                                contentDescription ="" )
                            Text(text = "Visit Shop",style = TextStyle(fontSize = 12.sp))

                        }



                    }



                    Card(modifier = Modifier
                        .shadow(4.dp)
                        .height(120.dp)
                        .width(120.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )) {

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(modifier = Modifier.size(80.dp),
                                painter = painterResource(id = R.drawable.sales),
                                contentDescription ="" )
                            Text(text = "New sales",style = TextStyle(fontSize = 12.sp))

                        }



                    }



                    Card(modifier = Modifier
                        .shadow(4.dp)
                        .height(120.dp)
                        .width(120.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )) {

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(modifier = Modifier.size(80.dp),
                                painter = painterResource(id = R.drawable.paymentt),
                                contentDescription ="" )
                            Text(text = "Payment",style = TextStyle(fontSize = 12.sp))

                        }



                    }



                }

                Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Past Transaction",style = TextStyle(fontSize = 12.sp))
                    Text(text = "View all",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        color = Color(0xffF22E4F))
                }
            }

    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JayaSalesLatestTheme {

    }
}


/*
package com.jaya.app.tablist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaya.app.tablist.ui.theme.TabListTheme

class MainActivity : ComponentActivity() {
    val selectedTab = mutableStateOf("Visited")
    val stores = mutableStateListOf(
        *List(10){
            Store(
                id = it,
                name = "Shop $it",
                amount = (500..5000).random().toFloat(),
                stage = Store.Stage.values().random()
            )
        }.toTypedArray()
    )
    val effectiveStores = mutableStateListOf<Store>(*
    stores.filter { it.stage==Store.Stage.Visited }.toTypedArray())
    val onTabClicked = fun(tab: String){
        selectedTab.value = tab
        updateListAsTabChanged()
    }

    private fun updateListAsTabChanged() {
        effectiveStores.apply {
            clear()
            when(selectedTab.value){
                "Visited"->{
                    addAll(stores.filter { it.stage==Store.Stage.Visited })
                }
                "Pending"->{
                    addAll(stores.filter { it.stage==Store.Stage.Pending })
                }
                "Completed"->{
                    addAll(stores.filter { it.stage==Store.Stage.Completed })
                }
                else->{
                    addAll(stores)
                }
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            Text(
                                "Visited",
                                modifier = Modifier
                                    .clickable{
                                        onTabClicked("Visited")
                                    }
                                    .padding(12.dp),
                                fontWeight = if(selectedTab.value=="Visited") FontWeight.Bold else FontWeight.Normal
                            )
                            Text(
                                "Completed",
                                modifier = Modifier
                                    .clickable{
                                        onTabClicked("Completed")
                                    }
                                    .padding(12.dp),
                                fontWeight = if(selectedTab.value=="Completed") FontWeight.Bold else FontWeight.Normal
                            )
                            Text(
                                "Pending",
                                modifier = Modifier
                                    .clickable{
                                        onTabClicked("Pending")
                                    }
                                    .padding(12.dp),
                                fontWeight = if(selectedTab.value=="Pending") FontWeight.Bold else FontWeight.Normal
                            )
                            Text(
                                "All",
                                modifier = Modifier
                                    .clickable{
                                        onTabClicked("All")
                                    }
                                    .padding(12.dp),
                                fontWeight = if(selectedTab.value=="All") FontWeight.Bold else FontWeight.Normal
                            )
                        }
                        LazyColumn{
                            items(effectiveStores){
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            BorderStroke(
                                                width = 1.dp,
                                                color = Color.Red
                                            )
                                        )
                                        .padding(12.dp)
                                ){
                                    Text(it.name)
                                    Text("Rs. "+it.amount.toString())
                                    //Text(it.stage.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Store(
    val id: Any,
    val name: String,
    val amount: Float,
    val stage: Stage
){
    enum class Stage{
        Pending,
        Visited,
        Completed
    }
} */