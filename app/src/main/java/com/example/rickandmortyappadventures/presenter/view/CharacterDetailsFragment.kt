package com.example.rickandmortyappadventures.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rickandmortyappadventures.databinding.CharacterDetailsFragmentBinding
import com.example.rickandmortyappadventures.domain.model.Personage

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: CharacterDetailsFragmentBinding
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingView(args)
    }

    private fun bindingView(args: CharacterDetailsFragmentArgs) {
        val personage: Personage = args.personage

        context?.let {
            Glide.with(it)
                .load(personage.image!!.toUri())
                .apply(RequestOptions.circleCropTransform())
                .into(binding.detailsImage)
        }

        binding.apply {
            detailsName.text = personage.name
            detailsRace.text = personage.species
            detailsOrigin.text = personage.origin!!.name!!.split(" ").first()

            detailStatus.text = personage.img
            detailGender.text = personage.gender
            detailType.text = personage.type
            detailOrigin.text = detailsOrigin.text
            detailLocation.text = personage.location!!.name!!.split(" ").first()

            backpressButton.setOnClickListener { goToHome() }
        }
    }

    private fun goToHome() {
        findNavController().popBackStack()
    }
}
