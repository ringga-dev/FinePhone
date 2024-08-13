package ngga.ring.finephone.ui.view_models


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ngga.ring.finephone.ui.theme.AppPreferences
import ngga.ring.finephone.ui.theme.AppTheme
import ngga.ring.finephone.ui.theme.AppThemeColor


class DataStoreViewModels  : ViewModel() {
    var stateApp by mutableStateOf(MainState())
    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.ThemeChange -> {
                AppPreferences.setTheme(event.theme)
                AppPreferences.setThemeColor(event.themeColor)
                stateApp = stateApp.copy(theme = event.theme, themeColor = event.themeColor)
            }

//            is MainEvent.UserLogin -> {
//                AppPreferences.setUserLogin(event.dataUser)
//            }
        }
    }
}

sealed class MainEvent {
    data class ThemeChange(val theme: AppTheme, val themeColor: AppThemeColor): MainEvent()
//    data class UserLogin(val dataUser:UserModel):MainEvent()
}

data class MainState(
    val theme: AppTheme = AppPreferences.getTheme(),
    val themeColor: AppThemeColor = AppPreferences.getThemeColor(),
//    val userLogin: UserModel? = AppPreferences.getUserLogin(),
)