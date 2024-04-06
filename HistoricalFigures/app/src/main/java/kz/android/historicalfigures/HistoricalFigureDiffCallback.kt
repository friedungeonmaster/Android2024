package kz.android.historicalfigures

import androidx.recyclerview.widget.DiffUtil

object HistoricalFigureDiffCallback : DiffUtil.ItemCallback<HistoricalFigure>() {
    override fun areItemsTheSame(oldItem: HistoricalFigure, newItem: HistoricalFigure): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: HistoricalFigure, newItem: HistoricalFigure): Boolean {
        return oldItem == newItem
    }
}