package com.becker.aston_hw_5_3_navigation_cicerone

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.becker.aston_hw_5_3_navigation_cicerone.databinding.FragmentABinding
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FragmentA : Fragment(), Screen {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.exit))
                    .setMessage(getString(R.string.are_you_really_want))
                    .setPositiveButton(getString(R.string.yes)) { _, _ -> requireActivity().finish() }
                    .setNegativeButton(getString(R.string.no), null)
                    .show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAtoB.setOnClickListener {
            val destination = FragmentB().getFragmentScreen()
            App.instance.getRouter().navigateTo(destination)
        }
    }

    override fun getFragmentScreen(): FragmentScreen {
        return FragmentScreen { this }
    }
}