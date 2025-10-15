package com.flextv.player.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Classe de modelo que representa um canal.
 * Também é uma entidade para o banco de dados Room.
 */
@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey val id: String, // Geralmente extraído de tvg-id do M3U
    val name: String,
    val group: String,
    val logoUrl: String?,
    val url: String,
    var isFavorite: Boolean = false
)
