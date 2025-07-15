package com.example.quotato.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotato.ui.theme.QuoteAppTheme
import com.example.quotato.ui.viewmodel.QuoteViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteAppTheme {
                val viewModel: QuoteViewModel = getViewModel()
                val quoteState by viewModel.quote.collectAsState()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        quoteState?.let {
                            Text(text = it.content)
                            Text(text = "— ${it.author}")
                        } ?: Text(text = "Загрузка...")
                        Button(onClick = { viewModel.loadQuote() }) {
                            Text(text = "Ещё цитата")
                        }
                    }
                }
            }
        }
    }
}
