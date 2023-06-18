package com.example.juicetray.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.juicetray.R
import com.example.juicetray.databinding.FragmentCheckoverBinding
import com.example.juicetray.databinding.FragmentOpenMenuBinding
import com.example.juicetray.model.OrderViewModel
import com.google.android.material.snackbar.Snackbar


class CheckoverFragment : Fragment() {

    private var _binding : FragmentCheckoverBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoverBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedViewModel.calculateTaxAndTotal()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

            fragment = this@CheckoverFragment
        }
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        val action = CheckoverFragmentDirections.actionCheckoverFragmentToPlaceOrderFragment()
        this.findNavController().navigate(action)

    }

    fun submitOrder() {

        Snackbar.make(binding.root, R.string.submit_order, Snackbar.LENGTH_SHORT).show()

        sharedViewModel.resetOrder()
        val action = CheckoverFragmentDirections.actionCheckoverFragmentToPlaceOrderFragment()
        this.findNavController().navigate(action)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}