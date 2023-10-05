package com.becker.aston_hw_5_3_navigation_cicerone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_5_3_navigation_cicerone.databinding.FragmentDBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FragmentD : Fragment(), Screen {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun getFragmentScreen(): FragmentScreen {
        return FragmentScreen { this }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDtoA.setOnClickListener {
            val destination = FragmentA().getFragmentScreen()
            App.instance.getRouter().newRootChain(destination)
        }
    }
}