package com.example.aviatickets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aviatickets.R
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.databinding.FragmentOfferListBinding
import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.service.FakeService


class OfferListFragment : Fragment() {



    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    private var currentOffers: List<Offer> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchOffers()
        setupUI()
    }

    private fun fetchOffers() {
        FakeService.fetchOffersFromApi { offers ->
            offers?.let {
                currentOffers = it
                adapter.setItems(it)  // Update the adapter with the fetched offers
            }
        }
    }

    private fun setupUI() {
        with(binding) {
            offerList.adapter = adapter

            sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.sort_by_price -> sortOffersByPrice()
                    R.id.sort_by_duration -> sortOffersByDuration()
                }
            }
        }
    }
    private fun sortOffersByPrice() {
        val sortedOffers = currentOffers.sortedBy { it.price }
        adapter.setItems(sortedOffers)
    }
    private fun sortOffersByDuration() {
        val sortedOffers = currentOffers.sortedBy { it.flight.duration }
        adapter.setItems(sortedOffers)
    }
}