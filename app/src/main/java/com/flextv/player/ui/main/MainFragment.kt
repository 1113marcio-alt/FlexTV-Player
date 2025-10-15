package com.flextv.player.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.ViewModelProvider
import com.flextv.player.model.Channel

/**
 * Fragmento principal que exibe as categorias e canais.
 */
class MainFragment : BrowseSupportFragment() {

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupUIElements()
        setupEventListeners()
        observeViewModel()

        // TODO: Iniciar o carregamento da playlist (ex: a partir de uma URL salva)
        viewModel.loadChannels("URL_DA_SUA_PLAYLIST_M3U_AQUI")
    }

    private fun setupUIElements() {
        title = "FlexTV Player"
        // headersState = HEADERS_ENABLED
        // brandColor = resources.getColor(R.color.fastlane_background)
    }

    private fun setupEventListeners() {
        onItemViewClickedListener = OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            if (item is Channel) {
                Toast.makeText(activity, "Clicou em: ${item.name}", Toast.LENGTH_SHORT).show()
                // TODO: Iniciar PlayerActivity com a URL do canal
                // Intent(activity, PlayerActivity::class.java).apply {
                //     putExtra("channel_url", item.url)
                //     startActivity(this)
                // }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.channelCategories.observe(viewLifecycleOwner) { categories ->
            val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
            val cardPresenter = CardPresenter()

            categories.forEach { (categoryName, channels) ->
                val listRowAdapter = ArrayObjectAdapter(cardPresenter)
                channels.forEach { channel ->
                    listRowAdapter.add(channel)
                }
                val header = HeaderItem(categoryName)
                rowsAdapter.add(ListRow(header, listRowAdapter))
            }

            adapter = rowsAdapter
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(activity, "Erro: $message", Toast.LENGTH_LONG).show()
        }
    }
}
