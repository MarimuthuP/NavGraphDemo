package com.explore.navgraphdemo

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.explore.navgraphdemo.databinding.DialogFragmentOneBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Marimuthu on 13/1/24.
 **/
@AndroidEntryPoint
class OneDialogFragment: DialogFragment() {
    private lateinit var binding: DialogFragmentOneBinding
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentOneBinding.inflate(layoutInflater)
        context?.let {
            mContext = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.attributes?.width = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes?.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnOkay.setOnClickListener {
            dismiss()
        }
    }
}