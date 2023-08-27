package com.example.currencyconversionapp.screens.favourite
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.currencyconversionapp.R

/**
 * CREATES A DIALOGUE THAT CONTAINS OR RETURNS FAVOURITES LIST
 *
 *
 * */

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier.fillMaxSize().background(Color.Transparent), onClick : () -> Unit) {

    AlertDialog(
        modifier = Modifier.height(670.dp),
        containerColor = Color.White,
        onDismissRequest = { onClick.invoke() }, confirmButton = {
        Column(
            modifier
                .wrapContentSize(Alignment.Center)
                .background(Color.White),
        ) {

            FavouriteScreen(onClick)


        }
    }, )

        }




@SuppressLint("UnrememberedMutableState")
@Preview(name = "Custom Dialog")
@Composable
fun MyDialogUIPreview() {
    //CustomDialogUI()
}