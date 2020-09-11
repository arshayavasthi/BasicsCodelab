package com.example.basicscodelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.basicscodelab.ui.BasicsCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val screen = state<@Composable () -> Unit> { { MyScreenContent() }}
    val currentScreen = remember { mutableStateOf("home") }

    Scaffold(
        bodyContent = {
            screen.value()
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(asset = Icons.Default.Home) },
                    label = { Text("Home") },
                    selected = currentScreen.value == "home",
                    onSelect = {
                        currentScreen.value = "home"
                        screen.value = {
                            MyScreenContent()
                        }
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(asset = Icons.Default.Search) },
                    label = { Text("Search") },
                    selected = currentScreen.value == "search",
                    onSelect = {
                        currentScreen.value = "search"
                        screen.value = {
                            SearchScreen()
                        }
                    }
                )
            }
        }
    )
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    BasicsCodelabTheme {
        Surface(color = Color.Red){
            content()
        }
}}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(30.dp))
}

@Composable
fun MyScreenContent() {
    Column(modifier = Modifier.fillMaxHeight()){
    Column(modifier = Modifier.weight(1f)) {
        Greeting("Android")
        Divider(color = Color.Black)
        Greeting("First Android App using Compose and Kotlin")
        Divider(color = Color.Black)
        Greeting("Made By Me :)")
        Divider(color = Color.Black)
        Counter()
    }
}}
@Composable
fun Counter() {

    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("You have clicked ${count.value} times")
    }
}
@Composable
fun SearchScreen(){
    Surface( color = Color.Yellow) {
        Text(text = "Coming Soon :)")
    }

}



