package com.example.myapplication.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

enum class BottomBarItem(
    val label: String,
    val icon: @Composable () -> Unit,
) {
    Home(
        "首页",
        {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = ""
            )
        },
    ),

    // ...... 问答 、项目 、广场 、体系
    Fqa(
        "问答",
        {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = ""
            )
        },
    ),
    Profile(
        "项目",
        {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = ""
            )
        },
    ),
    Square(
        "广场",
        {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = ""
            )
        },
    ),
    System(
        "体系",
        {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = ""
            )
        },
    ),

}