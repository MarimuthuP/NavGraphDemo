package com.explore.navgraphdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.explore.navgraphdemo.databinding.FragmentFirstBinding
import com.explore.navgraphdemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Marimuthu on 13/1/24.
 **/
@AndroidEntryPoint
class FirstFragment: Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var mContext: Context
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)
        context?.let {
            mContext = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnFirst.setOnClickListener {
            navController.navigate(FirstFragmentDirections.actionFirstFragmentToOneDialogFragment())
        }
    }
}