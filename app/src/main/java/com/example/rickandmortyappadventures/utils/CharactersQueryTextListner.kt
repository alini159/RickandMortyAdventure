package com.example.rickandmortyappadventures.utils

import androidx.appcompat.widget.SearchView

class CharactersQueryTextListner(private val searchCharacter: (String) -> Unit) :
    SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String): Boolean {
        searchCharacter(query)
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchCharacter(newText)
        return false
    }
}