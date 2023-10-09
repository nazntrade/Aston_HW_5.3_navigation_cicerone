package com.becker.aston_hw_5_3_navigation_cicerone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_5_3_navigation_cicerone.databinding.FragmentBBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen


class FragmentB : Fragment(), Screen {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun getFragmentScreen(): FragmentScreen {
        return FragmentScreen { this }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonBtoC.setOnClickListener {
                val bundleToFragmentC = Bundle()
                bundleToFragmentC.putString(PASSED_TEXT_FROM_B_TO_C_EXTRA, "Hello Fragment C")

                val destination = FragmentC(bundleToFragmentC).getFragmentScreen()
                App.instance.getRouter().navigateTo(destination)
            }

            buttonBack.setOnClickListener {
                App.instance.getRouter().exit()
            }
        }
    }

    companion object {
        const val PASSED_TEXT_FROM_B_TO_C_EXTRA = "PASSED_TEXT_FROM_B_TO_C_EXTRA"
    }
}