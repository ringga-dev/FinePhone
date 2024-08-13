package ngga.ring.core.utils

import androidx.compose.ui.text.SpanStyle
import timber.log.Timber

enum class StringStyle{
    BOLD, ITALIC, NORMAL
}

data class StringFormat(val style: StringStyle, val data:String)

fun motivasiStingFormat(data:String):List<StringFormat>{
    val hasil = mutableListOf<StringFormat>()

    val bagian = data.trim().split("\n\n").filterNot { it.isBlank() }

    for (bagianTeks in bagian) {
        when {
            bagianTeks.startsWith("**") && bagianTeks.endsWith("**") -> {
                // Teks bold tanpa tanda **
                val data = bagianTeks.removeSurrounding("**").trim()
                hasil.add(StringFormat(StringStyle.BOLD, data))
            }
            bagianTeks.startsWith("*") -> {
                // Teks italic tanpa tanda *
                val poin = bagianTeks.split("\n").mapNotNull {
                    it.trim().removePrefix("*").trim().takeIf { it.isNotEmpty() }?.let { text ->
                        StringFormat(StringStyle.ITALIC, text.capitalize())
                    }
                }
                hasil.addAll(poin)
            }
            else -> {
                // Teks normal
                hasil.add(StringFormat(StringStyle.NORMAL, bagianTeks.trim()))
            }
        }
    }

    return hasil
}


fun pecahMotivasi(teks: String): Map<String, List<String>> {
    val hasil = mutableMapOf<String, MutableList<String>>()
    val bagian = teks.trim().split("\n\n").filterNot { it.isBlank() }

    var judulSaatIni: String? = null

    for (bagianTeks in bagian) {
        if (bagianTeks.startsWith("**") && bagianTeks.endsWith("**")) {
            // Menghilangkan tanda bintang dan spasi ekstra
            val judul = bagianTeks.removeSurrounding("**").trim()
            judulSaatIni = judul
            hasil[judul] = mutableListOf()
        } else {
            val poin = bagianTeks.split("\n").mapNotNull { it.trim().removePrefix("*").trim().takeIf { it.isNotEmpty() }?.capitalize() }
            judulSaatIni?.let { hasil[it]?.addAll(poin) }
        }
    }

    return hasil
}

fun ubahFormatTeks(teks: String): String {
    val regex = Regex("""\*\*(.*?)\*\*""") // Regex untuk menangkap teks di antara "**"
//    val teksDiformat = teks.replace(regex) { matchResult ->
//        "<b>${matchResult.groupValues[1]}</b>" // Substitusi teks yang cocok dengan format yang diinginkan
//    }
//    return teksDiformat.replace("\n\n", "<br><br>") // Mengganti baris baru menjadi tag <br>

    val hasil = mutableListOf<StringFormat>()
    val textspliter =teks.replace("**", "\n").replace("*", "● ").replace("\n\n", "\n").split("\n")

    Timber.e("Hasil : $textspliter")

    return teks.replace("**", "\n").replace("*", "● ").replace("\n\n", "\n")
}