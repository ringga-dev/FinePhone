package ngga.ring.finephone.ui.page.search

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import ngga.ring.core.utils.saveImageToExternalStorage
import ngga.ring.core.utils.uriToBitmap
import ngga.ring.finephone.ui.theme.font.FontNunito
import ngga.ring.finephone.ui.view_models.chat.ChatViewModel
import ngga.ring.finephone.ui.view_models.chat.GeminiViewModel
import ngga.ring.finephone.ui.view_models.chat.UiState
import org.osmdroid.views.CustomZoomButtonsController.Visibility

class SearchScreen {
    @Composable
    fun view(
        geminiViewModel: GeminiViewModel = viewModel()
    ) {
        var result by rememberSaveable { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            val context = LocalContext.current

            var imageUri by remember { mutableStateOf<Uri?>(null) }
            val launcherGallery = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()
            ) { uri: Uri? ->
                geminiViewModel.sendRoastingPrompt(context.uriToBitmap(uri!!)!!)
                imageUri = uri
            }
            var hasCameraPermission by remember { mutableStateOf(false) }


            val cameraPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                hasCameraPermission = isGranted
            }


            LaunchedEffect(Unit) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CAMERA
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                } else {
                    hasCameraPermission = true
                }
            }


            val launcherCamera = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.TakePicturePreview()
            ) { bitmap: Bitmap? ->
                if (bitmap != null) {
                    geminiViewModel.sendRoastingPrompt(bitmap)
                    val uri = context.saveImageToExternalStorage(bitmap)
                    imageUri = uri
                }
            }

            val uiState by geminiViewModel.uiState.collectAsState()
            val scrollState = rememberScrollState()
            Card(
                modifier = Modifier
                    .fillMaxWidth(), shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {


                    Text(
                        text = "Pilih gambar yang ingin di roasting!",
                        style = TextStyle(
                            fontFamily = FontNunito,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    SelecImagePos(
                        onGalery = {
                            launcherGallery.launch("image/*")
                        },
                        onCamera = {
                            if (hasCameraPermission) {
                                launcherCamera.launch()
                            } else {
                                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        }
                    )
                    if (imageUri != null) {
                        Image(
                            painter = if (imageUri != null) rememberImagePainter(data = imageUri) else rememberAsyncImagePainter(
                                model = "https://picsum.photos/300"
                            ),
                            contentDescription = null,
                            modifier = Modifier

                                .size(300.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.primary),
                            contentScale = ContentScale.Crop
                        )
                    }

                    if (uiState is UiState.Loading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp))
                    } else if (uiState is UiState.Initial) {
                        Text(
                            text = "wait....",
                            style = TextStyle(
                                fontFamily = FontNunito,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    } else {
                        var textColor = MaterialTheme.colorScheme.onSurface
                        if (uiState is UiState.Error) {
                            textColor = MaterialTheme.colorScheme.error
                            result = (uiState as UiState.Error).errorMessage
                        } else if (uiState is UiState.Success) {
                            textColor = MaterialTheme.colorScheme.onSurface
                            result = (uiState as UiState.Success).outputText
                        }


                        val annotatedString = buildAnnotatedString {
                            // Adding different styles based on markdown
                            // For simplicity, we handle basic bold and italic here
                            val lines = result.split("\n")
                            lines.forEach { line ->
                                when {
                                    line.startsWith("## ") -> {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append(line.removePrefix("## ").trim())
                                            append("\n\n")
                                        }
                                    }
                                    line.startsWith("#") -> {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append(line.removePrefix("#").trim())
                                            append("")
                                        }
                                    }
                                    line.startsWith("**") && line.endsWith("**") -> {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append(line.removePrefix("**").removeSuffix("**"))
                                            append("\n")
                                        }
                                    }
                                    line.contains("*") -> {
                                        val parts = line.split("*")
                                        for (i in parts.indices) {
                                            if (i % 2 == 1) {
                                                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                                                    append(parts[i])
                                                }
                                            } else {
                                                append(parts[i])
                                            }
                                        }
                                        append("\n")
                                    }
                                    else -> {
                                        append(line)
                                        append("\n")
                                    }
                                }
                            }
                        }

                        Text(
                            text = annotatedString,
                            textAlign = TextAlign.Start,
                            color = textColor,
                            style = TextStyle(fontSize = 16.sp, fontFamily = FontNunito),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(16.dp)
                                .fillMaxSize()
                        )
                    }

                }
            }
        }


    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SelecImagePos(
        onGalery: () -> Unit,
        onCamera: () -> Unit
    ) {
        var showBottomSheet by remember { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = false,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { showBottomSheet = true }
            ) {
                Text("Select Image")
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                    sheetState = sheetState,
                    onDismissRequest = { showBottomSheet = false }
                ) {
                    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                showBottomSheet = false
                                onGalery.invoke()
                            }) {

                            Text("Galery Image")
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                showBottomSheet = false
                                onCamera.invoke()
                            }) {
                            Text("Camera Image")
                        }
                    }
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun showpreview() {
    val view = SearchScreen()
    view.view()
}