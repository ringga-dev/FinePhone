package ngga.ring.finephone.ui.theme

import io.paperdb.Paper

object AppPreferences {

    const val APP_THEME = "AppTheme"
    const val APP_THEME_COLOR = "AppThemeColor"

    fun setTheme(theme: AppTheme) {
        Paper.book().write(APP_THEME, theme)
    }

    fun getTheme(): AppTheme {
        return Paper.book().read(APP_THEME, AppTheme.Default)!!
    }

    fun setThemeColor(theme: AppThemeColor) {
        Paper.book().write(APP_THEME_COLOR, theme)
    }

    fun getThemeColor(): AppThemeColor {
        return Paper.book().read(APP_THEME_COLOR, AppThemeColor.Aqua)!!
    }

}