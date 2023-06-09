package com.example.testproject.presentation.ui.fragments

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testproject.R
import com.example.testproject.databinding.FragmentFilmBinding
import com.example.testproject.presentation.base.BaseFragment
import com.example.testproject.presentation.models.toUI
import com.example.testproject.presentation.ui.adapter.FilmAdapter
import com.example.testproject.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmFragment : BaseFragment<FragmentFilmBinding, FilmViewModel>(R.layout.fragment_film) {

    override val binding by viewBinding(FragmentFilmBinding::bind)
    override val viewModel: FilmViewModel by viewModels()
    private val filmAdapter = FilmAdapter()
//    (this::onItemClick)

    override fun initialize() {
        binding.recView.adapter = filmAdapter
    }

    override fun setupSubscribes() {
        subscribeToFetchAnime()
    }

    private fun subscribeToFetchAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchFilm().collect {
                    when (it) {
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                        }

                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            filmAdapter.submitList(it.data?.map {
                                it.toUI()
                            })
                        }
                    }
                }
            }
        }
    }

//    private fun onItemClick(model: FilmUI) {
//        findNavController().navigate(
//            . actionHomeFragmentToAnimeDetailFragment (model)
//        )
//    }
}