package com.example.juicetray.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.juicetray.R
import com.example.juicetray.databinding.FragmentSideMenuBinding
import com.example.juicetray.model.OrderViewModel


class SideMenuFragment : Fragment() {

    private var _binding: FragmentSideMenuBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSideMenuBinding.inflate(inflater, container, false)
        val root = binding.root
        return  root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

            fragment = this@SideMenuFragment
        }
    }

    fun goToNextScreen() {
        val action = SideMenuFragmentDirections.actionSideMenuFragmentToComplementMenuFragment()
        this.findNavController().navigate(action)

    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        val action = SideMenuFragmentDirections.actionSideMenuFragmentToPlaceOrderFragment()
        this.findNavController().navigate(action)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

