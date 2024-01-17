package com.explore.navgraphdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.explore.navgraphdemo.databinding.FragmentFirstBinding
import com.explore.navgraphdemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Marimuthu on 13/1/24.
 **/
@AndroidEntryPoint
class FirstFragment : Fragment() {
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

        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(
            OneDialogFragment.IS_OKAY_CLICKED
        )
            ?.observe(viewLifecycleOwner) { isClicked ->
                if (isClicked) {
                    Toast.makeText(requireActivity(), "Clicked - $isClicked", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        //This is an alternate method to handle callback if the livedata pass the last updated value and expecting the result from the specific dialog.
        /*val navBackStackEntry = navController.getBackStackEntry(R.id.firstFragment)
        val observer = LifecycleEventObserver { _, event ->
            if(event == Lifecycle.Event.ON_RESUME && navBackStackEntry.savedStateHandle.contains(OneDialogFragment.IS_OKAY_CLICKED)) {
                val result = navBackStackEntry.savedStateHandle.get<Boolean>(OneDialogFragment.IS_OKAY_CLICKED)
                result?.let { isClicked ->
                    if (isClicked) {
                        Toast.makeText(requireActivity(), "Clicked - $isClicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        navBackStackEntry.getLifecycle().addObserver(observer)
        viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _,event ->
            if(event == Lifecycle.Event.ON_DESTROY) {
                navBackStackEntry.getLifecycle().removeObserver(observer)
                Toast.makeText(requireActivity(), "Destroyed", Toast.LENGTH_SHORT)
                    .show()
            }
        })*/

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnDialog.setOnClickListener {
            navController.navigate(FirstFragmentDirections.actionFirstFragmentToOneDialogFragment())
        }

        binding.btnBottomSheet.setOnClickListener {
            navController.navigate(FirstFragmentDirections.actionFirstFragmentToBottomSheetDialogFragment())
        }
    }
}