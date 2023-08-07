package com.jaya.app.jayasaleslatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
                    DashboardScreen()


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


                   /* OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text("000-0000-000", style = TextStyle(color = Color.LightGray))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.LightGray,
                            unfocusedBorderColor =  Color.LightGray,
                        )
                    )*/

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



@Composable
fun DashboardScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        GreetingSection()
        FeatureSection()
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

    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JayaSalesLatestTheme {

    }
}