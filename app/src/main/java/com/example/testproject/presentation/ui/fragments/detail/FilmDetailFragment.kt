package com.example.testproject.presentation.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testproject.R
import com.example.testproject.databinding.FragmentFilmDetailBinding
import com.example.testproject.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmDetailFragment :
    BaseFragment<FragmentFilmDetailBinding, FilmDetailViewModel>(R.layout.fragment_film_detail) {

    override val binding by viewBinding(FragmentFilmDetailBinding::bind)
    override val viewModel: FilmDetailViewModel by viewModels()
    private val args: FilmDetailFragmentArgs by navArgs()

    override fun setupSubscribes() {
        binding.titlAnimeDetail.text = args.model
        binding.orTitlAnimeDetail.text = args.model
    }
}