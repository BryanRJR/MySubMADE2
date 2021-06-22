package com.dicoding.mysubmade2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.mysubmade2.databinding.FragmentAboutBinding
import com.dicoding.mysubmade2.databinding.FragmentHomeBinding
import com.dicoding.mysubmade2.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class About : Fragment() {


    private var _fragbinding: FragmentAboutBinding? = null
    private val binding get() = _fragbinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragbinding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

}