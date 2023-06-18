package com.example.juicetray.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.juicetray.R
import com.example.juicetray.databinding.FragmentComplementMenuBinding
import com.example.juicetray.model.OrderViewModel


class ComplementMenuFragment : Fragment() {

    private  var _binding: FragmentComplementMenuBinding? = null

    private val binding get() = _binding!!

    private  val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComplementMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

            fragment = this@ComplementMenuFragment
        }

    }

    fun goToNextScreen(){
        val action = ComplementMenuFragmentDirections.actionComplementMenuFragmentToCheckoverFragment()
        this.findNavController().navigate(action)

    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        val action = ComplementMenuFragmentDirections.actionComplementMenuFragmentToPlaceOrderFragment()
        this.findNavController().navigate(action)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   }

