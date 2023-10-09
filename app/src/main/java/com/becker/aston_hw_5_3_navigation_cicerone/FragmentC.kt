package com.becker.aston_hw_5_3_navigation_cicerone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.becker.aston_hw_5_3_navigation_cicerone.FragmentB.Companion.PASSED_TEXT_FROM_B_TO_C_EXTRA
import com.becker.aston_hw_5_3_navigation_cicerone.databinding.FragmentCBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FragmentC(private val passedData: Bundle?) : Fragment(), Screen {

    private var textFromFragmentB: String? = null
    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun getFragmentScreen(): FragmentScreen {
        return FragmentScreen { FragmentC(passedData) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textFromFragmentB = passedData?.getString(PASSED_TEXT_FROM_B_TO_C_EXTRA)

        with(binding) {
            textFromB.text = textFromFragmentB

            buttonCtoD.setOnClickListener {
                val destination = FragmentD().getFragmentScreen()
                App.instance.getRouter().navigateTo(destination)
            }

            buttonBack.setOnClickListener {
                App.instance.getRouter().exit()
            }
        }
    }
}