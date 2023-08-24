package com.example.cobauiandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cobauiandroid.ui.theme.CobaUIAndroidTheme
import com.example.cobauiandroid.ui.theme.LatarBelakang
import com.example.cobauiandroid.ui.theme.OrangeButton

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(LatarBelakang)
        .padding(vertical = 10.dp)){
        Column {
            GreetingText()
            ProjectName()
            Pilihan(Items = listOf( ItemsPilihan(
                title = "GreenHouse",
                iconId =Icons.Default.Home,
                color = Color.Magenta
            ),
                ItemsPilihan(
                    title ="Cyber Punk",
                    iconId = Icons.Default.Settings,
                    color = Color.Green
                ),
                ItemsPilihan(
                    title = "Landing Page",
                    iconId = Icons.Default.LocationOn,
                    color = OrangeButton
                )
            )
            )
            TaskBar(task = listOf(
                TaskChips(
                    iconId=Icons.Default.Done,
                    Description = "Create Initial Layout",
                    color = Color.Green
                ),
                TaskChips(
                    iconId = Icons.Default.Done,
                    Description = "Fixing Icon With Transparent",
                    color = Color.Blue
                )
            ))
        }
    }
}

@Composable
fun GreetingText(){
    Text(text = "Hai, Arya Bramaputra",
        color = Color.White)
}

@Composable
fun ProjectName(){
    Row(
        modifier= Modifier.padding(10.dp)
    ) {
        Text(text = "Projects",
            color = Color.White,
            )
        Text(text="(13)",
            color = Color.Gray)
    }
}

@Composable
fun Pilihan(Items: List<ItemsPilihan>)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(15.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
    ) {
        LazyRow{
            items(Items.size){
                index -> val item = Items[index]
                Box(modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)){
                    Text(text = item.title, color =item.color)
                }
            }
        }
    }
}

@Composable
fun TaskBar(task: List<TaskChips>){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .clip(RoundedCornerShape(10.dp))
        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
    ){
        LazyColumn{items(task.size){
            index -> val tasks = task[index]
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(imageVector = tasks.iconId,
                    contentDescription = "Selesai",
                    tint= Color.Green)
                Text(text = tasks.Description)
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(tasks.color))
            }
        }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    CobaUIAndroidTheme {
        HomeScreen()
    }
}