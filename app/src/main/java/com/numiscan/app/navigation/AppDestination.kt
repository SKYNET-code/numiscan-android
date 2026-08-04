package com.numiscan.app.navigation

sealed class AppDestination(

    val route:String

){

    data object Home:AppDestination("home")

    data object Results:AppDestination("results")

}
