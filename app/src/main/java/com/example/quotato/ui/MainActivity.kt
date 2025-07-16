package com.example.quotato.ui

import QuoteViewModelFactory
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
import androidx.lifecycle.ViewModelProvider
import com.example.quotato.ui.theme.QuoteAppTheme
import com.example.quotato.ui.viewmodel.QuoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this, QuoteViewModelFactory())[QuoteViewModel::class.java]

        setContent {
            QuoteAppTheme {
                val quoteState by viewModel.quote.collectAsState()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
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

