package ngga.ring.finephone.ui.activity.home


import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ngga.ring.core.utils.motivasiStingFormat
import ngga.ring.core.utils.pecahMotivasi
import ngga.ring.finephone.ui.activity.chat.ChatActivity
import ngga.ring.finephone.ui.base.BaseActivity
import ngga.ring.finephone.ui.page.chat.ChatScreenView
import ngga.ring.finephone.ui.page.home.HomeScreenView
import ngga.ring.finephone.ui.page.home.navigation.Page
import ngga.ring.finephone.ui.page.home.SettingView
import ngga.ring.finephone.ui.page.home.navigation.modalNavigationDrawerView
import ngga.ring.finephone.ui.page.profile.HeadProfileView
import ngga.ring.finephone.ui.page.search.SearchScreen
import ngga.ring.finephone.ui.view_models.MainEvent
import timber.log.Timber

class HomeActivity : BaseActivity() {


    @Composable
    override fun setupViews() {
        var selectedItem by remember { mutableStateOf(0) }
        var homeLevelShow by remember { mutableStateOf(false) }
        val pages = Page.values()
        modalNavigationDrawerView(
            pages = pages,
            header = {
                HeadProfileView(
                    name = "ringga",
                    description = "Android Dev"
                )
            }, onClickListener = {
                selectedItem = it
            }, onClickChatListener = {
                startActivity(Intent(this, ChatActivity::class.java))
            }, onClickProfileListener = {
//                startActivity(Intent(this, ProfileActivity::class.java))
            }) {
            when (pages[selectedItem]) {
                Page.HOME -> {
                    HomeScreenView().View()
                }

                Page.SEARCH -> {
                    SearchScreen().view()
                }

                Page.ANNOUNCEMENT -> {
//                    AnnouncementScreen().view(AnnouncementScreen().dummyAnnouncements.sortedBy { it.read }.toList())
                }

                Page.CHAT ->{
                    ChatScreenView().View()
                }

                Page.TUGAS -> {
//                    TugasScreen().view()
                }

                Page.SETTINGS -> {
                    SettingView().view(
                        appTheme = themeViewModels.stateApp.theme,
                        appThemeColor = themeViewModels.stateApp.themeColor
                    ) { theme, themeColor ->
                        themeViewModels.onEvent(MainEvent.ThemeChange(theme, themeColor))
                    }
                }
            }
        }
    }

}
