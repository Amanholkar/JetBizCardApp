package com.example.jetbizcardapp

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcardapp.ui.theme.JetBizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}



@Composable
fun CreateBizCard(){

    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxSize(),
    color = MaterialTheme.colors.background) {


        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 0.dp),
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            elevation = 8.dp,
            backgroundColor = MaterialTheme.colors.background
       )
         {
             Column {
                 HeaderView()
                 InfoSection()

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))

                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .height(45.dp),
                 horizontalArrangement = Arrangement.Center) {
                     Button(
                         onClick = {
                             buttonClickedState.value = !buttonClickedState.value
                         },
                         shape = RoundedCornerShape(12.dp),
                     ) {
                         Text(text = "Portfolio",
                         )

                     }
                 }
                 
                 if(buttonClickedState.value){
                     Content()
                 }else{
                     Box() {
                         
                     }
                 }


             }



        }

    }
}


@Composable
fun Content(){
    
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)
        ){

        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp,Color.LightGray)
        ) {

           Portfolio(data = listOf("Project 1",
               "Project 2",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3",
               "Project 3"))

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {

    LazyColumn{
        items(data){item ->

        Text(item)

        }
    }

}




@Composable
private fun InfoSection(modifier: Modifier =Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 50.dp)
    ) {

        Text(
            text = "Aman Holkar",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = MaterialTheme.colors.primaryVariant
        )

        Text(
            text = "Android Compose Programmer",
            fontSize = 12.sp
        )

        Text(
            text = "@themilesCompose",
            fontSize = 12.sp
        )
    }
}

@Composable
private fun HeaderView(modifier: Modifier =Modifier) {
    Column {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile_img),
                contentDescription = "profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
                    .padding(top = 30.dp)
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        ) {

        }
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(2.dp),
//            color = Color.Blue.copy(alpha = 0.3f)
//        ) {
//
//        }
        Divider()


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardAppTheme {
    CreateBizCard()
    }
}