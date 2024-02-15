package se.magictechnology.pia12androidfeb15

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.magictechnology.pia12androidfeb15.ui.theme.Pia12androidfeb15Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia12androidfeb15Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Shopping()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Shopping() {

    //var shopitems = mutableListOf<String>("Apelsin", "Banan")

    var addname by remember {
        mutableStateOf("")
    }
    var addamount by remember {
        mutableStateOf("")
    }

    var shopitems = remember {
        mutableStateListOf<Shopthing>()
    }


    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .height(100.dp)
            .background(Color.Red)) {

            TextField(value = addname, onValueChange = {
                addname = it
            }, label = { Text("What buy") }, modifier = Modifier
                .weight(1F)
                .padding(horizontal = 10.dp))

            TextField(value = addamount, onValueChange = {
                addamount = it
            }, label = { Text("Amount") }, modifier = Modifier
                .width(150.dp)
                .padding(horizontal = 10.dp))

            Button(onClick = {
                addamount.toIntOrNull()?.let { amountnumber ->
                    var tempshop = Shopthing(addname, amountnumber)
                    shopitems.add(tempshop)

                    addname = ""
                    addamount = ""
                }
            }) {
                Text("Add")
            }
        }

        /*
                LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {

         */

        LazyColumn {
            itemsIndexed(shopitems) { index, shopitem ->
                Shoprow(shopitem, modifier = Modifier.clickable {
                    Log.i("PIA12DEBUG", "CLICK ROW " + shopitem.shoptitle)
                    /*
                    shopitem.isbought = true
                    shopitem.shoptitle = "X"

                    shopitems[index] = shopitem.copy()
                    */
                    /*
                    var xshop = Shopthing("A", 1, false)
                    shopitems.add(xshop)
                    shopitems.removeLast()
                     */
                    shopitems.removeAt(index)

                })
            }


        }


    }


}

/*
        shopitems.forEach { shopitem ->
                Text(shopitem)
            }
         */

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pia12androidfeb15Theme {
        Shopping()
    }
}