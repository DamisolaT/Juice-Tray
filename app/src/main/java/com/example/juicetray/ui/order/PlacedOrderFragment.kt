package com.example.juicetray.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.juicetray.R
import com.example.juicetray.databinding.FragmentPlacedOrderBinding


class PlacedOrderFragment : Fragment() {

  private var _binding: FragmentPlacedOrderBinding? = null

    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlacedOrderBinding.inflate(inflater, container,false)
        val root:  View = binding.root

        binding.placedOrderBtn.setOnClickListener{
            val action = PlacedOrderFragmentDirections.actionPlacedOrderFragmentToOpenMenuFragment()
            this.findNavController().navigate(action)

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}