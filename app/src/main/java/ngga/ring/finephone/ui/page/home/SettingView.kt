package ngga.ring.finephone.ui.page.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import ngga.ring.finephone.ui.theme.AppTheme
import ngga.ring.finephone.ui.theme.AppThemeColor
import ngga.ring.finephone.ui.theme.font.FontNunito

class SettingView {

    @Composable
    fun view(
        appTheme: AppTheme = AppTheme.Default,
        appThemeColor: AppThemeColor = AppThemeColor.Blue,
        onActionSave: (theme: AppTheme, themeColor: AppThemeColor) -> Unit
    ) {
        var selectedTextTheme by remember { mutableStateOf(appTheme.name) }
        var selectedTextThemeColor by remember { mutableStateOf(appThemeColor.name) }

        Column(modifier = Modifier.padding(16.dp)) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                Box {

                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = AppTheme.values()


                    var textfieldSize by remember { mutableStateOf(Size.Zero) }

                    val icon = if (expanded)
                        Icons.Filled.KeyboardArrowUp //it requires androidx.compose.material:material-icons-extended
                    else
                        Icons.Filled.KeyboardArrowDown


                    OutlinedTextField(
                        value = selectedTextTheme,
                        enabled = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            disabledTextColor = MaterialTheme.colorScheme.primary,
                            disabledLabelColor = MaterialTheme.colorScheme.primary,
                            disabledBorderColor = MaterialTheme.colorScheme.primary
                        ),
                        readOnly = true,
                        onValueChange = { selectedTextTheme = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            }
                            .clickable { expanded = !expanded },
                        label = {
                            Text(
                                "Theme", style = TextStyle(
                                    fontFamily = FontNunito,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        },
                        trailingIcon = {
                            Icon(
                                icon, "contentDescription",
                                modifier = Modifier.clickable { expanded = !expanded },
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                    )
                    MaterialTheme(
                        colorScheme = MaterialTheme.colorScheme,
                        shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp))
                    ) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })

                        ) {
                            suggestions.forEach { label ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = label.name, style = TextStyle(
                                                fontFamily = FontNunito,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                    },
                                    onClick = {
                                        selectedTextTheme = label.name
                                        expanded = false
                                    })
                            }
                        }
                    }
                }
                Box(modifier = Modifier.padding(top = 16.dp)) {

                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = AppThemeColor.values()

                    var textfieldSize by remember { mutableStateOf(Size.Zero) }

                    val icon = if (expanded)
                        Icons.Filled.KeyboardArrowUp //it requires androidx.compose.material:material-icons-extended
                    else
                        Icons.Filled.KeyboardArrowDown


                    OutlinedTextField(
                        value = selectedTextThemeColor,
                        enabled = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            disabledTextColor = MaterialTheme.colorScheme.primary,
                            disabledLabelColor = MaterialTheme.colorScheme.primary,
                            disabledBorderColor = MaterialTheme.colorScheme.primary
                        ),
                        readOnly = true,
                        onValueChange = { selectedTextThemeColor = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            }
                            .clickable { expanded = !expanded },
                        label = {
                            Text(
                                "Theme Color", style = TextStyle(
                                    fontFamily = FontNunito,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        },
                        trailingIcon = {
                            Icon(
                                icon, "contentDescription",
                                modifier = Modifier.clickable { expanded = !expanded },
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                    )
                    MaterialTheme(
                        colorScheme = MaterialTheme.colorScheme,
                        shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp))
                    ) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .height(200.dp)
                                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                        ) {
                            suggestions.forEach { label ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = label.name, style = TextStyle(
                                                fontFamily = FontNunito,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                    },
                                    onClick = {
                                        selectedTextThemeColor = label.name
                                        expanded = false
                                    })
                            }
                        }
                    }
                }
            }


            Button(
                onClick = {
                    onActionSave.invoke(
                        AppTheme.values().find { it.name == selectedTextTheme } ?: AppTheme.Default,
                        AppThemeColor.values().find { it.name == selectedTextThemeColor }
                            ?: AppThemeColor.Blue
                    )
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Save", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontNunito, fontSize = 20.sp
                    )
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun show() {
    SettingView().view() { theme, themeColor ->

    }
}