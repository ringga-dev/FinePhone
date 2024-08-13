package ngga.ring.finephone.ui.activity.chat

import androidx.compose.runtime.Composable
import ngga.ring.finephone.ui.base.BaseActivity
import ngga.ring.finephone.ui.page.chat.ChatScreenView

class ChatActivity : BaseActivity() {

    @Composable
    override fun setupViews(){
        val view = ChatScreenView()
        view.View()
    }
}
