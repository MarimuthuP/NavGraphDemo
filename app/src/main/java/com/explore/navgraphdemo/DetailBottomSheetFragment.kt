package com.explore.navgraphdemo

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.explore.navgraphdemo.databinding.DialogBottomSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Marimuthu on 16/1/24.
 **/
@AndroidEntryPoint
class DetailBottomSheetFragment: BottomSheetDialogFragment() {

    private lateinit var binding: DialogBottomSheetFragmentBinding
    private lateinit var mContext: Context
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            enterTransition = Slide(Gravity.END)
            exitTransition = Slide(Gravity.END)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogBottomSheetFragmentBinding.inflate(layoutInflater)
        context?.let {
            mContext = it
        }
        return binding.root
    }

}