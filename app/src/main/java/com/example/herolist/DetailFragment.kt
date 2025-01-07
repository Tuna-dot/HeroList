package com.example.herolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.BundleCompat.getSerializable
import com.bumptech.glide.Glide
import com.example.herolist.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() = with(binding) {
        arguments?.let {bundle ->
            val hero = bundle.getSerializable("key") as Hero
            textView.text = hero.name
            textViewDetail.text = hero.detail
            Glide.with(imageViewDetail)
                .load(hero.imageUrl)
                .into(imageViewDetail)
        }
    }

}