package com.example.coopbank.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.coopbank.R
import com.example.coopbank.data.Resource
import com.example.coopbank.models.Profile
import com.example.coopbank.ui.screens.login.LoginViewModel
import com.example.coopbank.ui.theme.AppTheme
import com.example.coopbank.ui.theme.CoopBankTheme
import com.example.coopbank.ui.theme.green

@Composable
fun HomeScreen(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.getProfile()
    }

    val profileState by viewModel.profileResult.collectAsState()

    when (profileState) {
        is Resource.Loading -> {
            // Show loading indicator
            LinearProgressIndicator()

        }
        is Resource.Success -> {
            // Show login success message or handle accordingly
            Log.d("profileDataResponse", "ProfileData: ${profileState.data.toString()}")

            // navController.navigate("first_screen")
        }
        is Resource.Error -> {
        }

        else -> {}
    }
    CoopBankTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            profileState.data?.let { UILayout(it,navController) }
        }
    }}
    @Composable
    fun UILayout(profileData: Profile,navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.background), // Replace R.drawable.background_image with your actual image resource
                contentDescription = null,

                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding()
                    .imePadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopEnd // Aligning content (AsyncImage) to the end (right) of the Box
                ) {
                    Row(
                        modifier = Modifier.padding(top = 29.dp) // Adding padding of 14.dp to the top of the Row
                    ) {
                        Box(
                            modifier = Modifier.clickable {
                                navController.navigate("login")

                            }
                        ) {
                        AsyncImage(
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(data = R.drawable.logout)
                                .crossfade(enable = true)
                                .scale(Scale.FILL)
                                .build(),
                            contentDescription = stringResource(id = R.string.login_heading_text)

                        )
                    }
                        Spacer(modifier = Modifier.width(14.dp)) // Adding a spacer to create padding
                        Text(
                            text = stringResource(id = R.string.log_out),
                            color = Color.White,
                            modifier = Modifier.padding(end = 26.dp)
                        )
                    }
                }


                Column(
                    modifier = Modifier
                        .padding(horizontal = AppTheme.dimens.paddingLarge)
                        .padding(top = 128.dp)
                        .padding(bottom = AppTheme.dimens.paddingExtraLarge)
                ) {


                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(128.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(data = R.drawable.logo)
                                .crossfade(enable = true)
                                .scale(Scale.FILL)
                                .build(),
                            contentDescription = stringResource(id = R.string.login_heading_text)
                        )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Welcome",
                            modifier = Modifier.padding(5.dp),
                            fontSize = 16.sp,
                            color = Color.White,
                        )
                        Text(
                            text = profileData.username,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(5.dp),
                            color = green,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "to the new Co-op Bank App",
                            modifier = Modifier.padding(5.dp),
                            fontSize = 16.sp,
                            color = Color.White,
                        )

                    }
                }
            }
        }

    }}
