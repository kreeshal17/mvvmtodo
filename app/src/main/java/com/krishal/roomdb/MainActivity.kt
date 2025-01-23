package com.krishal.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import com.krishal.roomdb.ui.UserScreen
import com.krishal.roomdb.ui.theme.RoomdbTheme

class MainActivity :ComponentActivity() {

    // Initialize ViewModel
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view for the MainActivity
        setContent {
            RoomdbTheme {
                // Pass the ViewModel to the UserScreen composable
                UserScreen(userViewModel = userViewModel)
            }
        }
    }
}
