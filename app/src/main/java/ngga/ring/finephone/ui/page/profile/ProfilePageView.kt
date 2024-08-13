//package ngga.ring.schoolq.ui.view.profile
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberAsyncImagePainter
//import ngga.ring.data.local.user.UserModel
//import ngga.ring.finephone.ui.theme.font.FontNunito
//
//class ProfilePageView(val data: UserModel? = null) {
//
//    @Composable
//    fun profileView() {
//
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 16.dp)
//        ) {
//
//            Card(
//                modifier = Modifier
//                    .align(alignment = Alignment.Center)
//                    .fillMaxWidth(), shape = RoundedCornerShape(16.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .padding(top = 20.dp, start = 16.dp, end = 16.dp, bottom = 20.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//
//                    Image(
//                        painter = rememberAsyncImagePainter(model = "https://picsum.photos/300"),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(100.dp)
//                            .clip(RoundedCornerShape(100.dp))
//                            .background(MaterialTheme.colorScheme.primary),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Text(
//                        text = data?.name.toString(),
//                        style = TextStyle(
//                            fontFamily = FontNunito,
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 25.sp
//                        ),
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.primary,
//                        modifier = Modifier.padding(top = 16.dp)
//                    )
//
//                    Text(
//                        text = data?.nim.toString(),
//                        style = TextStyle(
//                            fontFamily = FontNunito,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 16.sp
//                        ),
//                        textAlign = TextAlign.Center,
//                        color = MaterialTheme.colorScheme.primary
//                    )
//                }
//            }
//        }
//
//    }
//
//
//}
//
//@Composable
//@Preview(showBackground = true)
//fun showpreview() {
//    val view = ProfilePageView()
//    view.profileView()
//}