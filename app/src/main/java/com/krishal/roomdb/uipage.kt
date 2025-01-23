package com.krishal.roomdb.ui

import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.krishal.roomdb.User
import com.krishal.roomdb.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(userViewModel: UserViewModel) {
val allUsers by userViewModel.allUsers.observeAsState(emptyList())
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var status by remember {
        mutableStateOf(false)
    }


    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text="Fill the form")

                }




            )
        }
        ,

                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        IconButton(onClick = { status=!status}) {
                            Icon(imageVector =Icons.Default.Add, contentDescription = "false")
                        }

                    }
                }



    ) {

        paddingValues ->

        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            if (status) {
                OutlinedTextField(value = name, onValueChange = { name = it })
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = email, onValueChange = { email = it })
                Spacer(modifier = Modifier.height(16.dp))
                val context= LocalContext.current
                Button(onClick = {
                    if (email.isNotEmpty() && name.isNotEmpty()) {
                        userViewModel.insertUser(User(name = name, email = email))
                        name = ""
                        email = ""
                        Toast.makeText(context,"saved sucessfully",Toast.LENGTH_SHORT).show()
                    }
                })
                {
                    Text(text = "Save")

                }
            }


            LazyColumn {
                items(allUsers) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween, // Adjust to space out content
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = user.name, style = MaterialTheme.typography.bodyLarge)
                                Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
                            }

                            IconButton(onClick = { userViewModel.deleteUser(user) }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete User",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

