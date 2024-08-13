@file:OptIn(ExperimentalComposeUiApi::class)

package ngga.ring.finephone.ui.page.home.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ngga.ring.finephone.R
import ngga.ring.finephone.ui.page.menu.PopupMenuHome
import ngga.ring.finephone.ui.page.profile.HeadProfileView
import ngga.ring.finephone.ui.theme.font.FontNunito

enum class Page(val title: String, val content: String, val icon: Int) {
    HOME("Home", "Show only icon", R.drawable.ic_home),
    SEARCH("Search", "Show icon with label", R.drawable.ic_search),
    CHAT("Chat", "Show icon with label", R.drawable.ic_chat),
    ANNOUNCEMENT("Announcement", "Show icon with label", R.drawable.ic_campaign),
    TUGAS("Tugas", "Show icon with label", R.drawable.ic_taks),
    SETTINGS("Settings", "Show icon /Show the label only when selected", R.drawable.ic_settings)
}


@Composable
@Preview(showBackground = true)
fun showDrawer() {
    val pages = Page.values()
    modalNavigationDrawerView(
        header = { HeadProfileView() },
        pages = pages,
        onClickListener = {},
        onClickChatListener = {},
        onClickProfileListener = {},
    ) {

    }
}

@Composable
fun modalNavigationDrawerView(
    pages: Array<Page> = Page.values(),
    onClickListener: (Int) -> Unit,
    onClickChatListener: () -> Unit,
    onClickProfileListener: () -> Unit,
    header: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    var selectedItem by remember { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {

                ModalDrawerSheet {
                    if (header != null) {
                        header()
                        Spacer(Modifier.height(8.dp))
                    }
                    pages.forEachIndexed { index, item ->
                        when (item) {
                            Page.HOME, Page.CHAT, Page.SEARCH, Page.SETTINGS, Page.ANNOUNCEMENT, Page.TUGAS -> {
                                NavigationDrawerItem(
                                    modifier = Modifier.padding(
                                        start = 8.dp,
                                        end = 8.dp,
                                        top = 4.dp
                                    ),
                                    label = { Text(item.title) },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = item.icon),
                                            contentDescription = ""
                                        )
                                    },
                                    selected = selectedItem == index,
                                    onClick = {
                                        selectedItem = index
                                        onClickListener.invoke(index)
                                        scope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    }
                                )
                            }

                        }
                    }
                }
            }) {

            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = {
                    BottomAppBar(
//                        containerColor = MaterialTheme.colorScheme.inversePrimary,
                        contentPadding = PaddingValues(top = 0.dp, bottom = 8.dp),
                        modifier = Modifier
                            .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                            .height(70.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp)),
                        actions = {
                            IconButton(onClick = { onClickProfileListener.invoke() }) {
                                Icon(
                                    Icons.Filled.AccountCircle,
                                    contentDescription = "Profile user",
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(30.dp),
                                )
                            }
                            IconButton(onClick = { onClickChatListener.invoke() }) {
                                Icon(
                                    Icons.Filled.Info,
                                    contentDescription = "About",
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(30.dp),
                                )
                            }

                            val menu = PopupMenuHome()
                            menu.menuShare {

                            }
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                },
                                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                                modifier = Modifier.padding(0.dp),
                                shape = RoundedCornerShape(50.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description",
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(30.dp)
                                )
                            }
                        }
                    )
                },
            ) { innerPadding ->

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    Card(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
                        Text(
                            text = pages[selectedItem].title,
                            style = TextStyle(
                                fontFamily = FontNunito,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(vertical = 5.dp, horizontal = 16.dp)
                        )
                    }

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(8.dp)
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        content = content
                    )

                }
            }

        }


    }


}

data class DropDownMenus(
    var title: String? = null,
    val icon: Int? = null,
    val subMenu: List<SubDropDownMenus>? = null
)

data class SubDropDownMenus(
    var title: String? = null,
    val icon: Int? = null,
)