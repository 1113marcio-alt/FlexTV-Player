package com.flextv.player.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flextv.player.model.Channel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // TODO: Injetar um repositório real
    // private val repository: PlaylistRepository

    private val _channelCategories = MutableLiveData<Map<String, List<Channel>>>()
    val channelCategories: LiveData<Map<String, List<Channel>>> = _channelCategories

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun loadChannels(url: String) {
        viewModelScope.launch {
            try {
                // Lógica de simulação. Substituir pela chamada ao repositório.
                val mockChannels = listOf(
                    Channel(id = "1", name = "Canal Notícias", group = "Notícias", logoUrl = "", url = ""),
                    Channel(id = "2", name = "Canal Esportes 1", group = "Esportes", logoUrl = "", url = ""),
                    Channel(id = "3", name = "Canal Filmes HD", group = "Filmes", logoUrl = "", url = ""),
                    Channel(id = "4", name = "Canal Esportes 2", group = "Esportes", logoUrl = "", url = "")
                )
                _channelCategories.value = mockChannels.groupBy { it.group }

            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Erro desconhecido ao carregar canais."
            }
        }
    }
}
