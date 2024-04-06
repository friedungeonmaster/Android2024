package kz.android.historicalfigures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.android.historicalfigures.databinding.HistoricalFigureItemBinding

class Adapter : ListAdapter<HistoricalFigure, Adapter.HistoricalFigureViewHolder>(HistoricalFigureDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricalFigureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HistoricalFigureItemBinding.inflate(layoutInflater, parent, false)
        return HistoricalFigureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoricalFigureViewHolder, position: Int) {
        val historicalFigure = getItem(position)
        holder.bind(historicalFigure)
    }

    class HistoricalFigureViewHolder(private val binding: HistoricalFigureItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historicalFigure: HistoricalFigure) {
            with(binding) {
                tvName.text = historicalFigure.name
                tvTitle.text = historicalFigure.title
                tvBornDied.text = "Born: ${historicalFigure.info.born} - Died: ${historicalFigure.info.died}"
                tvOffice.text = "Office: ${historicalFigure.info.office.joinToString()}"
                tvNotableWork.text = "Notable Work: ${historicalFigure.info.notableWork.joinToString()}"
            }
        }
    }
}