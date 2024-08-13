package ngga.ring.finephone.ui.page.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ngga.ring.finephone.ui.page.home.navigation.DropDownMenus
import ngga.ring.finephone.R
import ngga.ring.finephone.ui.page.home.navigation.SubDropDownMenus
import ngga.ring.finephone.ui.theme.font.FontNunito

class PopupMenuHome {
    val items = DropDownMenus(
        "Share",
        subMenu = listOf(
            SubDropDownMenus(
                "whatsapp",
                R.drawable.ic_m_whatsapp
            ),
            SubDropDownMenus(
                "facebook",
                R.drawable.ic_m_facebook
            ),
            SubDropDownMenus(
                "facebook lite",
                R.drawable.ic_m_facebook_lite
            ),
            SubDropDownMenus(
                "save image",
                R.drawable.ic_m_save_image
            ),
            SubDropDownMenus(
                "instagram",
                R.drawable.ic_m_instagram
            ),
            SubDropDownMenus(
                "more",
                R.drawable.ic_m_more
            ),
        )
    )


    @Composable
    fun menuShare(
        onClickAction: (SubDropDownMenus) -> Unit
    ) {
        var expanded by remember { mutableStateOf(false) }

        Box {
            IconButton(
                onClick = {
                    expanded = true
                }) {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = "Share",
                    modifier = Modifier
                        .padding(0.dp)
                        .size(30.dp),
                )
            }
            MaterialTheme(
                colorScheme = MaterialTheme.colorScheme,
                shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp))) {
                DropdownMenu(
                    modifier = Modifier
                        .padding(16.dp),
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    Text(
                        text = items.title.toString(),
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = MaterialTheme.colorScheme.primary,
                        style = TextStyle(
                            fontFamily = FontNunito,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    items.subMenu?.forEach {
                        DropdownMenuItem(
                            text = {
                                Row {
                                    if (it.icon != null) {
                                        Image(
                                            painterResource(it.icon),
                                            contentDescription = it.title,
                                            modifier = Modifier
                                                .padding(end = 8.dp)
                                                .size(30.dp),
                                        )
                                    }

                                    Text(
                                        it.title.toString(),
                                        color = MaterialTheme.colorScheme.primary,
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontNunito
                                        )
                                    )
                                }

                            },
                            onClick = {
                                expanded = false
                                onClickAction.invoke(it)
                            }
                        )
                    }

                }
            }

        }
    }

}