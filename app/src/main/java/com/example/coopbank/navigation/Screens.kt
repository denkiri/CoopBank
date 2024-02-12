package com.example.coopbank.navigation

import java.lang.IllegalArgumentException

enum class Screens {
    LoginScreen,
    HomeScreen;


    companion object {
         fun fromRoute(route: String?): Screens
          = when(route?.substringBefore("/")) {
             LoginScreen.name -> LoginScreen
             HomeScreen.name -> HomeScreen
             null -> HomeScreen
             else -> throw IllegalArgumentException("Route $route is not recognized")
          }
    }


}