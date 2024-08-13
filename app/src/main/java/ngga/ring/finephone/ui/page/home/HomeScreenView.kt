package ngga.ring.finephone.ui.page.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ngga.ring.core.utils.ubahFormatTeks
import ngga.ring.finephone.SummarizeUiState
import ngga.ring.finephone.ui.page.launcher.LoadingScreenView
import ngga.ring.finephone.ui.page.maps.OsmMaps
import ngga.ring.finephone.ui.theme.font.FontFine
import ngga.ring.finephone.ui.theme.font.FontNunito
import ngga.ring.finephone.ui.view_models.SummarizeViewModel
import ngga.ring.finephone.ui.view_models.cinnabar.CinnabarViewModels
import ngga.ring.finephone.ui.view_models.cuaca.CuacaViewModels
import ngga.ring.remote.models.cuaca.WilayahRespon
import ngga.ring.remote.respon_handler.Resource

class HomeScreenView {

    @Composable
    fun View(
        viewModel: SummarizeViewModel = viewModel(),
    ) {
        val summarizeUiState by viewModel.uiState.collectAsState()

        var dataLocation by remember { mutableStateOf<WilayahRespon?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                    text = buildAnnotatedString {
                        append("Welcome to ")
                        pushStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                fontFamily = FontNunito
                            )
                        )
                        append("FinePhone")
                    },
                    style = FontFine().textStyleLight18
                )
            }

            SummarizeScreen(summarizeUiState, onSummarizeClicked = {
                viewModel.summarize("motivasi hari ini? buat dalam 100 kata")
            })

//            TauKahAnda()

            Cuaca(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) { data->

                dataLocation = data
            }

            Card(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(8.dp),
                onClick = {},
                border = BorderStroke(1.dp, Color.Black),
                shape = MaterialTheme.shapes.medium
            ) {
                OsmMaps().View(
                    modifier = Modifier.fillMaxSize(),
                    dataLocation
                )
            }


        }


    }

    @Composable
    fun SummarizeScreen(
        uiState: SummarizeUiState = SummarizeUiState.Initial,
        onSummarizeClicked: () -> Unit = {}
    ) {
        var showRespon by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(all = 8.dp)

        ) {
            if (!showRespon) {
                Row {
                    Button(
                        onClick = {
                            showRespon = true
                            onSummarizeClicked.invoke()
                        },

                        modifier = Modifier
                            .weight(2f)
                            .padding(all = 4.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text("Motivasi Hari Ini!")
                    }
                }
            } else {
                when (uiState) {
                    SummarizeUiState.Initial -> {
                        showRespon = false
                    }

                    SummarizeUiState.Loading -> {
                        showRespon = true
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(all = 8.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            LoadingScreenView().LoadingScreen()
                        }
                    }

                    is SummarizeUiState.Success -> {
                        showRespon = true

                        Row(modifier = Modifier.padding(all = 8.dp)) {
                            Card(
                                onClick = { /*TODO*/ },
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
                            ) {
                                Text(
                                    text = ubahFormatTeks(uiState.outputText),
                                    style = FontFine().textStyleSemiBold16,
                                    textAlign = TextAlign.Justify,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }

                    }

                    is SummarizeUiState.Error -> {
                        showRespon = false
                        Text(
                            text = uiState.errorMessage,
                            color = Color.Red,
                            modifier = Modifier.padding(all = 8.dp)
                        )
                    }
                }
            }
        }
    }


    @Composable
    fun TauKahAnda(
        viewModel: CinnabarViewModels = viewModel()
    ) {

        val userState by viewModel.tawiki.collectAsState()


        Text(
            text = "Taukah anda!",
            modifier = Modifier.padding(8.dp),
            style = FontFine().textStyleBold20
        )


        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {

            when (val resource = userState) {
                is Resource.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {
                        LoadingScreenView().LoadingScreen()
                    }
                }

                is Resource.Success -> {
                    resource.data.data?.info?.forEach {
                        Card(
                            onClick = {},
                            modifier = Modifier
                                .padding(top = 8.dp, start = 8.dp)
                                .width(300.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                        ) {
                            Text(
                                text = it.tahukahAnda.toString().replace("\"...", "😒"),
                                modifier = Modifier.padding(8.dp),
                                style = FontFine().textStyleSemiBold16
                            )
                        }
                    }

                }

                is Resource.Error -> {
                    Text(text = "Error: ${resource.message}")
                }

                null -> TODO()
            }

        }
    }


    @Composable
    fun Cuaca(
        modifier: Modifier,
        viewModel: CuacaViewModels = viewModel(),
        onCuacaClicked: (WilayahRespon) -> Unit
    ) {
        val wilayahState by viewModel.wilayah.collectAsState()
        val cuacaState by viewModel.cuaca.collectAsState()

        when (val resource = wilayahState) {
            is Resource.Loading -> LoadingScreenView()
            is Resource.Success -> {
                val itemsData = resource.data
                Row(modifier = modifier) {
                    itemsData.forEach {
                        Card(
                            onClick = {
                                onCuacaClicked(
                                    it
                                )
                            },
                            modifier = Modifier.padding(8.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                        ) {
                            Column(
                                modifier = Modifier.padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = it.propinsi.toString(),
                                    style = FontFine().textStyleSemiBold16
                                )
                                Text(
                                    text = it.kota.toString(),
                                    style = FontFine().textStyleSemiBold16
                                )
                                Text(
                                    text = it.kecamatan.toString(),
                                    style = FontFine().textStyleSemiBold16
                                )
                            }
                        }
                    }
                }

            }


            is Resource.Error -> {
                Text(text = "Error: ${resource.message}")
            }

            null -> TODO()
        }

    }
}
