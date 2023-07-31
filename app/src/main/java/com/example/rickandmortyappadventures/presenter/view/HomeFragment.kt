package com.example.rickandmortyappadventures.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyappadventures.R
import com.example.rickandmortyappadventures.databinding.HomeFragmentBinding
import com.example.rickandmortyappadventures.domain.model.Personage
import com.example.rickandmortyappadventures.presenter.adapter.HomeListAdapter
import com.example.rickandmortyappadventures.presenter.viewModel.HomeViewModel
import com.example.rickandmortyappadventures.presenter.viewModel.SearchViewModel
import com.example.rickandmortyappadventures.utils.CharactersQueryTextListner
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var listAdapter: HomeListAdapter
    private val homeViewModel: HomeViewModel by viewModel()
    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        collectResult()
    }

    private fun setRecyclerView() {
        listAdapter = HomeListAdapter() { personage -> goToCharacterDetails(personage) }
        binding.listItemRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
        }
        binding.searchView.setOnQueryTextListener(
            onQueryTextListener()
        )
    }


    private fun collectResult() {
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.getCharacters().collectLatest {
                listAdapter.submitData(it)
            }
        }
    }

    private fun onQueryTextListener() = CharactersQueryTextListner { name ->
        searchCharacter(name)
    }

    private fun searchCharacter(searchValue: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.searchCharacters(searchValue).collectLatest {
                listAdapter.submitData(it)
            }
        }
    }

    private fun goToCharacterDetails(personage: Personage) {
        val bundle = bundleOf("personage" to personage)
        findNavController().navigate(R.id.action_homeFragment_to_characterDetailsFragment, bundle)
    }
}