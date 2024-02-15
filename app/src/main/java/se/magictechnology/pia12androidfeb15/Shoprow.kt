package se.magictechnology.pia12androidfeb15

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Shoprow(shop : Shopthing, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .background(Color.White)
        .fillMaxWidth()
        .height(60.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(shop.shoptitle, modifier = Modifier
            .background(Color.Cyan)
            .padding(start = 20.dp)
            , fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1F))

        Text(shop.shopamount.toString(), modifier = Modifier
            .background(Color.Cyan)
            .padding(end = 20.dp)
            , fontSize = 20.sp
        )

        if(shop.isbought) {
            Text("X", modifier = Modifier.width(50.dp))
        } else {
            Spacer(modifier = Modifier.width(50.dp))
        }
    }
}


@Preview
@Composable
fun ShoprowPreview() {
    Shoprow(Shopthing("Apelsin", 7))
}

@Preview
@Composable
fun ShoprowPreview2() {
    Shoprow(Shopthing("Banan", 7, isbought = true))
}