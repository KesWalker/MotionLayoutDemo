package com.animationapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.animationapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentHomeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.bottomSheet)
        sheetBehavior.maxHeight = 600
        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("kesD", "onSlide: $slideOffset")
                binding.motionLayout.setInterpolatedProgress(slideOffset)
                binding.bottomSheet.bottomSheet.setInterpolatedProgress(slideOffset)
            }
        })
    }
}