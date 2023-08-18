package com.jaya.app.jayasaleslatest

import android.content.Context
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
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
import androidx.compose.ui.window.Dialog
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.jaya.app.jayasaleslatest.ui.theme.JayaSalesLatestTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JayaSalesLatestTheme {
                // A surface container using the 'background' color from the theme

                val pagerState = rememberPagerState()

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    HorizontalPager(
                        pageCount = pages.size,
                        state = PagerState()
                    ) { pageIndex ->
                        when (pages[pageIndex]) {
                            Page.Splash -> SplashScreen()
                            Page.Mobile -> MobileScreen()
                            Page.Otp -> OtpScreen()
                            Page.Dashboard -> DashboardScreen()
                            Page.Router -> RouterScreen()
                            Page.Product -> ProductScreen()
                            Page.AddStore -> AddStoreScreen()
                            Page.StoreSearch -> StoreSearchScreen()
                            Page.StoreDetail -> StoreDetailScreen()
                            Page.invoice -> InvoiceScreen()
                            Page.visit -> VisitScreen()
                            Page.newSales -> NewSaleScreen()
                            Page.ReviewCart -> ReviewCartScreen()
                            Page.payment -> PaymentScreen()
                            else -> {}
                        }
                    }

                    //SplashScreen()
                    // MobileScreen()
                    //OtpScreen()
                    //DashboardScreen()
                    //RouterScreen()
                    //ProductScreen()
                    //AddStoreScreen()
                    //StoreSearchScreen()
                    // StoreDetailScreen()
                    //InvoiceScreen()
                    //VisitScreen()


                    // NewSaleScreen()
                    //ReviewCartScreen()
                   // PaymentScreen()
                }
            }
        }
    }
}



sealed class Page {
    object Splash : Page()
    object Mobile : Page()
    object Otp : Page()
    object Dashboard : Page()

    object Router :Page()
    object Product: Page()
    object AddStore : Page()
    object StoreSearch : Page()
    object StoreDetail :Page()
    object invoice: Page()
    object visit :Page()

    object newSales: Page()

    object ReviewCart:Page()

    object payment: Page()



}

val pages = listOf(
    Page.Splash,
    Page.Mobile,
    Page.Otp,
    Page.Dashboard,Page.Router,
    Page.Product,
    Page.AddStore,Page.StoreSearch,Page.StoreDetail,Page.invoice,Page.visit,Page.newSales,Page.ReviewCart,Page.payment
)





@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xffFF4155)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.jayalogo),
                contentDescription = null,
                modifier = Modifier.padding(top = 60.dp)
            )
            Text(
                text = "Sales", style = TextStyle(
                    fontWeight = FontWeight.Bold, fontSize = 32.sp, color = Color.White

                )
            )
            Surface(modifier = Modifier.weight(2f))


            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xffFF4155)),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(bottom = 80.dp)
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
fun MobileScreen() {

    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp


    var textState by remember { mutableStateOf(TextFieldValue("000-0000-000")) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            IconButton(onClick = { }) {
               Icon(painter = painterResource(id = R.drawable.backarrow), contentDescription ="" )
            }
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Login here",
                style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold)
            )


            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Enter your mobile number",
                style = TextStyle(fontSize = 15.sp)
            )

            Surface(
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier
                    .padding(top = 40.dp, start = 5.dp, end = 5.dp)
                    .width(screenWidthDp * .95f)
                    .height(55.dp),
            ) {
                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "+91", modifier = Modifier.padding(10.dp))


                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(top = 1.dp, bottom = 1.dp)
                            .fillMaxHeight()  //fill the max height
                            .width(1.dp)
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        value = textState,
                        onValueChange = {
                            textState = it
                        },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                            containerColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                            IconButton(
                                onClick = {  }
                            ) {
                                Icon(painter = painterResource(id = R.drawable.cross), contentDescription = "", tint = Color(0xffE4E4E4))
                            }
                        }


                    )





                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(1.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4155)
            )
        ) {
            Text(text = "Get OTP Verification", color = Color.White)
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
            IconButton(modifier = Modifier, onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.backarrow), contentDescription = "")
            }
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Verify your Mobile Number",
                style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
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


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
        shape = RoundedCornerShape(2.dp),
        modifier = Modifier
            .width(70.dp)
            .height(70.dp),
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center,
            fontSize =  30.sp
        ), colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xffDDDDDD),
            unfocusedBorderColor = Color(0xffDDDDDD)
        )
    )
}


///////DASHBOARD//////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50.dp),
                containerColor = Color(0xffECECEC),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        tint = Color.Black
                    )
                })
        },
    ) { paddingValues ->
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
            .height(screenHeightDp * .28f)
            .fillMaxWidth()
            .background(color = Color(0xffFF4155))
            .padding(horizontal = 20.dp, vertical = 10.dp),
    ) {
        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {


            IconButton(modifier = Modifier, onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier
                    .width(150.dp)
                    .height(55.dp),

                ) {
                Row(
                    modifier = Modifier.background(color = Color(0xffFF4155)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(
                            vertical = 3.dp, horizontal = 10.dp
                        ),
                        text = "KOLKATA",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                        ),
                    )

                    IconButton(onClick = {

                    }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = null, tint = Color.White,
                        )
                    }
                }


            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(modifier = Modifier, onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }


                IconButton(modifier = Modifier, onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.profile),
                contentDescription = ""
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.Start) {
                Text(
                    modifier = Modifier,
                    text = "Dream Enterprises",
                    style = TextStyle(fontSize = 26.sp, color = Color.White)
                )
                Row(
                    modifier = Modifier, horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    Text(
                        text = "18,Padma Babu Road, Bally , Howrah",
                        style = TextStyle(fontSize = 12.sp, color = Color.White)
                    )


                }


                Row(
                    modifier = Modifier.padding(1.dp), horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    Text(
                        text = "+91 9876543210",
                        style = TextStyle(fontSize = 12.sp, color = Color.White)
                    )


                }
            }

        }
    }
}


@Composable
fun FeatureSection() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
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
                    Row(modifier = Modifier.weight(2f)) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Parties",
                            style = TextStyle(fontSize = 20.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
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
                    .padding(horizontal = 10.dp, vertical = 12.dp)
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
                    Row(modifier = Modifier.weight(2f)) {
                        Image(
                            painter = painterResource(id = R.drawable.grp),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Sales",
                            style = TextStyle(fontSize = 20.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
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
                    .padding(horizontal = 10.dp, vertical = 12.dp)
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
                    Row(modifier = Modifier.weight(2f)) {
                        Image(
                            painter = painterResource(id = R.drawable.item),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Items",
                            style = TextStyle(fontSize = 20.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
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
                    Row(modifier = Modifier.weight(2f)) {
                        Image(
                            painter = painterResource(id = R.drawable.payment),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Payments",
                            style = TextStyle(fontSize = 20.sp, color = Color(0xff848484))
                        )
                    }

                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "Total",
                                style = TextStyle(fontSize = 18.sp, color = Color(0xff848484))
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 1.dp),
                                text = "1200",
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
fun RouterScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(title = {
                Text(
                    "Routes", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp,
                    )
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(20.dp),
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
fun CardSection() {



    var checked by remember {
        mutableStateOf(false)
    }

    Column {
        OutlinedTextField(
            value = "Search Router",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 10.dp),
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier.size(48.dp), tint = Color(0xffADADAD)
                    )
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(6.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(

                textColor = Color(0xffC0C0C0),
                cursorColor = Color.Black,
                focusedBorderColor = Color(0xffC0C0C0),
                unfocusedBorderColor = Color(0xffC0C0C0)
            ),

        )



        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .height(80.dp),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 8.dp),
            ) {
                Row(modifier = Modifier.weight(7f), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xffFF4155))
                    ) {
                        Text(
                            "B", modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp), style = TextStyle(
                                color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                            )
                        )
                    }

                    Text(
                        "Bally", modifier = Modifier.padding(horizontal = 10.dp), style = TextStyle(
                            color = Color(0xff898989), fontSize = 14.sp,
                        )
                    )
                }


                Box(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(size = 20.dp)
                        .clip(CircleShape) // to remove the ripple effect on the corners
                        .clickable {
                            checked = !checked
                        }
                        .background(
                            color = if (checked) Color(0xffF22E4F) else White,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color = if (checked) White else Color.Gray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (checked) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }

            }
        }



        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .height(80.dp),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 8.dp),
            ) {
                Row(modifier = Modifier.weight(7f), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xffFF4155))
                    ) {
                        Text(
                            "H", modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp), style = TextStyle(
                                color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                            )
                        )
                    }

                    Text(
                        "Howrah",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        style = TextStyle(
                            color = Color(0xff898989), fontSize = 14.sp,
                        )
                    )
                }


                Box(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(size = 20.dp)
                        .clip(CircleShape) // to remove the ripple effect on the corners
                        .clickable {
                            checked = !checked
                        }
                        .background(
                            color = if (checked) Color(0xffF22E4F) else White,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color = if (checked) White else Color.Gray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (checked) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }


            }
        }



        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .height(80.dp),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            border = BorderStroke(width = 1.dp, color = Color(0xffC0C0C0))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 8.dp),
            ) {
                Row(modifier = Modifier.weight(7f), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xffFF4155))
                    ) {
                        Text(
                            "B", modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp), style = TextStyle(
                                color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center
                            )
                        )
                    }

                    Text(
                        "Belur", modifier = Modifier.padding(horizontal = 10.dp), style = TextStyle(
                            color = Color(0xff898989), fontSize = 14.sp,
                        )
                    )
                }





                Box(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(size = 20.dp)
                        .clip(CircleShape) // to remove the ripple effect on the corners
                        .clickable {
                            checked = !checked
                        }
                        .background(
                            color = if (checked) Color(0xffF22E4F) else White,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color = if (checked) White else Color.Gray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (checked) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }


            }
        }
    }
}

/////////productlist//////////


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen() {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50.dp),
            containerColor = Color(0xffECECEC),
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Color.Black
                )
            })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xffFF4155)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            UpperSection()
            LowerSection()
        }
    }

}


@Composable
fun UpperSection() {

    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp


    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp


    var locationState by remember { mutableStateOf(TextFieldValue("Search Store")) }

    Column(
        modifier = Modifier
            .height(screenHeightDp * .20f)
            .fillMaxWidth()
            .background(color = Color(0xffFF4155))
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {


            IconButton(modifier = Modifier, onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.wback),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }


            Text(
                "Bally", modifier = Modifier, style = TextStyle(
                    color = Color.White, fontSize = 20.sp,
                )
            )



            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {

                IconButton(modifier = Modifier, onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(20.dp)
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
                modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .background(color = Color(0xffFFEB56))
                        .weight(1.2f)
                        .fillMaxHeight()
                        .padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enter Location",
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )


                    IconButton(onClick = {

                    }) {
                        Icon(
                            modifier = Modifier.size(12.dp),
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = null,
                            tint = Color.Black,
                        )
                    }


                }
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BasicTextField(
                        modifier = Modifier.padding(2.dp),
                        value = locationState,
                        onValueChange = {
                            locationState = it
                        },
                        maxLines = 1,
                    )


                    IconButton(onClick = {

                    }) {
                        Icon(
                            modifier = Modifier.size(17.dp),
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
fun LowerSection() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
    ) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Store List",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W400)
                )

                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "View all", style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0xffB7B7B7)
                        )
                    )

                }
            }



            Divider(
                color = Color(0xffB7B7B7), modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
            )


            gridView(LocalContext.current)
        }

    }
}


@Composable
fun gridView(context: Context) {
   // val numbers = (1..12).toList()
    val numbers = remember {
        mutableStateListOf(
            *List(12) {
                ProductList(
                    id = it,
                    pName = "Ram Kiran Store",
                    image = ""
                )
            }.toTypedArray()
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(10.dp)
    ) {
        items(numbers.size) {

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(110.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(6.dp),
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
                        text = "Ram Kiran Store" , style = TextStyle(fontSize = 12.sp), modifier = Modifier.padding(4.dp), color = Color.Black
                    )
                }
            }
        }
    }
}

data class ProductList(
    val id: Any,
    val pName: String,
    val image : String
)




///////NewStore//////


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStoreScreen() {



    var storeName by remember { mutableStateOf(TextFieldValue("Enter Your Owner Name")) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(title = {
                Text(
                    "Add New Store", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp,
                    )
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(20.dp),
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
fun TextFieldSection() {


    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Name",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Owner Name", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )


        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = " Shop Name",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Shop Name", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )



        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Location",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Shop Name", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
        {


            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                    text = "Mobile No",
                    style = TextStyle(fontWeight = FontWeight.W500)
                )


                OutlinedTextField(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                    value = "",
                    onValueChange = {},
                    maxLines = 1,
                    placeholder = {Text("Enter Your Mobile No", style = TextStyle(color = Color(0xffDDDDDD)))},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDDDDDD),
                        unfocusedBorderColor = Color(0xFFDDDDDD)
                    )

                )
            }



            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                    text = "PinCode",
                    style = TextStyle(fontWeight = FontWeight.W500)
                )


                OutlinedTextField(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                    value = "",
                    onValueChange = {},
                    maxLines = 1,
                    placeholder = {Text("Enter Your Pincode", style = TextStyle(color = Color(0xffDDDDDD)))},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(4.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDDDDDD),
                        unfocusedBorderColor = Color(0xFFDDDDDD)
                    )
                )
            }

        }



        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "GST Number(Optional)",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your GST Number", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )

        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Email ID",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Email id", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )


        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Aadhar card",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Aadhar card no", style = TextStyle(color = Color(0xffDDDDDD)))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )


        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "WhatsApp Number",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your WhatsApp Number", style = TextStyle(color = Color(0xffDDDDDD)))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )


        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Feedback",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Feedback", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            ),
            trailingIcon = {
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Clear", tint = Color(0xff757575)
                    )
                }
            }
        )


        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Next visit Date",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = "",
            onValueChange = {},
            maxLines = 1,
            placeholder = {Text("Enter Your Select Visit Date", style = TextStyle(color = Color(0xffDDDDDD)))},
            shape = RoundedCornerShape(4.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDDDDDD),
                unfocusedBorderColor = Color(0xFFDDDDDD)
            )
        )

        Text(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            text = "Upload Shop Image",
            style = TextStyle(fontWeight = FontWeight.W500)
        )


        Card(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            colors =CardDefaults.cardColors(
                containerColor = Color(0xffFFFFFF)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            ),
            border = BorderStroke(2.dp, Color(0xffDDDDDD)),
            shape = RoundedCornerShape(2.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 10.dp), horizontalAlignment = Alignment.CenterHorizontally  , verticalArrangement = Arrangement.Center) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.camera), contentDescription = "")
                }
                Text(text = "Back")
            }
        }


        Button(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(60.dp), onClick = {

            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffFFEB56),
                contentColor = Color.Black
            ), shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = "SAVE", style = TextStyle(fontSize = 16.sp,fontWeight = FontWeight.W500))
        }
    }

}


////////storeSearchSection//////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreSearchScreen() {

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(title = {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(48.dp),
                    value = "",
                    onValueChange = {},
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(id = R.drawable.srch),
                            contentDescription = ""
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        containerColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White
                    ),
                    placeholder = {
                        Text(text = "Ram Krishna Store", style = TextStyle(color = Color(0xff898989), fontWeight = FontWeight.Bold))
                    }
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )
            TabSection()
        }
    }

}

@Composable
fun TabSection() {
    val selectedTab = remember { mutableStateOf("Visited") }
    val stores = remember {
        mutableStateListOf(
            *List(10) {
                Store(
                    id = it,
                    name = "Ram Krishna Store",
                    address = "#93SARJAPUR ROAR",
                    amount = (500..5000).random().toFloat(),
                    stage = Store.Stage.values().random()
                )
            }.toTypedArray()
        )
    }
    val effectiveStores = remember {
        mutableStateListOf<Store>(
            *
            stores.filter { it.stage == Store.Stage.Visited }.toTypedArray()
        )
    }

    val onTabClicked = fun(tab: String) {
        selectedTab.value = tab
        effectiveStores.apply {
            clear()
            when (selectedTab.value) {
                "Visited" -> {
                    addAll(stores.filter { it.stage == Store.Stage.Visited })
                }

                "Pending" -> {
                    addAll(stores.filter { it.stage == Store.Stage.Pending })
                }

                "Completed" -> {
                    addAll(stores.filter { it.stage == Store.Stage.Completed })
                }

                else -> {
                    addAll(stores)
                }
            }

        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Visited",
                    color = if (selectedTab.value == "Visited") Color.Black else Color(0xffDCDCDC),
                    modifier = Modifier
                        .clickable {
                            onTabClicked("Visited")
                        }
                        .padding(12.dp),
                    fontWeight = if (selectedTab.value == "Visited") FontWeight.Bold else FontWeight.Normal)
                Text("Completed",
                    color = if (selectedTab.value == "Completed") Color.Black else Color(0xffDCDCDC),
                    modifier = Modifier
                        .clickable {
                            onTabClicked("Completed")
                        }
                        .padding(12.dp),
                    fontWeight = if (selectedTab.value == "Completed") FontWeight.Bold else FontWeight.Normal)
                Text("Pending",
                    color = if (selectedTab.value == "Pending") Color.Black else Color(0xffDCDCDC),
                    modifier = Modifier
                        .clickable {
                            onTabClicked("Pending")
                        }
                        .padding(12.dp),
                    fontWeight = if (selectedTab.value == "Pending") FontWeight.Bold else FontWeight.Normal)
                Text("All",
                    color = if (selectedTab.value == "All") Color.Black else Color(0xffDCDCDC),
                    modifier = Modifier
                        .clickable {
                            onTabClicked("All")
                        }
                        .padding(12.dp),
                    fontWeight = if (selectedTab.value == "All") FontWeight.Bold else FontWeight.Normal)
            }
            LazyColumn {
                items(effectiveStores) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xffFFFFFF)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        ),
                        border = BorderStroke(1.dp, Color(0xffDDDDDD)),
                        shape = RoundedCornerShape(2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xffFF4155))
                            ) {
                                Text(
                                    "B",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 3.dp),
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                            Column(modifier = Modifier) {
                                Text(
                                    it.name, style = TextStyle(
                                        fontWeight = FontWeight.Bold, fontSize = 18.sp
                                    )
                                )
                                Text(
                                    it.address, style = TextStyle(
                                        fontWeight = FontWeight.W500,
                                        fontSize = 14.sp,
                                        color = Color(0xFFDDDDDD)
                                    )
                                )
                            }


                            Column(
                                modifier = Modifier.padding(top = 8.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text("₹"+ it.amount.toString())
                                //Text(it.stage.name)
                            }
                        }
                    }

                }
            }
        }
    }

}


data class Store(
    val id: Any, val name: String, val address: String, val amount: Float, val stage: Stage
) {
    enum class Stage {
        Pending, Visited, Completed
    }
}


///////storeDetail////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreDetailScreen() {
    Scaffold() { paddingValues ->
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
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Start) {


            IconButton(modifier = Modifier, onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.wback),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }



            OutlinedTextField(
                modifier = Modifier.height(48.dp),
                value = "",
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.srch),
                        contentDescription = ""
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                placeholder = {
                    Text(text = "Ram Krishna Store", style = TextStyle(color = Color(0xff898989), fontWeight = FontWeight.Bold))
                }
            )



            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(modifier = Modifier, onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.on),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }



        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {

                Text(
                    modifier = Modifier,
                    text = "Ram Krishna Store",
                    style = TextStyle(fontSize = 26.sp, color = Color.White)
                )
                Row(
                    modifier = Modifier, horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    Text(
                        text = "#93SARJAPUR ROAR",
                        style = TextStyle(fontSize = 18.sp, color = Color.White)
                    )


                }


                Row(
                    modifier = Modifier.padding(1.dp), horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    Text(
                        text = "+91 9876543210",
                        style = TextStyle(fontSize = 14.sp, color = Color.White)
                    )


                }
            }

        }
    }
}


@Composable
fun ProductListSection() {

    var isSourceExpanded = remember {
        mutableStateOf<Boolean>(false)
    }

    val salesBtn = remember {
        mutableStateOf<Boolean>(false)
    }

    val paymentBtn = remember {
        mutableStateOf<Boolean>(false)
    }

    val btnClr = remember {
        mutableStateOf<Boolean>(false)
    }
    val pbtnClr = remember {
        mutableStateOf<Boolean>(false)
    }


    val sales = remember {
        mutableStateListOf(
            *List(4) {
                Sales(
                    id = it,
                    name = "Ram Krisna Store",
                    date = "05,Aug,2023",
                    time = "12:40 Pm",
                    totalAmount = (500..5000).random().toFloat(),
                    duesAmount = (50..1500).random().toFloat()
                )
            }.toTypedArray()
        )
    }

    val payment = remember {
        mutableStateListOf(
            *List(5) {
                Payments(
                    id = it,
                    name = "Shop",
                    date = "05,Aug,2023",
                    time = "12:40 Pm",
                    totalAmount = (500..5000).random().toFloat(),
                    paymentMode = "Online"

                )
            }.toTypedArray()
        )
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 15.dp, horizontal = 10.dp
                    ), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(modifier = Modifier
                    .clickable {
                        isSourceExpanded.value = !isSourceExpanded.value
                    }
                    .shadow(4.dp)
                    .height(120.dp)
                    .width(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(80.dp),
                            painter = painterResource(id = R.drawable.mcircle),
                            contentDescription = ""
                        )
                        Text(text = "Visit Shop", style = TextStyle(fontSize = 12.sp))

                    }


                }
                ShowDialog(
                    dialogState = isSourceExpanded,
                    onDismissRequest = { isSourceExpanded.value = false },
                    headerText = "Allow Sales on to access this devices location?"
                )






                Card(
                    modifier = Modifier
                        .shadow(4.dp)
                        .height(120.dp)
                        .width(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(80.dp),
                            painter = painterResource(id = R.drawable.sales),
                            contentDescription = ""
                        )
                        Text(text = "New sales", style = TextStyle(fontSize = 12.sp))

                    }


                }



                Card(
                    modifier = Modifier
                        .shadow(4.dp)
                        .height(120.dp)
                        .width(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF),
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(80.dp),
                            painter = painterResource(id = R.drawable.paymentt),
                            contentDescription = ""
                        )
                        Text(text = "Payment", style = TextStyle(fontSize = 12.sp))

                    }


                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Past Transaction", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                Text(
                    text = "View all",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color(0xffF22E4F)
                )
            }


            Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                OutlinedButton(
                    onClick = {
                        salesBtn.value = true
                        paymentBtn.value = false
                        btnClr.value = true
                        pbtnClr.value = false
                    },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (btnClr.value) Color(0xffF22E4F) else Color.White,
                        contentColor = if (btnClr.value) Color.White else Color.Black
                    ),
                    border = BorderStroke(
                        1.dp, color = if (btnClr.value) Color(0xffF22E4F) else Color(0xffB7B7B7)
                    )
                ) {
                    Text(text = "Sales")
                }




                OutlinedButton(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    onClick = {
                        paymentBtn.value = true
                        salesBtn.value = false
                        btnClr.value = false
                        pbtnClr.value = true
                    },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (pbtnClr.value) Color(0xffF22E4F) else Color.White,
                        contentColor = if (pbtnClr.value) Color.White else Color.Black
                    ),
                    border = BorderStroke(
                        1.dp, color = if (pbtnClr.value) Color(0xffF22E4F) else Color(0xffB7B7B7)
                    )
                ) {
                    Text(text = "Payments")
                }
            }

            if (salesBtn.value) {
                LazyColumn {
                    items(sales) {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xffFFFFFF)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp
                            ),
                            border = BorderStroke(1.dp, Color(0xffDDDDDD)),
                            shape = RoundedCornerShape(2.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {


                                Column(modifier = Modifier) {
                                    Text(
                                        it.name, style = TextStyle(
                                            fontWeight = FontWeight.Bold, fontSize = 18.sp
                                        )
                                    )
                                    Text(
                                        it.date, style = TextStyle(
                                            fontWeight = FontWeight.W500,
                                            fontSize = 14.sp,
                                            color = Color(0xFFDDDDDD)
                                        )
                                    )
                                    Text(
                                        it.time, style = TextStyle(
                                            fontWeight = FontWeight.W500,
                                            fontSize = 14.sp,
                                            color = Color(0xFFDDDDDD)
                                        )
                                    )
                                }


                                Column(
                                    modifier = Modifier, verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Total", style = TextStyle(
                                            fontWeight = FontWeight.Bold, fontSize = 16.sp
                                        )
                                    )
                                    Text(
                                        "Rs." + it.totalAmount.toString(),
                                        modifier = Modifier.padding(top = 5.dp)
                                    )
                                    //Text(it.stage.name)
                                }

                                Column(
                                    modifier = Modifier,
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Dues", style = TextStyle(
                                            fontWeight = FontWeight.Bold, fontSize = 16.sp
                                        )
                                    )
                                    Text(
                                        "Rs." + it.duesAmount.toString(),
                                        modifier = Modifier.padding(top = 5.dp)
                                    )
                                    //Text(it.stage.name)
                                }
                            }
                        }

                    }
                }
            }

            if (paymentBtn.value) {
                LazyColumn {
                    items(payment) {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xffFFFFFF)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp
                            ),
                            border = BorderStroke(1.dp, Color(0xffDDDDDD)),
                            shape = RoundedCornerShape(2.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {


                                Column(modifier = Modifier) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            it.name, style = TextStyle(
                                                fontWeight = FontWeight.Bold, fontSize = 18.sp
                                            )
                                        )


                                        Text(
                                            "Rs." + it.totalAmount.toString(), style = TextStyle(
                                                fontWeight = FontWeight.W500,
                                                fontSize = 18.sp,
                                                color = Color.LightGray
                                            )
                                        )
                                    }

                                    Text(
                                        it.date, style = TextStyle(
                                            fontWeight = FontWeight.W500,
                                            fontSize = 14.sp,
                                            color = Color(0xFFDDDDDD)
                                        )
                                    )

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            it.time, style = TextStyle(
                                                fontWeight = FontWeight.W500,
                                                fontSize = 14.sp,
                                                color = Color(0xFFDDDDDD)
                                            )
                                        )

                                        Text(
                                            it.paymentMode,
                                            style = TextStyle(fontSize = 12.sp, color = Color.Black)
                                        )
                                    }

                                }
                            }
                        }

                    }
                }
            }


        }


    }

}

@Composable
fun ShowDialog(
    dialogState: State<Boolean>,
    onDismissRequest: () -> Unit,
    headerText: String,
) {
    if (dialogState.value) {
        Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
            Surface(
                modifier = Modifier
                    .width(400.dp)
                    .height(250.dp), shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(top = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(painter = painterResource(id = R.drawable.bl), contentDescription = "")
                    Text(
                        text = headerText,
                        style = TextStyle(fontWeight = FontWeight.W500, fontSize = 18.sp),
                        textAlign = TextAlign.Center
                    )
                    Divider()
                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
                        Text(
                            text = "WHILE ESING THE APP", style = TextStyle(
                                fontWeight = FontWeight.W500,
                                fontSize = 16.sp,
                                color = Color(0xff9A9A9A)
                            ), textAlign = TextAlign.Center
                        )
                    }
                    Divider()

                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
                        Text(
                            text = "ONLY THIS TIME", style = TextStyle(
                                fontWeight = FontWeight.W500,
                                fontSize = 16.sp,
                                color = Color(0xff9A9A9A)
                            ), textAlign = TextAlign.Center
                        )
                    }
                    Divider()

                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                        Text(
                            text = "DONT ALLOW", style = TextStyle(
                                fontWeight = FontWeight.W500,
                                fontSize = 16.sp,
                                color = Color(0xff9A9A9A)
                            ), textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


data class Sales(
    val id: Any,
    val name: String,
    val date: String,
    val time: String,
    val totalAmount: Float,
    val duesAmount: Float
)


data class Payments(
    val id: Any,
    val name: String,
    val date: String,
    val time: String,
    val totalAmount: Float,
    val paymentMode: String
)


////////InvoiceScreen/////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(title = {
                Text(
                    "Ram Krishna Stores", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp,
                    )
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )


            InvoiceSection()


        }
    }
}

@Composable
fun InvoiceSection() {
    val itemDetails = remember {
        mutableStateListOf(
            *List(4) {
                ItemDetails(
                    id = it,
                    itemName = "Top Star Creaks Biscuit",
                    itemQty = "4",
                    itemPrice = "100",
                    totalPrice = "400",
                )
            }.toTypedArray()
        )
    }
    val invoiceDetails = remember {
        mutableStateOf(
            InvoiceDetails(
                taxableAmount = "1680",
                taxes = "50",
                discount = "00",
                totalAmount = "1730",
                invoiceDate = "Jun 12,2023 07:30",
                invoiceType = "Sales",
                invoiceAddress = "Nishchinda, Sapuipara, Howrah, West Bengal 711227",
            )
        )
    }


    Column(modifier = Modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "Items",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W500)
        )

        LazyColumn {
            items(itemDetails) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFFFFF)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    ),
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                it.itemName,
                                style = TextStyle(fontWeight = FontWeight.W600, fontSize = 16.sp, color = Color(0xff222222))
                            )
                            Text(
                                "x${it.itemQty}", style = TextStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp,
                                    color = Color(0xFF000000)
                                )
                            )
                            Text(
                                it.totalPrice, style = TextStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp,
                                    color = Color(0xFF000000)
                                )
                            )
                        }

                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "${it.itemPrice}/pcs", style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500,
                                    color = Color(0xFF000000)
                                )
                            )
                        }
                    }

                }

            }
        }
        Divider()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Taxable Amount",
                    style = TextStyle(fontWeight = FontWeight.W400, fontSize = 18.sp, color = Color(0xff222222))
                )
                Text(
                    invoiceDetails.value.taxableAmount, style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF000000)
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Taxes",
                    style = TextStyle(fontWeight = FontWeight.W400, fontSize = 18.sp,color = Color(0xff222222))
                )
                Text(
                    invoiceDetails.value.taxes, style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF000000)
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Discount",
                    style = TextStyle(fontWeight = FontWeight.W400, fontSize = 18.sp,color = Color(0xff222222))
                )
                Text(
                    invoiceDetails.value.discount, style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF000000)
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total",
                    style = TextStyle(fontWeight = FontWeight.W500, fontSize = 18.sp,color = Color(0xff222222))
                )
                Text(
                    invoiceDetails.value.totalAmount, style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF000000,)
                    )
                )
            }
        }
        Divider()
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            text = "Invoice Details",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W500,color = Color(0xff222222))
        )


        Column(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Amount",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400,color = Color(0xff222222))
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = invoiceDetails.value.totalAmount,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500)
            )
        }

        Column(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Date",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400,color = Color(0xff222222))
            )
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = invoiceDetails.value.invoiceDate,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500)
            )
        }

        Column(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Type",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400,color = Color(0xff222222))
            )


            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = invoiceDetails.value.invoiceType,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500)
            )
        }

        Column(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Address",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W400,color = Color(0xff222222))
            )


            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = invoiceDetails.value.invoiceAddress,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500)
            )
        }

    }

}


data class ItemDetails(
    val id: Any,
    val itemName: String,
    val itemQty: String,
    val itemPrice: String,
    val totalPrice: String,
)


data class InvoiceDetails(
    val taxableAmount: String,
    val taxes: String,
    val discount: String,
    val totalAmount: String,
    val invoiceDate: String,
    val invoiceType: String,
    val invoiceAddress: String
)


////////VisitScreen///////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitScreen() {

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopAppBar(title = {
                Text(
                    "Make Visit", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                        color = Color.White, fontSize = 20.sp,
                    )
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )



            MapSection()


        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(width = 370.dp, height = 150.dp)
        ) {
            val singapore = LatLng(1.35, 103.87)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(singapore, 10f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                uiSettings = MapUiSettings(),
                properties = MapProperties()


            ) {

                Marker(
                    position = singapore, title = "Singapore", snippet = "Marker in Singapore"
                )

            }
        }


        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )



        Button(modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .fillMaxWidth()
            .height(50.dp),
            onClick = {
                //your onclick code here
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffFFEB56),
                contentColor = Color.Black

            ), shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = "VISIT SHOP")
        }
    }
}


//////NewSales//////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewSaleScreen() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TopAppBar(title = {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(48.dp),
                    value = "",
                    onValueChange = {},
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(id = R.drawable.srch),
                            contentDescription = ""
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        containerColor = Color.White,
                        focusedBorderColor = Color.White
                    )
                )
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )

            ItemSection()

        }

    }
}

@Composable
fun ItemSection() {
    val selectTab = remember { mutableStateOf("All") }



    val salesBtn = remember {
        mutableStateOf<Boolean>(false)
    }

    val paymentBtn = remember {
        mutableStateOf<Boolean>(false)
    }

    val btnClr = remember {
        mutableStateOf<Boolean>(false)
    }
    val pbtnClr = remember {
        mutableStateOf<Boolean>(false)
    }
    
    
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp)) {
        Text(text = "Categories", style = TextStyle(fontSize = 18.sp,fontWeight = FontWeight.Bold))
        Row(modifier = Modifier) {
            OutlinedButton(
                onClick = {
                    paymentBtn.value = false
                    salesBtn.value = true
                    btnClr.value = true
                    pbtnClr.value = false
                },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (btnClr.value) Color(0xffFFEB56) else Color.White,
                    contentColor = if (btnClr.value) Color.White else Color.Black
                ),
                border = BorderStroke(
                    1.dp, color = if (btnClr.value) Color(0xffFFEB56) else Color.Black2
                )
            ) {
                Text(text = "Sales")
            }




            OutlinedButton(
                modifier = Modifier.padding(horizontal = 10.dp),
                onClick = {
                    paymentBtn.value = true
                    salesBtn.value = false
                    btnClr.value = false
                    pbtnClr.value = true
                },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (pbtnClr.value) Color(0xffF22E4F) else Color.White,
                    contentColor = if (pbtnClr.value) Color.White else Color.Black
                ),
                border = BorderStroke(
                    1.dp, color = if (pbtnClr.value) Color(0xffF22E4F) else Color(0xffB7B7B7)
                )
            ) {
                Text(text = "Payments")
            }
        }
    }

   


}


data class Product(
    val id: Any,
    val name: String,
    val subtitle: String,
    val saleValue: String,
    val itemPrice: String,
    val totalAmount: Float,
)



////ReviewCart///

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewCartScreen() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TopAppBar(title = {
                Column {
                    Text(
                        text = "Review Cart",
                        style = TextStyle(fontSize = 20.sp),
                        color = Color.White
                    )
                    Text(
                        text = "#93SARJAPUR ROAR",
                        style = TextStyle(fontSize = 12.sp),
                        color = Color.White
                    )
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )

            AddItem()

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem() {


    var isSuccessExpanded = remember {
        mutableStateOf<Boolean>(false)
    }

    val items = remember {
        mutableStateListOf(
            *List(3) {
                Item(
                    id = it,
                    name = "Top Star Creaks Biscuit",
                    saleValue = "100",
                    itemPrice = "3000",
                    itemQty = "30",

                    )
            }.toTypedArray()
        )
    }


    val invoiceDetails = remember {
        mutableStateOf(
            DetailPayment(
                taxableAmount = "15000", cgst = "50", gst = "50", totalAmount = (15100.00).toFloat()
            )
        )
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(top = 8.dp), text = "Items", style = TextStyle(
                        color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "+Add item", style = TextStyle(
                            color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Divider()


            LazyColumn {
                items(items) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xffFFFFFF)
                        ),
                        //      border = BorderStroke(1.dp, Color(0xffDDDDDD)),
                        shape = RoundedCornerShape(2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Column(modifier = Modifier) {
                                Text(
                                    it.name, style = TextStyle(
                                        fontWeight = FontWeight.W500, fontSize = 18.sp
                                    )
                                )
                                Text(
                                    "${it.saleValue}/pcs", style = TextStyle(
                                        fontWeight = FontWeight.W600, fontSize = 16.sp
                                    )
                                )
                                Text(modifier = Modifier.padding(top = 10.dp) ,text = "Remove", style = TextStyle(color = Color(0xffBEBEBE)))
                            }


                            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .width(60.dp),
                                    value = it.itemQty,
                                    onValueChange = {},
                                    textStyle = TextStyle(
                                        textAlign = TextAlign.Center, fontSize = 16.sp
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                )

                                Text(
                                    "₹" + it.itemPrice.toString(), style = TextStyle(
                                        fontWeight = FontWeight.W900, fontSize = 18.sp
                                    ), modifier = Modifier.padding(top = 5.dp)
                                )
                                //Text(it.stage.name)
                            }


                        }
                    }

                }
            }

            Divider()


            Text(
                text = "Payment Details",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal =20.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(modifier = Modifier.padding(horizontal = 10.dp),text = "Taxable Amount", style = TextStyle(fontSize = 18.sp))

                Text(
                    text = invoiceDetails.value.taxableAmount,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(modifier = Modifier.padding(horizontal = 10.dp),text = "CGST", style = TextStyle(fontSize = 16.sp))

                Text(
                    text = invoiceDetails.value.cgst,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(modifier =Modifier.padding(horizontal = 10.dp),text = "GST", style = TextStyle(fontSize = 16.sp))

                Text(
                    text = invoiceDetails.value.gst,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(modifier = Modifier.padding(horizontal = 10.dp),
                    text = "TOTAL",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )

                Text(modifier = Modifier.padding(horizontal = 10.dp),
                    text = invoiceDetails.value.totalAmount.toString(),
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
            }
        }


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "view item${items.size}")
                Text(
                    text = invoiceDetails.value.totalAmount.toString(),
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Button(modifier = Modifier.width(200.dp),
                    onClick = {
                        isSuccessExpanded.value = !isSuccessExpanded.value
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFFEB56), contentColor = Color.Black
                    ), shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = "Place Order")
                }


                ShowSuccessDialog(
                    dialogState = isSuccessExpanded,
                    onDismissRequest = { isSuccessExpanded.value = false },
                    headerText = "Order Placed Successful !"

                )


            }

        }
    }

}

@Composable
fun ShowSuccessDialog(
    dialogState: State<Boolean>,
    onDismissRequest: () -> Unit,
    headerText: String,
) {
    if (dialogState.value) {
        Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
            Surface(
                modifier = Modifier
                    .width(400.dp)
                    .height(210.dp), shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.nelipse),
                        contentDescription = "",
                    )
                    Text(
                        text = headerText,
                        style = TextStyle(fontWeight = FontWeight.W500, fontSize = 18.sp),
                        textAlign = TextAlign.Center
                    )
                    Button(
                        modifier = Modifier.width(120.dp), onClick = {

                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffF22E4F), contentColor = Color.Black
                        ), shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(text = "Ok", style = TextStyle(color = Color.White, fontWeight = FontWeight.W500))
                    }


                }
            }
        }
    }
}


data class Item(
    val id: Any,
    val name: String,
    val saleValue: String,
    val itemPrice: String,
    val itemQty: String,
)


data class DetailPayment(
    val taxableAmount: String,
    val cgst: String,
    val gst: String,
    val totalAmount: Float,
)


//////Payment//////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TopAppBar(title = {
                Column(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                    Text(
                        text = "Payment in",
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.White
                    )
                    Text(
                        text = "Ram Krishna Store",
                        style = TextStyle(fontSize = 22.sp),
                        color = Color.White
                    )
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffF22E4F)),
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Image(

                            modifier = Modifier
                                .size(30.dp)
                                .padding(horizontal = 8.dp),
                            painter = painterResource(id = R.drawable.wback),
                            contentDescription = null,
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.on),
                            contentDescription = null
                        )
                    }
                }

            )

            PaymentListScetion()

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentListScetion() {

    var isPaymentExpanded = remember {
        mutableStateOf<Boolean>(false)
    }

    val storepayment = remember {
        mutableStateListOf(
            *List(3) {
                StorePayment(
                    id = it,
                    storeName = "Ram Krishna Store",
                    storeDate = "05,Aug,2023",
                    storeTime = "12:40 Pm",
                    prevAmount = (10000).toFloat(),
                    dueAmount = (7000).toFloat(),
                    paidAmount = (3000).toFloat(),
                )
            }.toTypedArray()
        )
    }


    var checked by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier) {
            LazyColumn {
                items(storepayment) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xffFFFFFF)
                        ),
                        border = BorderStroke(1.dp, Color(0xffDDDDDD)),
                        shape = RoundedCornerShape(2.dp)
                    ) {
                        Row(modifier = Modifier, verticalAlignment = Alignment.Top) {

                            Box(
                                modifier = Modifier
                                    .padding(top = 15.dp, start = 5.dp, end = 5.dp)
                                    .size(size = 20.dp)
                                    .clip(CircleShape) // to remove the ripple effect on the corners
                                    .clickable {
                                        checked = !checked
                                    }
                                    .background(
                                        color = if (checked) Color(0xffF22E4F) else White,
                                        shape = CircleShape
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = if (checked) White else Color.Gray,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                if (checked) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = White
                                    )
                                }
                            }


                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Text(
                                        it.storeName, style = TextStyle(
                                            fontSize = 18.sp, fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text("₹${it.prevAmount.toString()}")
                                }


                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(it.storeDate, style = TextStyle(fontSize = 14.sp))
                                    Text("₹${it.dueAmount.toString()} Due")
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(it.storeTime, style = TextStyle(fontSize = 14.sp))
                                    /*OutlinedTextField(
                                        modifier = Modifier,
                                        value = "₹${it.paidAmount.toString()}",
                                        onValueChange = {},
                                        textStyle = TextStyle(
                                            textAlign = TextAlign.Center, fontSize = 10.sp
                                        ),
                                        shape = RoundedCornerShape(8.dp)
                                    )*/
                                    BasicTextField(
                                        value = "₹${it.paidAmount.toString()}",
                                        onValueChange = {}, modifier = Modifier.padding(horizontal = 5.dp)
                                    ) { textField ->
                                        Column(
                                            modifier = Modifier
                                                .width(85.dp)
                                                .border(width = 1.dp, color = Color.LightGray)
                                                .padding(12.dp),
                                        ) {
                                            textField()
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            }
            Text(
                text = "Payment Type",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Row(modifier = Modifier.padding(vertical = 15.dp)) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = "Cash", style = TextStyle(color = Color.Black))
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = "Online", style = TextStyle(color = Color.Black))
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = "Cheque", style = TextStyle(color = Color.Black))
                }
            }
            Divider()
        }


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Amount", style = TextStyle())
                    Text(modifier = Modifier.padding(horizontal = 5.dp),
                        text = "₹3000",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }

                Button(modifier = Modifier.width(200.dp),
                    onClick = {
                            isPaymentExpanded.value = !isPaymentExpanded.value
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFFEB56), contentColor = Color.Black
                    ), shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = "Save")
                }


                ShowPaymentDialog(
                    dialogState = isPaymentExpanded,
                    onDismissRequest = { isPaymentExpanded.value = false },
                    headerText = "Payment received successfully")

            }

        }
    }

}


@Composable
fun ShowPaymentDialog(
    dialogState: State<Boolean>,
    onDismissRequest: () -> Unit,
    headerText: String,
) {
    if (dialogState.value) {
        Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
            Surface(
                modifier = Modifier
                    .width(400.dp)
                    .height(210.dp), shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.nelipse),
                        contentDescription = "",
                    )
                    Text(
                        text = headerText,
                        style = TextStyle(fontWeight = FontWeight.W500, fontSize = 18.sp),
                        textAlign = TextAlign.Center
                    )
                    Button(
                        modifier = Modifier.width(180.dp), onClick = {

                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffF22E4F), contentColor = Color.Black
                        ), shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(text = "Back Dues Paid", style = TextStyle(color = Color.White, fontSize = 16.sp,fontWeight = FontWeight.W500))
                    }


                }
            }
        }
    }
}


data class StorePayment(
    val id: Any,
    val storeName: String,
    val storeDate: String,
    val storeTime: String,
    val prevAmount: Float,
    val dueAmount: Float,
    val paidAmount: Float
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JayaSalesLatestTheme {

    }
}


