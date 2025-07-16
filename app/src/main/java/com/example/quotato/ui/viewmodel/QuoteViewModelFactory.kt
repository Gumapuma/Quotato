import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotato.data.network.QuoteApiService
import com.example.quotato.data.network.RetrofitClient
import com.example.quotato.data.repository.QuoteRepository
import com.example.quotato.ui.viewmodel.QuoteViewModel

class QuoteViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuoteViewModel(QuoteRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

