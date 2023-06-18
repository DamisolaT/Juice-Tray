package com.example.juicetray.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.juicetray.databinding.FragmentOpenMenuBinding

import com.example.juicetray.model.OrderViewModel



class OpenMenuFragment : Fragment() {

    private  var _binding: FragmentOpenMenuBinding? = null

    private val binding get() = _binding!!

    private  val shareViewModel: OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOpenMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return  root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = shareViewModel

            fragment = this@OpenMenuFragment
        }
    }

    fun goToNextScreen (){
        val action = OpenMenuFragmentDirections.actionOpenMenuFragmentToSideMenuFragment()
        this.findNavController().navigate(action)

    }

   fun cancelOrder() {
       shareViewModel.resetOrder()
       val action = OpenMenuFragmentDirections.actionOpenMenuFragmentToPlacedOrderFragment()
       this.findNavController().navigate(action)

   }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }




