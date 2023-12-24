@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.tabview.UiFqa
import com.example.myapplication.tabview.UiHome
import com.example.myapplication.tabview.UiProfile
import com.example.myapplication.tabview.UiSquare
import com.example.myapplication.tabview.UiSystem
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
internal fun TopBar(title: String, onProfileClick: () -> Unit) {//标题,左侧导航按钮点击事件
    CenterAlignedTopAppBar(title = { Text(text = title) }, navigationIcon = {
        IconButton(onClick = onProfileClick) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "返回")
        }
    })
}

@Composable
internal fun BottomBar(
    items: Array<BottomBarItem>, //item 集合
    selectedIndex: Int = 0, // 当前选中 item 的索引
    onBottomItemClick: (Int) -> Unit
) // item 点击事件
{
    NavigationBar {
        items.forEachIndexed { index, bottomBarItem ->
            NavigationBarItem(
                icon = bottomBarItem.icon,
                selected = index == selectedIndex,
                onClick = { onBottomItemClick(index) },
                colors = NavigationBarItemDefaults.colors()// 设置颜色
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WanApp() {
    //当前选中的 BottomBarItem 索引

    //Scaffold 根据选中的状态显示不同的内容
    var selectedItemIndex by remember { mutableStateOf(0) }

    val bottomBarItems = remember { BottomBarItem.values() }

    val navController = rememberNavController()

    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(topBar = {
                TopBar(title = bottomBarItems[selectedItemIndex].label) {
                    //todo 跳转到我的页面
                    navController.navigateUp()
                }
            }, bottomBar = {
                BottomBar(bottomBarItems, selectedItemIndex) {
                    //点击底部 item 时更新 selectedItemIndex
                    selectedItemIndex = it
                }
            }, containerColor = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    //根据 selectedItemIndex 在 content 中显示不同的页面
                    when (selectedItemIndex) {
                        0 -> UiHome()
                        1 -> UiFqa()
                        2 -> UiProfile()
                        3 -> UiSquare()
                        else -> UiSystem()
                    }
                }
            }
        }
    }
}