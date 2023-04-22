package com.youngwoo.woojooprofile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.youngwoo.domain.model.ProfileCardResult
import com.youngwoo.domain.model.ProfileCard
import com.youngwoo.woojooprofile.databinding.ActivityMainBinding
import com.youngwoo.woojooprofile.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObserve()
        viewModel.getMyPhotoCardList()
    }

    private fun setObserve() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.profileCards.collect {
                    when (it) {
                        is ProfileCardResult.Success -> {
                            setProfileCards(it.profileCards)
                        }
                        is ProfileCardResult.NonProfileCard -> {
                            setNonProfileCard()
                        }
                        else -> {
                            setNonProfileCard()
                        }
                    }
                }
            }
        }
    }

    private fun setProfileCards(profileCards: List<ProfileCard>) {

    }

    private fun setNonProfileCard() {
        binding.layoutNonProfileCard.visibility = View.VISIBLE
        binding.layoutProfileCards.visibility = View.GONE
    }
}